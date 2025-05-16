package com.admin.backend.dto;

public record SignupRequest(
        String memberName,
        String memberEmail,
        String memberPassword,
        String passportNumber
) {
}
