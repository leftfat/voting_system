package tw.taipei.scteam.exception.exception;

import tw.taipei.scteam.exception.enumeration.BusinessExceptionType;

public class UnprocessableEntityException extends CustomException {

  public UnprocessableEntityException(String error) {
    super(error);
    this.type = BusinessExceptionType.UNPROCESSABLEL_ENTITY_ERROR;
  }

}
