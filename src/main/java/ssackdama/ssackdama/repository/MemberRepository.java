package ssackdama.ssackdama.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ssackdama.ssackdama.domain.Member;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select u from Member u where u.email = ?1")
    Optional<Member> findOneByEmail(String email);

    @Transactional
    @Override
    void deleteById(Long memberId);
}
