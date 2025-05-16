package com.admin.backend.dto;

public record LoginRequest(
        String memberEmail,
        String memberPassword
) {
}
