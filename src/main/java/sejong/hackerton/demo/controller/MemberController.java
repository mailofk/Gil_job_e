package sejong.hackerton.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sejong.hackerton.demo.dto.*;
import sejong.hackerton.demo.entity.Member;
import sejong.hackerton.demo.service.MemberService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/new")
    public ResponseEntity<Member> joinMember(@Valid @RequestBody MemberJoinDto member){
        return ResponseEntity.ok(memberService.join(member));
    }

    @PostMapping("/members/login")
    public ResponseEntity<MemberDto> LoginMember(@Valid @RequestBody MemberLoginDto member){
        return ResponseEntity.ok(memberService.login(member));
    }
    @PostMapping("/quiz/reward")
    public ResponseEntity<MemberDto> RewardCal(@RequestBody MemberRewardDto memberRewardDto){
        MemberDto resultMemberDto = memberService.addExp(memberRewardDto);
        return ResponseEntity.ok(resultMemberDto);
    }

//
//    @PostMapping("/members/login")
//    public ResponseEntity<JwtTokenDto> JwtLoginMember(@Valid @RequestBody MemberLoginDto member){
//        JwtTokenDto jwtTokenDto = memberService.jwtLogin(member);
//        String accessToken = jwtTokenDto.getAccessToken();
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + accessToken);
//        //httpHeaders.setLocation(URI.create("/members/info"));
//       // return  new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
//        return ResponseEntity.ok().headers(httpHeaders).body(jwtTokenDto);
//    }


}