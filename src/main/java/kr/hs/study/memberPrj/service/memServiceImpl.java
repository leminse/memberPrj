package kr.hs.study.memberPrj.service;

import kr.hs.study.memberPrj.dto.memDTO;
import kr.hs.study.memberPrj.entity.memEntity;
import kr.hs.study.memberPrj.repository.memRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<memDTO> findAll(){
        List<memEntity> me = (List<memEntity>) repo.findAll();

        List<memDTO> listdto = new ArrayList<>();
        for(memEntity item : me){
            memDTO a = memEntity.toDTO(item);
            listdto.add(a);
        }

        return listdto;

    }

}
