package saltandmilk.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNAUTHENTICATED(1001,"Unauthenticated", HttpStatus.UNAUTHORIZED),
    USER_NOT_EXISTED(1002, "User not existed", HttpStatus.NOT_FOUND),
    CANT_FIND_SERIAL_NUMBER(1003,"Dont have Serial Number",HttpStatus.NOT_FOUND),
    USERNAME_EXISTED(1004, "User already exists", HttpStatus.CONFLICT),
    EMAIL_EXISTED(1005, "Email already exists", HttpStatus.CONFLICT),
    PRODUCT_NOT_FOUND(1006, "Product not found", HttpStatus.NOT_FOUND),
    MENU_EXISTED(1007, "Menu already exists", HttpStatus.CONFLICT),
    PARENT_NOT_FOUND(1008, "Parent not found", HttpStatus.NOT_FOUND),
    MENU_NOT_FOUND(1009,"Menu not found", HttpStatus.NOT_FOUND),
    ROLE_NOT_EXISTED(1010, "Role not existed", HttpStatus.NOT_FOUND),
    ROLE_EXISTED(1011, "Role already exists", HttpStatus.CONFLICT),
    CATEGORY_NOT_EXISTED(1012,"Category not existed", HttpStatus.NOT_FOUND),
    OTP_NOT_EXISTED(1013, "OTP not existed", HttpStatus.NOT_FOUND),
    OTP_EXPIRED(1014, "OTP expired", HttpStatus.BAD_REQUEST),
    OTP_INVALID(1015, "OTP invalid", HttpStatus.BAD_REQUEST),
    PASSWORD_INCORRECT(1016, "Password incorrect", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1017,"User existed",HttpStatus.CONFLICT),
    ;



    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
