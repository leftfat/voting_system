package tw.taipei.scteam.common.exception.exception;


import lombok.Getter;
import tw.taipei.scteam.common.exception.enumeration.BusinessExceptionType;

@Getter
public abstract class CustomException extends RuntimeException {

  protected BusinessExceptionType type;
  protected String error;

  public CustomException() {
  }

  public CustomException(String error) {
    this.error = error;
  }
}
