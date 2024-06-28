package com.jwt.jwt.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor



public class JwtResponse {
    private String jwtToken;
   private String username;
}
