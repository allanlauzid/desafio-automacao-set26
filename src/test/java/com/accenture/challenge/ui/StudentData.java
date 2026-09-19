package com.accenture.challenge.ui;

import java.time.LocalDate;

public record StudentData(
        String firstName,
        String lastName,
        String email,
        String gender,
        String mobile,
        LocalDate dateOfBirth,
        String subject,
        String hobby,
        String address,
        String state,
        String city
) {
}
