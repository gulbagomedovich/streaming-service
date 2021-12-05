package com.gulbagomedovich.streamingservice.controller;

import com.gulbagomedovich.streamingservice.dto.RegistrationRequest;
import com.gulbagomedovich.streamingservice.dto.RegistrationResponse;
import com.gulbagomedovich.streamingservice.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/signup")
    public ResponseEntity<RegistrationResponse> signup(@RequestBody @Valid RegistrationRequest request) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).body(registrationService.signup(request));
    }
}
