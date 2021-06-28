package com.austin.home.controller;

import com.austin.home.model.Memo;
import com.austin.home.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private MemoRepository memoRepository;

//    @GetMapping("/main")
//    public String Study() {
//        return "study/main";
//    }

    @GetMapping("/main")
    public String form(Model model, @RequestParam(required = false) Long id) {
        List<Memo> memos = memoRepository.findAll();
        model.addAttribute("memos",memos);

        if(id == null) {
            model.addAttribute("memo", new Memo());
        }else{
            Memo memo = memoRepository.findById(id).orElse(null);
            model.addAttribute("memo", memo);
        }
        return "study/main";
    }


    @PostMapping("/main")
    public String postForm(@Valid Memo memo, BindingResult bindingResult, Authentication authentication) {
        memoRepository.save(memo);
        return "redirect:/study/main";
    }
}
