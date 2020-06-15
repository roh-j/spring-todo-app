package com.example.controller;

import com.example.domain.BoardVO;
import com.example.service.BoardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    private BoardServiceImpl boardService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", boardService.home());
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping("/content/{bno}")
    public String content(Model model, BoardVO board, @PathVariable(value = "bno") Long bno) {
        model.addAttribute("content", boardService.content(board, bno));
        return "content";
    }

    @PostMapping("/insert")
    public String insert(BoardVO board) {
        boardService.insert(board);
        return "redirect:/";
    }

    @GetMapping("/update/{bno}")
    public String update(BoardVO board, @PathVariable(value = "bno") Long bno) {
        boardService.update(board, bno);
        return "redirect:/";
    }

    @GetMapping("/undo/{bno}")
    public String undo(BoardVO board, @PathVariable(value = "bno") Long bno) {
        boardService.undo(board, bno);
        return "redirect:/";
    }

    @GetMapping("/delete/{bno}")
    public String delete(BoardVO board, @PathVariable(value = "bno") Long bno) {
        boardService.delete(board, bno);
        return "redirect:/";
    }
}
