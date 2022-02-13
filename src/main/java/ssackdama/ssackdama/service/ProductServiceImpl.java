package ssackdama.ssackdama.service;

import org.junit.Test;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ssackdama.ssackdama.domain.Product;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.repository.ProductRepository;
import ssackdama.ssackdama.repository.StoreRepository;

import javax.transaction.Transactional;


@Service
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public ProductServiceImpl(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;

        this.storeRepository = storeRepository;
    }

    @Override
    @Transactional
    public boolean addProduct(Product product) {

//        if(store!=null) {
//            Product product = new Product();
//            product.setStore(store);
//            product.setProductName("hello");
//            productRepository.save(product);
//            return true;
//        }
        System.out.println("타입"+product.getProductName());
        Store store1 = storeRepository.getById(1L);
        product.setStore(store1);
        Product product1 = productRepository.save(product);

        if (product1 != null){
            return true;
        }
        return false;
    }
}
