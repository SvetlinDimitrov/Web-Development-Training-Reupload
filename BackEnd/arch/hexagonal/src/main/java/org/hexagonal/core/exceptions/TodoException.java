package org.hexagonal.core.exceptions;

public class TodoException extends RuntimeException{

  public TodoException(String message) {
    super(message);
  }

  public TodoException(String message, Throwable cause) {
    super(message, cause);
  }

  public TodoException(Throwable cause) {
    super(cause);
  }

  public TodoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
