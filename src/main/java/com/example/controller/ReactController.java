package com.example.controller;

import com.example.domain.BoardVO;
import com.example.service.BoardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/react/insert")
    public Boolean insert(BoardVO board, @RequestBody Map<String, Object> param) {
        // param Data 캐스팅 필요
        board.setTitle((String) param.get("title"));
        board.setContent((String) param.get("content"));
        board.setWriter((String) param.get("writer"));

        return boardService.insert(board);
    }
}
