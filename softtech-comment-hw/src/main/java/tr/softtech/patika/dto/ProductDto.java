package tr.softtech.patika.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.softtech.patika.enums.Category;

import java.math.BigDecimal;
import java.util.Date;

@Data
@SuperBuilder
public class ProductDto {

    private String product_id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Date createDate;
    private Date updateDate;
}
