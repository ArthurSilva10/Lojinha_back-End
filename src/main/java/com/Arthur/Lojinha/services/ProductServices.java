package com.Arthur.Lojinha.services;

import com.Arthur.Lojinha.models.ProductModel;
import com.Arthur.Lojinha.models.ResponseModel;
import com.Arthur.Lojinha.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServices
{
    @Autowired
    private ProductRepository action;

    @Autowired
    private ResponseModel response;

    public Iterable<ProductModel> listar()
    {
        return action.findAll();
    }

    public ResponseEntity<?> cadastrar(ProductModel productModel)
    {
        if(productModel.getImagem().equals(""))
        {
            response.setResposta("insira uma imagem");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        else if (productModel.getMarca() == "")
        {
            response.setResposta("insira o nome da marca");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        else if(productModel.getNome().equals(""))
        {
            response.setResposta("insira o nome do produto");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        else if(productModel.getValor() < 0)
        {
            response.setResposta("insira um valor válido");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        else
        {
            action.save(productModel);
            return new ResponseEntity<ProductModel>(productModel, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseModel> apagar(long id)
    {
        response.setResposta("produto deletado");
        action.deleteById(id);
        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
