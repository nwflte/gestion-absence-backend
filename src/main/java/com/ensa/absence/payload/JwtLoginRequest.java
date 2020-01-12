package com.ensa.absence.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtLoginRequest {
    private String accessToken;
}
