package com.gulbagomedovich.streamingservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@AllArgsConstructor(onConstructor_ = @JsonCreator)
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationRequest {
    @NotBlank
    private final String username;
    @NotBlank
    private final String password;
}
