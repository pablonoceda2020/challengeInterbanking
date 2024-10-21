package com.interbanking.challenge.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class EnterpriseTransferInfoEntity {

    @Id
    private Long idTransfer;
    @Column
    private BigDecimal amount;
    @Column
    private Long idEnterprise;
    @Column
    private String debitAccount;
    @Column
    private String creditAccount;
    @Column
    private LocalDateTime transactionDate;

}
