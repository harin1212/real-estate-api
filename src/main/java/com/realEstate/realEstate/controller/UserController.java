package com.realEstate.realEstate.controller;

import com.amazonaws.services.kms.model.NotFoundException;
import com.realEstate.realEstate.controller.request.UserJoinRequest;
import com.realEstate.realEstate.controller.request.UserLoginRequest;
import com.realEstate.realEstate.controller.request.UserSocialJoinRequest;
import com.realEstate.realEstate.controller.request.UserUpdateRequest;
import com.realEstate.realEstate.controller.response.Response;
import com.realEstate.realEstate.controller.response.UserJoinResponse;
import com.realEstate.realEstate.controller.response.UserLoginResponse;
import com.realEstate.realEstate.model.dto.UserDto;
import com.realEstate.realEstate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/realEstate/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/update")
    public Response<Void> update(@RequestBody UserUpdateRequest request, Authentication authentication) {
        UserDto dto = userService.update(authentication.getName(), request.getNickName(), request.getPassword(), request.getEmail(), request.getGender(),request.getAge());

        return Response.success();
    }

    /**
     * 이메일 중복체크
     */
    @PostMapping("/emailcheck")
    public Response<String> checkUserEmail(@RequestBody Map<String, String> request) throws Exception {
        String email = request.get("email");
        return userService.checkUserEmail(email);
    }

    /**
     * 회원가입
     * @param request
     * @return
     */
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        UserDto dto = userService.join(request.getName(), request.getNickName(), request.getPassword(), request.getEmail(), request.getGender(), request.getAge());

        return Response.success(UserJoinResponse.fromDTO(dto));
    }

    /**
     * 로그인
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getEmail(), request.getPassword());
        log.info(token);
        return Response.success(new UserLoginResponse(token));
    }

    /**
     * 소셜 회원가입
     * @param userId
     * @param request
     * @return
     */
    @PostMapping("/socialJoin/{userId}")
    public Response<UserJoinResponse> socialJoin(@PathVariable Long userId, @RequestBody UserSocialJoinRequest request){
        UserDto dto = userService.socialJoin(userId, request.getNickName(),  request.getGender(), request.getAge());

        return Response.success(UserJoinResponse.fromDTO(dto));

    }

    @PostMapping("/logout")
    public Response<String> logout(@RequestBody String email){
        userService.logout(email);
        return Response.success("로그아웃 성공.");
    }
}
