package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.AbstractBakeryCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;

@Parameters(separators = "=")
public class YandexBakeryCommand extends AbstractBakeryCommand {

  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  public YandexBakeryCommand() {
    super();
    registerSubcommand(new YandexEditBakeryDefaultsCommand());
    registerSubcommand(new YandexBaseImageCommand());
  }
}
