package com.interbanking.challenge.application.ports.output;

import com.interbanking.challenge.domain.model.Enterprise;

import java.util.List;

public interface EnterprisePersistencePort {

  Enterprise membership(Enterprise enterprise);
  List<Enterprise> latestTransfers();
  List<Enterprise> latestAdditions();

}
