package com.hst.learninghub.calculate.entity;

import com.hst.learninghub.calculate.type.CalculateType;
import com.hst.learninghub.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "calculate")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calculate extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calculate_no")
    private Long no;

    @Column(name = "calculate_dtm")
    private LocalDateTime calcDtm;

    @Column(name = "calculate_type_cd")
    @Convert(converter = CalculateType.Converter.class)
    private String calcType;

    @Column(name = "calculate_yn")
    private String calcSuccessYN;

}
