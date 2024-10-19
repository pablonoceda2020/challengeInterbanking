package com.interbanking.challenge.infrastructure.adapters.output.persistence.mapper;

import com.interbanking.challenge.domain.model.Enterprise;
import com.interbanking.challenge.infrastructure.adapters.output.persistence.entity.EnterpriseEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnterprisePersistenceMapper {

  EnterpriseEntity toEnterpriseEntity(Enterprise enterprise);

  Enterprise toEnterprise(EnterpriseEntity entity);

  List<Enterprise> toEnterpriseList(List<EnterpriseEntity> entityList);

}
