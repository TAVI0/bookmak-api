package com.tavio.bookmarkapi.persistance.entity;

import lombok.Data;

@Data
public class UserResponse {
    Long id;
    String username;
    String accessToken;
    String refreshToken;
}
