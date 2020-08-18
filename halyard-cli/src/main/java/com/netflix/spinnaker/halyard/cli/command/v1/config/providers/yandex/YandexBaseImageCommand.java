package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.bakery.AbstractBaseImageCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;

public class YandexBaseImageCommand extends AbstractBaseImageCommand {
  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  public YandexBaseImageCommand() {
    super();
    registerSubcommand(new YandexAddBaseImageCommand());
    registerSubcommand(new YandexEditBaseImageCommand());
  }
}
