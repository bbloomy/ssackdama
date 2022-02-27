package ssackdama.ssackdama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ssackdama.ssackdama.domain.Store;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAll();

    @Query(value = "SELECT * FROM store where member_id = :member_id",nativeQuery = true)
    List<Store> findByUser(@Param("member_id") Long member_id);


}
