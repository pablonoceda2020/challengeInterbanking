package com.interbanking.challenge.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

  ENTERPRISE_NOT_FOUND("ERR_ENTERPRISE_001", "Enterprise not found."),
  INVALID_ENTERPRISE("ERR_ENTERPRISE_002", "Invalid Enterprise parameters."),
  GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

  private final String code;
  private final String message;

  ErrorCatalog(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
