package com.gulbagomedovich.streamingservice.service.impl;

import com.gulbagomedovich.streamingservice.dto.RegistrationRequest;
import com.gulbagomedovich.streamingservice.dto.RegistrationResponse;
import com.gulbagomedovich.streamingservice.exception.EmailAlreadyExistsException;
import com.gulbagomedovich.streamingservice.exception.UsernameAlreadyExistsException;
import com.gulbagomedovich.streamingservice.model.User;
import com.gulbagomedovich.streamingservice.repository.UserRepository;
import com.gulbagomedovich.streamingservice.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegistrationResponse signup(RegistrationRequest request) {
        boolean usernameAlreadyExists = !Objects.isNull(userRepository.getByUsername(request.getUsername()));
        if (usernameAlreadyExists) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        boolean emailAlreadyExists = !Objects.isNull(userRepository.getByEmail(request.getEmail()));
        if (emailAlreadyExists) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User()
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setUsername(request.getUsername())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setEmail(request.getEmail());
        userRepository.save(user);
        log.info("User was created: {}", user);
        return modelMapper.map(user, RegistrationResponse.RegistrationResponseBuilder.class).build();
    }
}
