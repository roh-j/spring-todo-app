package com.example.persistance;

import com.example.domain.BoardVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from board where isComplete = FALSE order by bno desc")
    public List<BoardVO> toDo();

    @Select("select * from board where isComplete = TRUE order by bno desc")
    public List<BoardVO> complete();

    @Insert("insert into board (title, content, writer) values (#{title}, #{content}, #{writer})")
    public void insert(BoardVO board);

    @Delete("delete from board where bno = #{bno}")
    public void delete(BoardVO board);

    @Select("select * from board where bno = #{bno}")
    public List<BoardVO> content(BoardVO board);

    @Update("update board set isComplete = TRUE where bno = #{bno}")
    public void update(BoardVO board);
}
