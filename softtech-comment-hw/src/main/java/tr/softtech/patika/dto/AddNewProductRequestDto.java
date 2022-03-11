package tr.softtech.patika.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.softtech.patika.enums.Category;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class AddNewProductRequestDto {

    @NotNull
    private String name;
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Category category;
}
