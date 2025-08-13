package kr.hs.study.memberPrj.dto;

import kr.hs.study.memberPrj.entity.memEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class memDTO {
    private Long id;
    private String email;
    private String pass;
    private String name;

    public static memEntity toEntity(memDTO dto){
        memEntity me = memEntity.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .pass(dto.getPass())
                .name(dto.getName())
                .build();
        return me;

    }
}