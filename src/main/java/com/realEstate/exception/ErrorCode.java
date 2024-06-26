package com.realEstate.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid token"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER not founded"),
    INVALID_PASSWORD(HttpStatus.NOT_FOUND, "Invalid password"),
    Duplicated_USER_NAME(HttpStatus.CONFLICT, "Duplicated UserName"),
    Property_NOT_FOUND(HttpStatus.NOT_FOUND,"Property not founded"),
    Invalid_Permission(HttpStatus.UNAUTHORIZED, "User has invalid permission"),
    Address_NOT_FOUND(HttpStatus.NOT_FOUND, "Address not founded"),
    IMAGE_SAVE_ERROR(HttpStatus.NOT_FOUND, "Image save Error"),
    CONTRACT_NOT_FOUND(HttpStatus.NOT_FOUND, "Contract not founded"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request");


    private final HttpStatus status;
    private final String message;
}
