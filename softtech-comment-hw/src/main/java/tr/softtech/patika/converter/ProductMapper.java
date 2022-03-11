package tr.softtech.patika.converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import tr.softtech.patika.dto.AddNewProductRequestDto;
import tr.softtech.patika.dto.ProductDto;
import tr.softtech.patika.model.Product;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product addProductRequestDtoToProduct(AddNewProductRequestDto addNewProductRequestDto);

    ProductDto productToProductDto(Product product);

    List<ProductDto> productListToProductDtoList(List<Product> productList);

}
