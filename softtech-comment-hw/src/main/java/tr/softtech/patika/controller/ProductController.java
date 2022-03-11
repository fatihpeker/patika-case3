package tr.softtech.patika.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.softtech.patika.dto.AddNewProductRequestDto;
import tr.softtech.patika.service.CommentService;
import tr.softtech.patika.service.ProductService;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("addProduct")
    public ResponseEntity addNewProduct(@Valid @RequestBody AddNewProductRequestDto addNewProductRequestDto){
        return new ResponseEntity<>(productService.addNewProduct(addNewProductRequestDto), HttpStatus.CREATED);
    }

    //Tüm ürüleri getiren servis
    @GetMapping("getAllProduct")
    public ResponseEntity getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("getProductById")
    public ResponseEntity getProductById(@RequestParam String id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("deleteProduct")
    public ResponseEntity deleteProduct(@RequestParam String id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("updatePrice")
    public ResponseEntity updatePrice(@RequestParam String id, @RequestParam BigDecimal price){
        return ResponseEntity.ok(productService.updatePrice(id, price));
    }
}
