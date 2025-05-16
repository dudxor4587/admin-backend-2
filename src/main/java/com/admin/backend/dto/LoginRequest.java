package com.admin.backend.dto;

public record LoginRequest(
        String email,
        String password
) {
}
