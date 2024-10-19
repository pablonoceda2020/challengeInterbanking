package com.interbanking.challenge.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseCreateRequest {

  @NotBlank(message = "Field cuit cannot be empty or null.")
  private String cuit;

  @NotBlank(message = "Field companyName cannot be empty or null.")
  private String companyName;

}
