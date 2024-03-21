package tw.taipei.scteam.demo.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tw.taipei.scteam.demo.domain.request.DemoRequest;
import tw.taipei.scteam.demo.domain.response.DemoResponse;
import tw.taipei.scteam.exception.response.ErrorResponse;
import tw.taipei.scteam.exception.response.ErrorsResponse;

@Tag(name = "Demo 範例", description = "Swagger3 API 演示")
public interface DemoApi {

  @Operation(summary = "拋出錯誤", description = "當number介於1到3之間時Service主動拋出錯誤")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "成功", content = {
          @Content(schema = @Schema(implementation = DemoResponse.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "400", description = "無效語法", content = {
          @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "422", description = "拒絕處理", content = {
          @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "500", description = "伺服器錯誤", content = {
          @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json") })
  })
  ResponseEntity<?> method1(Integer number);

  @Operation(summary = "驗證", description = "Body 放入空物件 { } 即可測試 @Valid")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "成功", content = {
          @Content(schema = @Schema(implementation = DemoResponse.class), mediaType = "application/json") }),
      @ApiResponse(responseCode = "400", description = "無效語法", content = {
          @Content(schema = @Schema(implementation = ErrorsResponse.class), mediaType = "application/json") }),
  })
  ResponseEntity<?> method2(DemoRequest demoRequest);
}