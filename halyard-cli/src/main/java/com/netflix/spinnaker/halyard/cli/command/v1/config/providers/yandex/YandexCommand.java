package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.AbstractNamedProviderCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;

@Parameters(separators = "=")
public class YandexCommand extends AbstractNamedProviderCommand {
    @Override
    protected String getProviderName() {
        return Provider.ProviderType.YANDEX.getName();
    }
    
    public YandexCommand(){
        super();
        registerSubcommand(new YandexAccountCommand());
        registerSubcommand(new YandexBakeryCommand());
    }
}
