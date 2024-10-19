package com.interbanking.challenge.infrastructure.adapters.input.rest.mapper;

import com.interbanking.challenge.domain.model.Enterprise;
import com.interbanking.challenge.infrastructure.adapters.input.rest.model.request.EnterpriseCreateRequest;
import com.interbanking.challenge.infrastructure.adapters.input.rest.model.response.EnterpriseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnterpriseRestMapper {

  Enterprise toEnterprise(EnterpriseCreateRequest request);

  EnterpriseResponse toEnterpriseResponse(Enterprise enterprise);

  List<EnterpriseResponse> toEnterpriseResponseList(List<Enterprise> enterpriseList);

}
