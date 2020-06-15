package com.example.service;

import com.example.domain.BoardVO;

import java.sql.Timestamp;
import java.util.List;

public interface BoardService {
    public Timestamp getTime();
    public List<List<BoardVO>> home();
    public List<BoardVO> content(BoardVO board, Long bno);
    public boolean insert(BoardVO board);
    public boolean update(BoardVO board, Long bno);
    public boolean undo(BoardVO board, long bno);
    public boolean delete(BoardVO board, Long bno);
}
