package sejong.hackerton.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sejong.hackerton.demo.dto.ImageDTO;
import sejong.hackerton.demo.dto.MemberDto;
import sejong.hackerton.demo.dto.MemberRewardDto;

import java.util.Random;
@Service
@RequiredArgsConstructor
public class EmotionQuizService {

    private final GptImageService gptImageService;
    private Emotion emotion;
    public ImageDTO getEmotionPicture() {
        Emotion[] emotions = Emotion.values();
        Random random = new Random();
        emotion = emotions[random.nextInt(emotions.length)];

        String prompt = "A " + emotion.toString().toLowerCase() + " human face";
        String imgURL = gptImageService.generateImage(prompt);

        ImageDTO imageDTO = new ImageDTO(imgURL);

        return imageDTO;
    }

    public Emotion getCurrentEmotion() {
        return emotion;
    }

    public boolean checkAnswer(Emotion userEmotion) {
        Emotion currentEmotion = getCurrentEmotion();
        return userEmotion.equals(currentEmotion);
    }
    public void getEmotionPicture(String prompt) {
        String imgURL = gptImageService.generateImage(prompt);

    }
    public void checkEmotionResult(int answer) {
    }
    @Transactional
    public MemberDto addExp(MemberRewardDto memberRewardDto){
        //Optional<Member> member = memberRepository.findByEmail(memberDto.getEmail());
        //Member defaultMember = new Member();
        //Member findMember = member.orElse(defaultMember);
        //findMember.setExp(findMember.getExp()+reward);
        //findMember.setLevel(findMember.getExp()/500);
        MemberDto memberDto= new MemberDto();
        memberDto.setExp(memberRewardDto.getExp()+memberRewardDto.getCorrectNumber()*100);
        memberDto.setLevel(memberDto.getExp()/500+1);
        memberDto.setExp(memberDto.getExp()%500);
        memberDto.setNickname(memberRewardDto.getNickname());
        return memberDto;
    }

}