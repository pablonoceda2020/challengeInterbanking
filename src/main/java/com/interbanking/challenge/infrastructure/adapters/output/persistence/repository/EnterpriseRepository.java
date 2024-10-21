package com.interbanking.challenge.infrastructure.adapters.output.persistence.repository;

import com.interbanking.challenge.infrastructure.adapters.output.persistence.entity.EnterpriseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {

    List<EnterpriseEntity> findAllByIdIn(List<Long> ids);

    @Query("SELECT e FROM EnterpriseEntity  e WHERE e.membershipDate >= :startDate")
    List<EnterpriseEntity> findEnterpriseFromTheLastMonth(
            @Param("startDate") LocalDateTime startDate);
}
