package com.interbanking.challenge.infrastructure.adapters.input.rest.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseResponse {

  private Long id;
  private String cuit;
  private String razon;
  private String membershipDate;

}
