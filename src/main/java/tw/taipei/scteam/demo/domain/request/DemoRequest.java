package tw.taipei.scteam.demo.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "演示用請求")
public class DemoRequest {

  @NotNull(message = "Product name is undefined.")
  @NotBlank(message = "Name is mandatory")
  @Schema(description = "產品名稱", example = "iPhone 15 Plus 128G")
  private String name;

  @NotNull(message = "Product price is undefined.")
  @Min(value = 0, message = "Price should be greater or equal to 0.")
  @Schema(description = "產品價格", example = "32900")
  private Integer price;
}
