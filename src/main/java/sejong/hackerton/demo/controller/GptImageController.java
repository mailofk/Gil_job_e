package sejong.hackerton.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sejong.hackerton.demo.service.GptImageService;

@Controller
@RequiredArgsConstructor
public class GptImageController {

    @Autowired
    private GptImageService gptService;

    @PostMapping("/generate-image")
    public String generateImage(@RequestBody String prompt) {
        return gptService.generateImage(prompt);
    }

}
