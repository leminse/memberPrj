package kr.hs.study.memberPrj.entity;

import jakarta.persistence.*;
import kr.hs.study.memberPrj.dto.memDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="member_t")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class memEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, unique = true)
    private String email;

    @Column
    private String pass;

    @Column(length = 10, unique = true)
    private String name;

    //entity -> dto 변환
    public static memDTO toDTO(memEntity e){
        memDTO dto = memDTO.builder()
                .id(e.getId())
                .email(e.getEmail())
                .pass(e.getPass())
                .name(e.getName())
                .build();
        return dto;
    }

}
