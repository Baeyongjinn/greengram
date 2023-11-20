package com.green.greengram.user;


import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserProfileInfoVo;
import com.green.greengram.user.model.UserSignInVo;
import com.green.greengram.user.model.UserSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResVo postUser(@RequestBody UserInsDto dto) {
        System.out.println(dto);
        int result = service.putUser(dto);
        return new ResVo(result);
    }

    @PostMapping("/signin")
    public UserSignInVo login(@RequestBody UserSignInDto dto) {
        return service.signIn(dto);
    }

    //api/user/2
    @GetMapping("/{targetIuser}")
    public UserProfileInfoVo getUserProfileInfo(@PathVariable int targetIuser) {
        return service.getUserProfileInfo(targetIuser);
    }

}
