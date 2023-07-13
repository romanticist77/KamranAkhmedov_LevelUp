package ru.levelup.at.homework6.pojo.model.users;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
@Builder
public class CreateUsersRequest {

    private String name;
    private String email;
    private String gender;
    private String status;

}
