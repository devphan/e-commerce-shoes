package com.ecommerce.shoes.controller.api;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.request.ProductReq;
import com.ecommerce.shoes.repository.ProductRepository;
import com.ecommerce.shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(productService.findAllProductInfo());
    }

    @GetMapping("/sale")
    public ResponseEntity<?> getListProductSale() {
        List<Product> result = productService.getListProductSale();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(ProductReq req) {
        productService.saveProduct(req);
        return ResponseEntity.ok("CREATE SUCCESS");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ProductReq req, @PathVariable int id) {
        productService.updateProduct(id, req);
        return ResponseEntity.ok("UPDATE SUCCESS");
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok("DELETE SUCCESS");
    }


}
