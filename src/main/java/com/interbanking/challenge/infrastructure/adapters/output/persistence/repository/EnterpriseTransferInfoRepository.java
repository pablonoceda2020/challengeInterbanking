package com.interbanking.challenge.infrastructure.adapters.output.persistence.repository;

import com.interbanking.challenge.infrastructure.adapters.output.persistence.entity.EnterpriseTransferInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EnterpriseTransferInfoRepository extends JpaRepository<EnterpriseTransferInfoEntity, Long> {

    @Query("SELECT e FROM EnterpriseTransferInfoEntity  e WHERE e.transactionDate >= :startDate")
    List<EnterpriseTransferInfoEntity> findTransfersFromTheLastMonth(
            @Param("startDate") LocalDateTime startDate);
}
