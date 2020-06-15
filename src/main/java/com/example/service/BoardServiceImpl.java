package com.example.service;

import com.example.domain.BoardVO;
import com.example.persistance.BoardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardMapper boardMapper;

    @Override
    public Timestamp getTime() {
        Date date = new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }

    @Override
    public List<List<BoardVO>> home() {
        List<List<BoardVO>> list = new ArrayList<>();
        list.add(boardMapper.toDo());
        list.add(boardMapper.complete());

        return list;
    }

    @Override
    public List<BoardVO> content(BoardVO board, Long bno) {
        board.setBno(bno);
        return boardMapper.content(board);
    }

    @Override
    public boolean insert(BoardVO board) {
        board.setRegDate(this.getTime());
        board.setUpdateDate(this.getTime());
        return boardMapper.insert(board);
    }

    @Override
    public boolean update(BoardVO board, Long bno) {
        board.setBno(bno);
        board.setUpdateDate(this.getTime());
        return boardMapper.update(board);
    }

    @Override
    public boolean undo(BoardVO board, long bno) {
        board.setBno(bno);
        board.setUpdateDate(this.getTime());
        return boardMapper.undo(board);
    }

    @Override
    public boolean delete(BoardVO board, Long bno) {
        board.setBno(bno);
        return boardMapper.delete(board);
    }
}
