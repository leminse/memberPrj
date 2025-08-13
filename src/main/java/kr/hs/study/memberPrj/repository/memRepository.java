package kr.hs.study.memberPrj.repository;

import kr.hs.study.memberPrj.entity.memEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface memRepository extends CrudRepository<memEntity, Long> {
    Optional<memEntity> findByEmail(String email);
}
