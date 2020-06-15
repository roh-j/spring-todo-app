package com.example.controller;

import com.example.domain.BoardVO;
import com.example.service.BoardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ReactController {

    private BoardServiceImpl boardService;

    @GetMapping("/react/home")
    public Map<String, List<BoardVO>> reactHome() {
        return boardService.home();
    }
}
