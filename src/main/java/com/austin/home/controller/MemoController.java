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
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    private MemoRepository memoRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Memo> memos = memoRepository.findAll();
        model.addAttribute("memos",memos);
        return "memo/list";
    }


    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        if(id == null) {
            model.addAttribute("memo", new Memo());
        }else{
            Memo memo = memoRepository.findById(id).orElse(null);
            model.addAttribute("memo", memo);
        }
        return "memo/form";
    }


    @PostMapping("/form")
    public String postForm(@Valid Memo memo, BindingResult bindingResult, Authentication authentication) {
        memoRepository.save(memo);
        return "redirect:/memo/list";
    }

}
