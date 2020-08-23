package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.AbstractAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;

@Parameters(separators = "=")
public class YandexAccountCommand extends AbstractAccountCommand {
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  public YandexAccountCommand() {
    super();
    registerSubcommand(new YandexAddAccountCommand());
    registerSubcommand(new YandexEditAccountCommand());
  }
}
