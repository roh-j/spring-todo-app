package com.example.controller;

import com.example.domain.BoardVO;
import com.example.persistance.BoardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private BoardMapper boardMapper;

    @GetMapping("/")
    public String home(Model model) {
        List<List<BoardVO>> list = new ArrayList<>();
        list.add(boardMapper.toDo());
        list.add(boardMapper.complete());

        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping("/content/{bno}")
    public String content(Model model, BoardVO board, @PathVariable(value = "bno") Long bno) {
        board.setBno(bno);
        model.addAttribute("content", boardMapper.content(board));

        return "content";
    }

    @PostMapping("/insert")
    public String insert(BoardVO board) {
        boardMapper.insert(board);

        return "redirect:/";
    }

    @GetMapping("/update/{bno}")
    public String update(BoardVO board, @PathVariable(value = "bno") Long bno) {
        board.setBno(bno);
        boardMapper.update(board);

        return "redirect:/";
    }

    @GetMapping("/delete/{bno}")
    public String delete(BoardVO board, @PathVariable(value = "bno") Long bno) {
        board.setBno(bno);
        boardMapper.delete(board);

        return "redirect:/";
    }
}
