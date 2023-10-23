package com.Arthur.Lojinha.repository;

import com.Arthur.Lojinha.models.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel, Long>
{

}
