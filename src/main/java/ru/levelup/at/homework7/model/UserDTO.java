package ru.levelup.at.homework7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {

    private final String login;
    private final String email;
    private final String password;



}
