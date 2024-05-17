package sejong.hackerton.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sejong.hackerton.demo.dto.CommonQuizDto;
import sejong.hackerton.demo.entity.Quiz;
import sejong.hackerton.demo.service.CommonQuizService;


@RestController
@RequiredArgsConstructor
public class CommonQuizController {

    private final CommonQuizService commonQuizService;

    @GetMapping("/quiz")
    @ResponseBody
    public ResponseEntity<CommonQuizDto> getQuiz() {
        Quiz quiz = commonQuizService.makeQuiz();
        CommonQuizDto quizDto = new CommonQuizDto();
        quizDto.setQuizTitle(quiz.getQuestion());

        quizDto.setQuizChoice1(quiz.getChoice1());
        quizDto.setQuizChoice2(quiz.getChoice2());
        quizDto.setQuizChoice3(quiz.getChoice3());

        quizDto.setAnswer(quiz.getAnswer());
        quizDto.setExplanation(quiz.getExplanation());

        return new ResponseEntity<CommonQuizDto>(quizDto, HttpStatus.OK);
    }

}
