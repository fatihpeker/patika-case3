package tr.softtech.patika.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.softtech.patika.converter.ProductMapper;
import tr.softtech.patika.dto.AddNewProductRequestDto;
import tr.softtech.patika.dto.ProductDto;
import tr.softtech.patika.exception.ItemNotFoundException;
import tr.softtech.patika.model.Product;
import tr.softtech.patika.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final BaseEntityService<Product> baseEntityService;

    public ProductDto addNewProduct (AddNewProductRequestDto addNewProductRequestDto){
        Product product = ProductMapper.INSTANCE.addProductRequestDtoToProduct(addNewProductRequestDto);
        baseEntityService.addBaseEntityProperties(product);
        productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    public List<ProductDto> getAllProduct(){
        List<ProductDto> productDtoList = ProductMapper.INSTANCE.productListToProductDtoList(productRepository.findAll());
        return productDtoList;
    }

    public ProductDto getProductById(String id){
        Product product = productRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("product not found"));
       ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(product);
       return productDto;
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

    public ProductDto updatePrice(String id, BigDecimal price){
        Product product = productRepository.getById(id);
        product.setPrice(price);
        baseEntityService.addBaseEntityProperties(product);
        ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(productRepository.save(product));
        return productDto;
    }

    //uygulama içinde productDto değil product gerektiğinde
    public Product getById(String id){
        return productRepository.getById(id);
    }



}
