package com.tavio.bookmarkapi.domain.dto;

import lombok.Data;
import org.antlr.v4.runtime.Token;

@Data
public class LoginDto {
    private String username;
    private String password;
    private String token;
}
