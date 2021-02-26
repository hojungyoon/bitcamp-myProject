package com.mypr.util;

public class BodaybuildingException extends RuntimeException {

  public BodaybuildingException (String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super (message, cause, enableSuppression, writableStackTrace);
  }

  public BodaybuildingException(String message, Throwable cause) {
    super(message, cause);
  }

  public BodaybuildingException(String message) {
    super(message);
  }

  public BodaybuildingException(Throwable cause) {
    super(cause);
  }

}
