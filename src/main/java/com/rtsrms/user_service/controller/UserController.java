package com.rtsrms.user_service.controller;

import com.rtsrms.user_service.model.User;
import com.rtsrms.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);

    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUser();

    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{id}/role")
    public User updateUserRole(@PathVariable int id, @RequestParam String role){
        return userService.updateUserRole(id,role);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
        return "User has been deleted";
    }
}
