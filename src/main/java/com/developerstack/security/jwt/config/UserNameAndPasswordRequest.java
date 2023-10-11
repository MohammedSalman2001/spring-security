package com.developerstack.security.jwt.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserNameAndPasswordRequest {
    private String username;
  private   String password;
}
