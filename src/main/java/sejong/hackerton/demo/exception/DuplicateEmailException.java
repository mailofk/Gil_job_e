package sejong.hackerton.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class DuplicateEmailException extends RuntimeException{
    @Override
    public String getMessage() {
        return "이미 존재하는 이메일입니다.";
    }
}
