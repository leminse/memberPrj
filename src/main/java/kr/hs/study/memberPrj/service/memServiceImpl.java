package kr.hs.study.memberPrj.service;

import kr.hs.study.memberPrj.dto.memDTO;
import kr.hs.study.memberPrj.entity.memEntity;
import kr.hs.study.memberPrj.repository.memRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class memServiceImpl implements memService{

    @Autowired
    private final memRepository repo;

    @Override
    public void signup(memDTO dto){
        memEntity me1 = memDTO.toEntity(dto);
        repo.save(me1);
    }

    @Override
    public Optional<memEntity> findByEmail(String email){
        return repo.findByEmail(email);
    }

}
