package com.netflix.spinnaker.halyard.config.model.v1.providers.yandex;

import com.netflix.spinnaker.halyard.config.model.v1.node.BakeryDefaults;
import com.netflix.spinnaker.halyard.config.model.v1.providers.google.GoogleBaseImage;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class YandexCloudBakeryDefaults extends BakeryDefaults<GoogleBaseImage> {
  private String zone;
}
