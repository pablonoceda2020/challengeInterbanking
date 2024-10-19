package com.interbanking.challenge.infrastructure.adapters.input.rest.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

  private String code;
  private String message;
  private List<String> details;
  private LocalDateTime timestamp;

}
