package com.bookhub.users.controllers;

import com.bookhub.users.dto.UserDto;
import com.bookhub.users.dto.response.UserResponseDto;
import com.bookhub.users.entities.User;
import com.bookhub.users.services.IUserService;
import com.bookhub.users.services.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto){
        UserResponseDto savedUser = userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String idUser){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getUser(idUser));
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getUsers());
    }

    @PutMapping()
    public ResponseEntity<UserResponseDto> updateUsers(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(userDto));
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Object> delete(@PathVariable String idUser){
        userService.deleteUser(idUser);
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted!");
    }

}
