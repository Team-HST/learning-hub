package com.hst.learninghub.calculate.entity;

import com.hst.learninghub.calculate.type.CalculateType;
import com.hst.learninghub.common.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "calculate")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Calculate {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calculate_no")
    private Long no;

    @CreatedDate
    @Column(name = "calculate_dtm")
    private LocalDateTime calcDtm;

    @Column(name = "calculate_type_cd")
    @Convert(converter = CalculateType.Converter.class)
    private CalculateType calcType;

    @Column(name = "calculate_yn")
    private Boolean calcSuccess;

    public void markSuccess() {
        this.calcSuccess = true;
    }

    public void markFailed() {
        this.calcSuccess = false;
    }

}
