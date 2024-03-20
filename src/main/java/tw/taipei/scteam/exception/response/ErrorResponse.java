package tw.taipei.scteam.exception.response;

import lombok.Getter;
import lombok.Setter;
import tw.taipei.scteam.exception.enumeration.BusinessExceptionType;

@Getter
@Setter
public class ErrorResponse {

  private BusinessExceptionType type;
  private String error;

  public static ErrorResponse of(BusinessExceptionType type, String error) {
    ErrorResponse res = new ErrorResponse();
    res.type = type;
    res.error = error;
    return res;
  }
}
