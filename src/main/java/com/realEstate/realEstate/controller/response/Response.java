package com.realEstate.realEstate.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import retrofit2.http.HTTP;

@AllArgsConstructor
@Getter
public class Response<T>{
    private String resultCode;
    private T result;


    // 실패했을 경우
    public static Response<String> error(String errorMessage) {
        return new Response<>("FALSE", errorMessage);
    }

    // 성공했을 경우
    public static <T> Response<T> success(T result) {
        return new Response<>("SUCCESS", result);
    }

    public static Response<Void> success() {
        return new Response<>("Success", null);
    }

    public String toStream() {
        if (result == null) {
            return "{" +
                    "\"resultCode\":" + "\"" + resultCode + "\"," +
                    "\"result\":" + null +
                    "}";
        }
        return "{" +
                "\"resultCode\":" + "\"" + resultCode + "\"," +
                "\"result\":" + "\"" + result + "\"," +
                "}";
    }
}
