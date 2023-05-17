package io.m2i.TPInvoice.service;

import io.m2i.TPInvoice.entity.Product;
import io.m2i.TPInvoice.entity.User;
import io.m2i.TPInvoice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }
    public List<Product> getProductListPerUser(User user) {
        return productRepository.findProductByUser(user);
    }
    public void editProduct(Product product, User user) {
        product.setUser(user);
        productRepository.save(product);
    }
    public void deleteProduct(Product product, User user) {
        boolean condition = productRepository.existsProductByIdAndUser(product.getId(), user);
        if (! condition) {
            throw new RuntimeException("Product not belonging to User"); // TODO: Personalise Exceptions
        }
        productRepository.delete(product);
    }


}
