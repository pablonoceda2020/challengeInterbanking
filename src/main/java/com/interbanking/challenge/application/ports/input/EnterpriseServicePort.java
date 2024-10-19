package com.interbanking.challenge.application.ports.input;

import com.interbanking.challenge.domain.model.Enterprise;

import java.util.List;

public interface EnterpriseServicePort {

  Enterprise membership(Enterprise enterprise);
  List<Enterprise> latestTransfers();
  List<Enterprise> latestAdditions();

}
