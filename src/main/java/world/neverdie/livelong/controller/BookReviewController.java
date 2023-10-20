package world.neverdie.livelong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class BookReviewController {

    @GetMapping
    public ModelAndView bookReviewMain(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
