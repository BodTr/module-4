package com.spring.books_management.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SavingBookDTO {
    @NotEmpty(message = "Trường title trống")
    private String title;

    @NotEmpty(message = "Trường publisher trống")
    private String publisher;

    @NotEmpty(message = "Trường isbn trống")
    @Pattern(regexp = "^\\d{13}$", message = "Trường isbn phải có đúng 13 số")
    private String isbn;

    @NotEmpty(message = "Trường genre trống")
    private String genre;

    @NotNull(message = "Trường pages_count trống")
    @Min(value = 1, message = "Trương pages_count phải có giá trị > 0")
    private int pages_count;

    @NotNull(message = "Trường price trống")
    @DecimalMin(value = "0", message = "Trường price phải có giá trị >= 0")
    private double price;

    @NotNull(message = "Trường author chưa chọn")
    private Long author_id;
}
