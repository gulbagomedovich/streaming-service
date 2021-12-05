package com.gulbagomedovich.streamingservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@ToString
@AllArgsConstructor(onConstructor_ = @JsonCreator)
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String username;
    @NotBlank
    @Size(min = 8)
    private final String password;
    @NotBlank
    @Email
    private final String email;
}
