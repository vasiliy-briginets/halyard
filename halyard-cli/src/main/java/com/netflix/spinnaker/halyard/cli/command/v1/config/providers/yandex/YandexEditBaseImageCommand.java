package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractEditBaseImageCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.BaseImage;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudBaseImage;

@Parameters(separators = "=")
public class YandexEditBaseImageCommand extends AbstractEditBaseImageCommand<YandexCloudBaseImage> {
  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  @Parameter(
      names = "--source-image-name",
      description = YandexCommandProperties.SOURCE_IMAGE_DESCRIPTION)
  private String sourceImageName;

  @Parameter(
      names = "--source-image-family",
      description = YandexCommandProperties.SOURCE_IMAGE_FAMILY_DESCRIPTION)
  private String sourceImageFamily;

  @Parameter(names = "--image-family", description = "No desc")
  private Boolean imageFamily;

  @Override
  protected BaseImage editBaseImage(YandexCloudBaseImage baseImage) {
    YandexCloudBaseImage.YandexImageSettings imageSettings = baseImage.getBaseImage();
    imageSettings =
        imageSettings != null ? imageSettings : new YandexCloudBaseImage.YandexImageSettings();
    imageSettings.setImageFamily(isSet(imageFamily) ? imageFamily : imageSettings.getImageFamily());
    baseImage.setBaseImage(imageSettings);

    YandexCloudBaseImage.YandexVirtualizationSettings virtualizationSettings =
        baseImage.getVirtualizationSettings();
    virtualizationSettings =
        virtualizationSettings != null
            ? virtualizationSettings
            : new YandexCloudBaseImage.YandexVirtualizationSettings();
    virtualizationSettings.setSourceImageName(
        isSet(sourceImageName) ? sourceImageName : virtualizationSettings.getSourceImageName());
    virtualizationSettings.setSourceImageFamily(
        isSet(sourceImageFamily)
            ? sourceImageFamily
            : virtualizationSettings.getSourceImageFamily());
    baseImage.setVirtualizationSettings(virtualizationSettings);
    return baseImage;
  }
}
