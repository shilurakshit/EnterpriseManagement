package com.task.model;
//10
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWTRequest {

    private String email;
    private String password;
}
