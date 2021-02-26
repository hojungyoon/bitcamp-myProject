package com.mypr.util;

public class BodyCheckException extends RuntimeException {

  public BodyCheckException (String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super (message, cause, enableSuppression, writableStackTrace);
  }

  public BodyCheckException(String message, Throwable cause) {
    super(message, cause);
  }

  public BodyCheckException(String message) {
    super(message);
  }

  public BodyCheckException(Throwable cause) {
    super(cause);
  }

}
