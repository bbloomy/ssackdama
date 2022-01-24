package ssackdama.ssackdama.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ssackdama.ssackdama.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
