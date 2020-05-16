package com.gstu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;
    @NotEmpty
    @Size(min = 3, max = 7, message = "Username should be more than 3 symbols!")
    private String username;
    @NotEmpty
    @Size(min = 3, max = 7, message = "Password should be more than 3 symbols!")
    private String password;
    @NotEmpty
    @Size(min = 3, max = 7, message = "Password should be more than 3 symbols!")
    private String repeatPassword;
    private String email;
    private Role role;
    private boolean accountNonExpired;
}
