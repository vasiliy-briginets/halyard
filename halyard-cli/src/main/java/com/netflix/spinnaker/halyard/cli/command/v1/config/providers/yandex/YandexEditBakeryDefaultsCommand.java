package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractEditBakeryDefaultsCommand;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.BakeryCommandProperties;
import com.netflix.spinnaker.halyard.config.model.v1.node.BakeryDefaults;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudBakeryDefaults;

@Parameters(separators = "=")
public class YandexEditBakeryDefaultsCommand
    extends AbstractEditBakeryDefaultsCommand<YandexCloudBakeryDefaults> {
  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  @Parameter(
      names = "--template-file",
      description = BakeryCommandProperties.TEMPLATE_FILE_DESCRIPTION)
  private String templateFile;

  @Parameter(names = "--zone", description = "Set the default zone your images will be baked in.")
  private String zone;

  @Override
  protected BakeryDefaults editBakeryDefaults(YandexCloudBakeryDefaults bakeryDefaults) {
    bakeryDefaults.setZone(isSet(zone) ? zone : bakeryDefaults.getZone());
    bakeryDefaults.setTemplateFile(
        isSet(templateFile) ? templateFile : bakeryDefaults.getTemplateFile());
    return bakeryDefaults;
  }
}
