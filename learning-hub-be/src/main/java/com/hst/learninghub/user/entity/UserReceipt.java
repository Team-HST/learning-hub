package com.hst.learninghub.user.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_receipt")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserReceipt {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rev_no")
    private Long no;

    @ManyToOne
    @JoinColumn(name = "reg_user_no")
    private User regUser;

    @Column(name = "receipt_amount")
    private Long amount;

    @Column(name = "receipt_dtm")
    private LocalDate receiptDtm;
}
