package sejong.hackerton.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmotionQuizService {

    private final GptImageService gptImageService;
    private Emotion emotion;
    public String getEmotionPicture() {
        Emotion[] emotions = Emotion.values();
        Random random = new Random();
        emotion = emotions[random.nextInt(emotions.length)];

        String prompt = "A " + emotion.toString().toLowerCase() + " human face";
        String imgURL = gptImageService.generateImage(prompt);

        return imgURL;
    }

    public Emotion getCurrentEmotion() {
        return emotion;
    }

    public boolean checkAnswer(Emotion userEmotion) {
        Emotion currentEmotion = getCurrentEmotion();
        return userEmotion.equals(currentEmotion);
    }
}
