package com.interbanking.challenge.infrastructure.adapters.output.persistence.entity;

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
@Table(name = "EnterpriseTransferInfo")
public class EnterpriseTransferInfoEntity {

    @Id
    private Long idTransfer;
    private BigDecimal amount;
    private Long idEnterprise;
    private String debitAccount;
    private String creditAccount;
    private LocalDateTime transactionDate;

}
