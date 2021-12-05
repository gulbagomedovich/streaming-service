package com.gulbagomedovich.streamingservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationResponse {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;
}
