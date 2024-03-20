package tw.taipei.scteam.exception.response;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import tw.taipei.scteam.exception.enumeration.BusinessExceptionType;

@Getter
@Setter
public class ErrorsResponse {
  private BusinessExceptionType type;
  private Map<String, String> errors;

  public static ErrorsResponse of(BusinessExceptionType type, Map<String, String> errors) {
    ErrorsResponse res = new ErrorsResponse();
    res.type = type;
    res.errors = errors;
    return res;
  }
}
