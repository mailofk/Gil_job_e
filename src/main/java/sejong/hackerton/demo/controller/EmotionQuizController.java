package sejong.hackerton.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sejong.hackerton.demo.dto.EmotionQuizResultDTO;
import sejong.hackerton.demo.entity.Member;
import sejong.hackerton.demo.service.Emotion;
import sejong.hackerton.demo.service.EmotionQuizService;

@RestController
public class EmotionQuizController {
    private static final String ANGRYEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '화난 표정'입니다.\n 이마에 주름이 잡히고, 눈썹이 아래로 내려가고, 입술이 굳어있는 모습은 화난 표정으로 볼 수 있어요";
    private static final String SADEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '슬픈표정'입니다.\n 안쪽 눈썹이 위로 올라가고, 눈물이 흐르며 입꼬리가 내려가는 표정은 슬픈 표정으로 볼 수 있어요";
    private static final String HAPPYEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '행복한 표정'입니다.\n 입꼬리가 위로 올라가고, 눈썹이 위로 올라가는 표정은 행복한 표정으로 볼 수 있어요";
    private static final String SURPRISEDEXPLANATION = "아쉽지만 정답이 아니에요!\n 정답은 '놀란 표정'입니다.\n 이마에 주름이 잡히고, 눈썹이 위로 올라가고, 입을 크게 벌리는 모습은 놀란 표정으로 볼 수 있어요";
    @Autowired
    private EmotionQuizService emotionQuizService;

    @GetMapping("/generateEmotion")
    public String generateEmotionQuiz(){
        return emotionQuizService.getEmotionPicture();
    }

    @PostMapping("/checkEmotion")
    public ResponseEntity<EmotionQuizResultDTO> checkEmotion(@RequestBody Emotion answer){

        Member member = new Member();
        member.setId(1L);
        member.setExp(200);
        member.setLevel(1);

        boolean result =  emotionQuizService.checkAnswer(answer);

        EmotionQuizResultDTO emotionQuizResultDTO = new EmotionQuizResultDTO();
        emotionQuizResultDTO.setCorrect(result);
        String emotionExplanation = emotionQuizService.getCurrentEmotion()+"EXPLANATION";
        if(emotionExplanation.equals("ANGRYEXPLANATION")) emotionExplanation = ANGRYEXPLANATION;
        else if(emotionExplanation.equals("SADEXPLANATION"))  emotionExplanation = SADEXPLANATION;
        else if(emotionExplanation.equals("HAPPYEXPLANATION")) emotionExplanation = HAPPYEXPLANATION;
        else if(emotionExplanation.equals("SURPRISEDEXPLANATION")) emotionExplanation = SURPRISEDEXPLANATION;

        emotionQuizResultDTO.setExplanation(emotionExplanation);

        Integer exp = member.getExp();
        Integer level = member.getLevel();
        if(result){
            exp += 100;
            level += exp/500;
            member.setLevel(level);

            exp %= 500;
            member.setExp(exp);
        }
        emotionQuizResultDTO.setExp(exp);
        emotionQuizResultDTO.setLevel(level);
        return ResponseEntity.ok(emotionQuizResultDTO);
    }

}
