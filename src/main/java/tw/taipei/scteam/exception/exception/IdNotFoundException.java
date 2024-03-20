package tw.taipei.scteam.exception.exception;

import tw.taipei.scteam.exception.enumeration.BusinessExceptionType;

public class IdNotFoundException extends CustomException {

  public IdNotFoundException() {
    this.type = BusinessExceptionType.ID_NOT_FOUND;
    this.error = "伺服器無法處理格式錯誤的要求，請勿重試。";
  }

}
