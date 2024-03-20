package tw.taipei.scteam.common.exception.exception;

import tw.taipei.scteam.common.exception.enumeration.BusinessExceptionType;

public class InternalServerErrorException extends CustomException {

  public InternalServerErrorException() {
    this.type = BusinessExceptionType.INTERNAL_SERVER_ERROR;
    this.error = "伺服器錯誤，請稍後再試。";
  }

}
