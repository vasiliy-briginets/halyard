package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.providers.account.AbstractAddAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.node.Account;
import com.netflix.spinnaker.halyard.config.model.v1.node.Provider;
import com.netflix.spinnaker.halyard.config.model.v1.providers.yandex.YandexCloudAccount;

@Parameters(separators = "=")
public class YandexAddAccountCommand extends AbstractAddAccountCommand {
  @Parameter(
      names = "--account-type",
      description = YandexCommandProperties.ACCOUNT_TYPE_DESCRIPTION)
  private String accountType;

  @Parameter(names = "--json-path", description = YandexCommandProperties.JSON_PATH_DESCRIPTION)
  private String jsonPath;

  @Parameter(
      names = "--folder-id",
      description = YandexCommandProperties.FOLDER_ID_DESCRIPTION,
      required = true)
  private String folder;

  @Override
  protected String getProviderName() {
    return Provider.ProviderType.YANDEX.getName();
  }

  @Override
  protected Account buildAccount(String accountName) {
    YandexCloudAccount account = (YandexCloudAccount) new YandexCloudAccount().setName(accountName);
    account.setFolder(folder).setJsonPath(jsonPath).setAccountType(accountType);
    return account;
  }

  @Override
  protected Account emptyAccount() {
    return new YandexCloudAccount();
  }
}
