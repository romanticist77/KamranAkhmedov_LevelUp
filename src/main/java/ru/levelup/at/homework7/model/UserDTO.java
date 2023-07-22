package ru.levelup.at.lesson1011.cicd.allure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {

    private final String login;
    private final String email;
    private final String password;



}
