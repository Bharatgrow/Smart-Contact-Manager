package com.formvalidation.form.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class loginData {

    @NotBlank(message = "cannot be blank")
    @Size(min = 3,max = 12)
    private String Username;
    private String email;
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public loginData(String username, String email) {
        Username = username;
        this.email = email;
    }
    public loginData() {
    }

    
}
