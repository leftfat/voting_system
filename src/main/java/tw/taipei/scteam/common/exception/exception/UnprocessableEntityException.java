package tw.taipei.scteam.common.exception.exception;

import tw.taipei.scteam.common.exception.enumeration.BusinessExceptionType;

public class UnprocessableEntityException extends CustomException {

  public UnprocessableEntityException(String error) {
    super(error);
    this.type = BusinessExceptionType.UNPROCESSABLEL_ENTITY_ERROR;
  }

}
