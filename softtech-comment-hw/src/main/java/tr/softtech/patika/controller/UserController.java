package tr.softtech.patika.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.softtech.patika.dto.GenericResponseDto;
import tr.softtech.patika.dto.SingupRequestDto;
import tr.softtech.patika.dto.UpdateUserRequestDto;
import tr.softtech.patika.service.CommentService;
import tr.softtech.patika.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("singup")
    public ResponseEntity Singup(@Valid @RequestBody SingupRequestDto singupRequestDto){
        return userService.singup(singupRequestDto);//Bu servis direkt olark ResponseEntity dönüyor
    }

    @DeleteMapping("deleteUser")
    public ResponseEntity deleteUser(@RequestParam String username, @RequestParam Long phoneNumber){
        userService.deleteUser(username,phoneNumber);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("updateUser")
    public ResponseEntity updateUser(@Valid @RequestBody UpdateUserRequestDto updateUserRequestDto){
        return ResponseEntity.ok(userService.updateUser(updateUserRequestDto));
    }

    @GetMapping("getUserByUsername")
    public ResponseEntity getUserByUsername(@RequestParam String username){
        return  ResponseEntity.ok(userService.getUserByUsernameWithControl(username));
    }

    @GetMapping("getUserById")
    public ResponseEntity getUserById(@RequestParam String id){
        return ResponseEntity.ok(userService.getUserByIdWithControl(id));
    }

    @GetMapping("getAllUser")
    public ResponseEntity getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
