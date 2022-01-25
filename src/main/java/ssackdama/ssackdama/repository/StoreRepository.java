package ssackdama.ssackdama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssackdama.ssackdama.domain.Store;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAll();

}
