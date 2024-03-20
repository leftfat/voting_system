package tw.taipei.scteam.common.exception.exception;

import tw.taipei.scteam.common.exception.enumeration.BusinessExceptionType;

public class IdNotFoundException extends CustomException {

  public IdNotFoundException() {
    this.type = BusinessExceptionType.ID_NOT_FOUND;
    this.error = "伺服器無法處理格式錯誤的要求，請勿重試。";
  }

}
