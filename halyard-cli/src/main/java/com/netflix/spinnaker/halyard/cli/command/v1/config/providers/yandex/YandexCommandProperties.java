package com.netflix.spinnaker.halyard.cli.command.v1.config.providers.yandex;

public class YandexCommandProperties {
  static final String ACCOUNT_TYPE_DESCRIPTION = "The type of account.";
  static final String JSON_PATH_DESCRIPTION =
      "The path to a JSON service account that Spinnaker will use as credentials. ";
  static final String FOLDER_ID_DESCRIPTION = "The ID of the folder to use.";
  static final String SOURCE_IMAGE_DESCRIPTION =
      "The source image. If both source image and source image family are set, source image will take precedence.";
  static final String SOURCE_IMAGE_FAMILY_DESCRIPTION =
      "The source image family to create the image from. The newest, non-deprecated image is used.";
}
