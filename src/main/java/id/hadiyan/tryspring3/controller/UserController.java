package id.hadiyan.tryspring3.controller;

import id.hadiyan.tryspring3.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<UserDto> getUser(){
        UserDto userDto = new UserDto("1", "Hadiyan", "123");
        return ResponseEntity.ok(userDto);
    }
}
