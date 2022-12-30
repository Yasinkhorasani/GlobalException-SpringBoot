package com.controllerAdvice.Annotation.service;

import com.controllerAdvice.Annotation.entity.Product;
import com.controllerAdvice.Annotation.exception.NoDataFoundException;
import com.controllerAdvice.Annotation.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static List<Product> list = new ArrayList<>();

    static {
      /*  list.add(new Product(1, "ifhon x", 500.00));
        list.add(new Product(2, "Galaxy Note", 750.00));
        list.add(new Product(3, "OnePlus", 600.00));
        list.add(new Product(4, "Galaxy x", 800.00));
        list.add(new Product(5, "ifhon 14", 1200.00));*/
    }

    public List<Product> getList() {
       if(list.isEmpty()){
           throw new NoDataFoundException("Product is not existiert");
       }
        return list;
    }

    public Product getProduct(Integer id) {
        Optional<Product> theProduct = list.stream().filter(p -> p.getId() == id).findFirst();
        if (!theProduct.isPresent()){
            throw new ResourceNotFoundException("Product is not Found for id"+ id);
        }
        return theProduct.get();
    }
}