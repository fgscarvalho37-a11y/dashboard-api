package com.felipe.dashboard_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class SaleDTO {

    @NotBlank(message = "Produto é obrigatório")
    private String product;

    @NotBlank(message = "Categoria é obrigatória")
    private String category;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false)
    private Double amount;

    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 1)
    private Integer quantity;

    @NotNull(message = "Data é obrigatória")
    private LocalDate date;
}