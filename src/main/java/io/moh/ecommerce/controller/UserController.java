package io.moh.ecommerce.controller;

import io.moh.ecommerce.dto.users.SignUpDto;
import io.moh.ecommerce.dto.users.SignUpResponseDto;
import io.moh.ecommerce.exceptions.CustomException;
import io.moh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public SignUpResponseDto Signup(@RequestBody SignUpDto signUpDto) throws CustomException {
        return userService.signUp(signUpDto);
    }
}
