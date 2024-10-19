package com.interbanking.challenge.infrastructure.adapters.output.persistence;

import com.interbanking.challenge.application.ports.output.EnterprisePersistencePort;
import com.interbanking.challenge.domain.model.Enterprise;
import com.interbanking.challenge.infrastructure.adapters.output.persistence.entity.EnterpriseTransferInfoEntity;
import com.interbanking.challenge.infrastructure.adapters.output.persistence.mapper.EnterprisePersistenceMapper;
import com.interbanking.challenge.infrastructure.adapters.output.persistence.repository.EnterpriseRepository;
import com.interbanking.challenge.infrastructure.adapters.output.persistence.repository.EnterpriseTransferInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EnterprisePersistenceAdapter implements EnterprisePersistencePort {

  private final EnterpriseRepository enterpriseRepository;
  private final EnterpriseTransferInfoRepository enterpriseTransferInfoRepository;
  private final EnterprisePersistenceMapper mapper;

  @Override
  public Enterprise membership(Enterprise enterprise) {
    return mapper.toEnterprise(
            enterpriseRepository.save(mapper.toEnterpriseEntity(enterprise)));
  }

  @Override
  public List<Enterprise> latestTransfers() {
    ZonedDateTime zonedBuenosAires = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
    LocalDateTime date = zonedBuenosAires.minusMonths(1).toLocalDateTime();
    List<EnterpriseTransferInfoEntity> enterpriseTransferInfoEntityList = enterpriseTransferInfoRepository.findTransfersFromTheLastMonth(date);
    List<Long> ids = new ArrayList<>();
    enterpriseTransferInfoEntityList.forEach(e -> ids.add(e.getIdEnterprise()));
    Set<Long> enterprisesSet = new HashSet<>(ids);
    ids.clear();
    ids.addAll(enterprisesSet);
    return mapper.toEnterpriseList(enterpriseRepository.findAllByIdIn(ids));
  }

  @Override
  public List<Enterprise> latestAdditions() {
    ZonedDateTime zonedBuenosAires = ZonedDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
    LocalDateTime date = zonedBuenosAires.minusMonths(1).toLocalDateTime();
    return mapper.toEnterpriseList(enterpriseRepository.findEnterpriseFromTheLastMonth(date));
  }

}
