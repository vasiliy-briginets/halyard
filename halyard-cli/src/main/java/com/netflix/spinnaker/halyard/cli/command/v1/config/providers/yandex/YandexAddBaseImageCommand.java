package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractAddBaseImageCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.BaseImage;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudBaseImage;

@Parameters(separators = "=")
public class YandexAddBaseImageCommand extends AbstractAddBaseImageCommand {
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
  protected BaseImage buildBaseImage(String baseImageId) {
    YandexCloudBaseImage baseImage = new YandexCloudBaseImage();
    YandexCloudBaseImage.YandexImageSettings imageSettings =
        new YandexCloudBaseImage.YandexImageSettings();
    imageSettings.setImageFamily(imageFamily);
    baseImage.setBaseImage(imageSettings);

    YandexCloudBaseImage.YandexVirtualizationSettings virtualizationSettings =
        new YandexCloudBaseImage.YandexVirtualizationSettings();
    virtualizationSettings.setSourceImageName(sourceImageName);
    virtualizationSettings.setSourceImageFamily(sourceImageFamily);
    baseImage.setVirtualizationSettings(virtualizationSettings);
    return baseImage;
  }
}
