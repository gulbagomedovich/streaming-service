package com.gulbagomedovich.streamingservice.service;

import com.gulbagomedovich.streamingservice.dto.RegistrationRequest;
import com.gulbagomedovich.streamingservice.dto.RegistrationResponse;

public interface RegistrationService {
    RegistrationResponse signup(RegistrationRequest request);
}
