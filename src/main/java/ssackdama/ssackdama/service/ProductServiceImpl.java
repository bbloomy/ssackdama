package ssackdama.ssackdama.service;

import org.springframework.stereotype.Service;
import ssackdama.ssackdama.domain.Product;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.repository.ProductRepository;


@Service
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public boolean addProduct(Store store) {

        if(store!=null) {
            Product product = new Product();
            product.setStore(store);
            product.setProductName("hello");
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
