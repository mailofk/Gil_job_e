package sejong.hackerton.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sejong.hackerton.demo.entity.Member;
import sejong.hackerton.demo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public void deleteById(Long id){
        memberRepository.deleteById(id);
    }
}
