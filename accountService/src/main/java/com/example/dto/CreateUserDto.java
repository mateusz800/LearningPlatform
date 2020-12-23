package com.example.dto;

public class CreateUserDto {
    private String email;
    private String password;

    public CreateUserDto(){}

    public CreateUserDto(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
