package sejong.hackerton.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sejong.hackerton.demo.dto.EmotionQuizResultDTO;
import sejong.hackerton.demo.dto.ImageDTO;
import sejong.hackerton.demo.dto.MemberDto;
import sejong.hackerton.demo.dto.MemberRewardDto;
import sejong.hackerton.demo.entity.Member;
import sejong.hackerton.demo.service.Emotion;
import sejong.hackerton.demo.service.EmotionQuizService;

@RestController
@RequiredArgsConstructor
public class EmotionQuizController {
    private static final String ANGRYEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '화난 표정'입니다.\n 이마에 주름이 잡히고, 눈썹이 아래로 내려가고, 입술이 굳어있는 모습은 화난 표정으로 볼 수 있어요";
    private static final String SADEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '슬픈표정'입니다.\n 안쪽 눈썹이 위로 올라가고, 눈물이 흐르며 입꼬리가 내려가는 표정은 슬픈 표정으로 볼 수 있어요";
    private static final String HAPPYEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '행복한 표정'입니다.\n 입꼬리가 위로 올라가고, 눈썹이 위로 올라가는 표정은 행복한 표정으로 볼 수 있어요";
    private static final String SURPRISEDEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '놀란 표정'입니다.\n 이마에 주름이 잡히고, 눈썹이 위로 올라가고, 입을 크게 벌리는 모습은 놀란 표정으로 볼 수 있어요";
//    @Autowired
    private final EmotionQuizService emotionQuizService;

    @GetMapping("/generateEmotion")
    public ImageDTO generateEmotionQuiz(){
        return emotionQuizService.getEmotionPicture();
    }

    @PostMapping("/checkEmotion")
    public ResponseEntity<EmotionQuizResultDTO> checkEmotion(@RequestBody String answer){

        Emotion answerEnum = Emotion.valueOf(answer);

        boolean result =  emotionQuizService.checkAnswer(answerEnum);

        EmotionQuizResultDTO emotionQuizResultDTO = new EmotionQuizResultDTO();
        emotionQuizResultDTO.setCorrect(result);
        String emotionExplanation = emotionQuizService.getCurrentEmotion()+"EXPLANATION";
        if(emotionExplanation.equals("ANGRYEXPLANATION")) emotionExplanation = ANGRYEXPLANATION;
        else if(emotionExplanation.equals("SADEXPLANATION"))  emotionExplanation = SADEXPLANATION;
        else if(emotionExplanation.equals("HAPPYEXPLANATION")) emotionExplanation = HAPPYEXPLANATION;
        else if(emotionExplanation.equals("SURPRISEDEXPLANATION")) emotionExplanation = SURPRISEDEXPLANATION;

        emotionQuizResultDTO.setExplanation(emotionExplanation);

        return ResponseEntity.ok(emotionQuizResultDTO);
    }
    @PostMapping("/emotionQuiz/reward")
    public ResponseEntity<MemberDto> RewardCal(@RequestBody MemberRewardDto memberRewardDto){
        MemberDto resultMemberDto = emotionQuizService.addExp(memberRewardDto);
        return ResponseEntity.ok(resultMemberDto);
    }
}
