package com.mypr.util;

public class CalisthenicsException extends RuntimeException {

  public CalisthenicsException (String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super (message, cause, enableSuppression, writableStackTrace);
  }

  public CalisthenicsException(String message, Throwable cause) {
    super(message, cause);
  }

  public CalisthenicsException(String message) {
    super(message);
  }

  public CalisthenicsException(Throwable cause) {
    super(cause);
  }

}
