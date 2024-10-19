package com.interbanking.challenge.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseTransferInfo {

    private Long idTransfer;
    private BigDecimal amount;
    private Long idEnterprise;
    private String debitAccount;
    private String creditAccount;
    private LocalDateTime transactionDate;

}
