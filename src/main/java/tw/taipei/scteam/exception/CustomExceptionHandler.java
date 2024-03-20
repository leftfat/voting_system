package tw.taipei.scteam.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tw.taipei.scteam.exception.enumeration.BusinessExceptionType;
import tw.taipei.scteam.exception.exception.CustomException;
import tw.taipei.scteam.exception.exception.IdNotFoundException;
import tw.taipei.scteam.exception.exception.UnprocessableEntityException;
import tw.taipei.scteam.exception.response.ErrorResponse;
import tw.taipei.scteam.exception.response.ErrorsResponse;

@RestControllerAdvice(basePackages = "tw.taipei.scteam")
public class CustomExceptionHandler {

  // 處理前端參數錯誤例外
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorsResponse> handleInvalidArgument(MethodArgumentNotValidException e) {

    Map<String, String> errors = new HashMap<>();

    e.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    ErrorsResponse response = ErrorsResponse.of(BusinessExceptionType.INVALID_PARAMETER_VALUE, errors);

    return ResponseEntity.badRequest().body(response);
  }

  // 處理自定義例外
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {

    ErrorResponse response = ErrorResponse.of(e.getType(), e.getError());

    if (e instanceof IdNotFoundException)
      return ResponseEntity.badRequest().body(response);
    if (e instanceof UnprocessableEntityException)
      return ResponseEntity.unprocessableEntity().body(response);

    return ResponseEntity.internalServerError().body(response);

  }

}
