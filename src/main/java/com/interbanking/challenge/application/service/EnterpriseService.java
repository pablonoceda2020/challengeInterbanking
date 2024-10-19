package com.interbanking.challenge.application.service;

import com.interbanking.challenge.application.ports.input.EnterpriseServicePort;
import com.interbanking.challenge.application.ports.output.EnterprisePersistencePort;
import com.interbanking.challenge.domain.model.Enterprise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService implements EnterpriseServicePort {

  private final EnterprisePersistencePort persistencePort;

  @Override
  public Enterprise membership(Enterprise enterprise) {
    return persistencePort.membership(enterprise);
  }

  @Override
  public List<Enterprise> latestTransfers() {
    return persistencePort.latestTransfers();
  }

  @Override
  public List<Enterprise> latestAdditions() { return persistencePort.latestAdditions(); }

}
