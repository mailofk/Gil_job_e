package sejong.hackerton.demo.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Security;
import java.util.Optional;

public class SecurityUtil {
    private SecurityUtil(){}

    public static Long getCurrentMemberId(){
        final Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (authentication ==null || authentication.getName() == null){
            throw new RuntimeException("Security Context에 인증정보가 없습니다.");
        }

        return Long.parseLong(authentication.getName());
    }

}
