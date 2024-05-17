package sejong.hackerton.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sejong.hackerton.demo.entity.Quiz;
import sejong.hackerton.demo.repository.QuizRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonQuizService {

    private final QuizRepository quizRepository;

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    public Quiz makeQuiz() {
        List<Quiz> allQuiz = quizRepository.findAll();
//        Quiz quiz1 = new Quiz();
//        quiz1.setQuestion("나는 무엇을 먹었을까요?");
//        quiz1.setChoice1("라면");
//        quiz1.setChoice2("족발");
//        quiz1.setChoice3("햄버거");
//        quiz1.setAnswer(2);
//        quiz1.setExplanation("저는 족발이 먹고 싶어요");
//        allQuiz.add(quiz1);
//

        Quiz quiz = allQuiz.get(Quiz.sequenceNum);

        Quiz.sequenceNum = (Quiz.sequenceNum + 1) % 100;
        return quiz;
    }
}
