package com.realEstate.realEstate.service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.realEstate.exception.ApplicationException;
import com.realEstate.exception.ErrorCode;
import com.realEstate.realEstate.controller.response.Response;
import com.realEstate.realEstate.model.constant.Gender;
import com.realEstate.realEstate.model.constant.UserRole;
import com.realEstate.realEstate.model.dto.UserDto;
import com.realEstate.realEstate.model.entity.User;
import com.realEstate.realEstate.repository.UserRepository;
import com.realEstate.realEstate.repository.cacheRepository.UserCacheRepository;
import com.realEstate.realEstate.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.Temperature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final UserCacheRepository redisRepository;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    @Temperature
    public UserDto update(String userName, String nickName, String password, String email, Gender gender, int age) {
        User user = userRepository.findByName(userName).orElseThrow(()->{throw new ApplicationException(ErrorCode.USER_NOT_FOUND, "없음");});
        user.setNickName(nickName);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setAge(age);

        userRepository.save(user);

        return UserDto.from(user);
    }

    /**
     * 이메일 중복 확인
     * @param email
     */
    public Response<String> checkUserEmail(String email) throws Exception{
        try {
            // 이메일이 중복 검증
            Optional<User> userOptional = userRepository.findByEmail(email);
            log.info("이메일 = {}", userOptional);
            log.info("이메일 = {}", userRepository.findByEmail(email));
            if (userOptional.isEmpty()) {
                return Response.success("사용 가능한 이메일입니다.");
            }
            else {
                return Response.error("중복된 이메일 입니다.");
            }
        } catch (Exception e) {
            throw new Exception("이메일 중복인지 확인할 수 없습니다.");
        }
    }

    @Transactional
    public UserDto join(String userName, String nickName, String password, String email, Gender gender, int age) {
        userRepository.findByName(userName).ifPresent(it -> {
            throw new ApplicationException(ErrorCode.Duplicated_USER_NAME, String.format("%s is duplicated", userName));
        });

        userRepository.findByEmail(email).ifPresent(it -> {
            throw new ApplicationException(ErrorCode.Duplicated_USER_NAME, "이미 존재하는 이메일입니다.");
        });

        User user = userRepository.save(User.of(userName, nickName, encoder.encode(password), email, gender, age));

        user.setRole(UserRole.USER);
        userRepository.save(user);
        return UserDto.from(user);
    }



    @Transactional
    public UserDto socialJoin(Long userId, String nickName, Gender gender, int age){
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new ApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userId));
        });

        user.setNickName(nickName);
        user.setGender(gender);
        user.setAge(age);
        user.setRole(UserRole.USER);

        userRepository.save(user);

        return UserDto.from(user);
    }

    @Transactional
    public String login(String email, String password) {
//        User user = redisRepository.getUser(userName).orElseGet(() ->userRepository.findByName(userName).orElseThrow(()->{
//            throw new ApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s is not founded", userName));
//        }));

//        User user = userRepository.findByName(userName).orElseThrow(() ->{throw new ApplicationException(ErrorCode.USER_NOT_FOUND, "없음");});
        User user = userRepository.findByEmail(email).orElseThrow(() ->{throw new ApplicationException(ErrorCode.USER_NOT_FOUND, "없음");});
        if (!encoder.matches(password, user.getPassword())) {
            throw new ApplicationException(ErrorCode.INVALID_PASSWORD);
        }

        String userName = user.getName();

//        redisRepository.setUser(user);

        //토큰 생성
        String token = JwtTokenUtils.doGenerateToken(userName, user.getEmail(), secretKey,expiredTimeMs);



        return token;
    }



    public UserDto loadUserByUsername(String userName) {
        User user = userRepository.findByName(userName).orElseThrow(()->{
            throw new ApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s is not founded", userName));
        });

        return UserDto.from(user);

    }

    /**
     * 로그아웃 기능
     * @param email
     */
    public void logout(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() ->{throw new ApplicationException(ErrorCode.USER_NOT_FOUND, "존재하지 않는 사용자");});
    }
}
