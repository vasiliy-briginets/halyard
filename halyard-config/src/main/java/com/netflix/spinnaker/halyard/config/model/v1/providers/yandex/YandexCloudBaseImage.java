package com.netflix.spinnaker.halyard.config.model.v1.providers.yandex;

import com.netflix.spinnaker.halyard.config.model.v1.node.BaseImage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class YandexCloudBaseImage
    extends BaseImage<
        YandexCloudBaseImage.YandexImageSettings,
        YandexCloudBaseImage.YandexVirtualizationSettings> {
  private YandexCloudBaseImage.YandexImageSettings baseImage;
  private YandexCloudBaseImage.YandexVirtualizationSettings virtualizationSettings;

  @EqualsAndHashCode(callSuper = true)
  @Data
  @ToString(callSuper = true)
  public static class YandexImageSettings extends BaseImage.ImageSettings {
    Boolean imageFamily;
  }

  @Data
  @ToString
  public static class YandexVirtualizationSettings {
    String sourceImageName;
    String sourceImageFamily;
  }
}
