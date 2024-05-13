package com.task.model;
//11
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWTResponse {

    private String jwtToken;
    private String userName;
}
