package com.Arthur.Lojinha.routes;

import com.Arthur.Lojinha.models.ProductModel;
import com.Arthur.Lojinha.models.ResponseModel;
import com.Arthur.Lojinha.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin(origins = "*")
public class ProductController
{
    @Autowired
    private ProductServices productServices;

    @GetMapping("/")
    public Iterable<ProductModel> listar()
    {
        return productServices.listar();
    }
    @PostMapping("/produtos")
    public ResponseEntity<?> cadastrar(@RequestBody ProductModel productModel)
    {
        return productServices.cadastrar(productModel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> apagar(@PathVariable long id)
    {
        return productServices.apagar(id);
    }
}
