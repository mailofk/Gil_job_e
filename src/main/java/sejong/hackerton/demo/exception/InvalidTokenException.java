package sejong.hackerton.demo.exception;

public class InvalidTokenException extends RuntimeException{
    @Override
    public String getMessage() {
        return "토큰이 유효하지 않습니다.";
    }
}