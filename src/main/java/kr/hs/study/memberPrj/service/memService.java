package kr.hs.study.memberPrj.service;

import kr.hs.study.memberPrj.dto.memDTO;
import kr.hs.study.memberPrj.entity.memEntity;

import java.util.Optional;

public interface memService {
    public void signup(memDTO dto);
    Optional<memEntity> findByEmail(String email);
}
