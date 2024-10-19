package com.interbanking.challenge.infrastructure.adapters.input.rest;

import com.interbanking.challenge.application.ports.input.EnterpriseServicePort;
import com.interbanking.challenge.infrastructure.adapters.input.rest.mapper.EnterpriseRestMapper;
import com.interbanking.challenge.infrastructure.adapters.input.rest.model.request.EnterpriseCreateRequest;
import com.interbanking.challenge.infrastructure.adapters.input.rest.model.response.EnterpriseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enterprises")
public class EnterpriseRestAdapter {

  private final EnterpriseServicePort servicePort;
  private final EnterpriseRestMapper restMapper;

  @PostMapping("/v1/membership")
  public ResponseEntity<EnterpriseResponse> membership(@Valid @RequestBody EnterpriseCreateRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(restMapper.toEnterpriseResponse(
                    servicePort.membership(restMapper.toEnterprise(request))));
  }

  @GetMapping("/v1/latestTransfers")
  public List<EnterpriseResponse> latestTransfers() {
    return restMapper.toEnterpriseResponseList(servicePort.latestTransfers());
  }

  @GetMapping("/v1/latestAdditions")
  public List<EnterpriseResponse> latestAdditions() {
    return restMapper.toEnterpriseResponseList(servicePort.latestAdditions());
  }

}
