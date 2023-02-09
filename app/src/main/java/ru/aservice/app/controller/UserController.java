package ru.aservice.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.aservice.app.api.UserApi;
import ru.aservice.app.api.model.UserDto;

import java.util.List;

//TODO: Как будет время.

@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<List<UserDto>> userGet() {
        return null;
    }

    @Override
    public ResponseEntity<Void> userPost(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> userUserIdGet(Integer userId) {
        return null;
    }
}
