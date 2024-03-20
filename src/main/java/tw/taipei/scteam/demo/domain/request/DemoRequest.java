package tw.taipei.scteam.demo.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DemoRequest {

  @NotNull(message = "Product name is undefined.")
  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotNull(message = "Product price is undefined.")
  @Min(value = 0, message = "Price should be greater or equal to 0.")
  private Integer price;
}
