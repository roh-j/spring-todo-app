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

    @Insert("insert into board (title, content, writer, regDate, updateDate) values (#{title}, #{content}, #{writer}, #{regDate}, #{updateDate})")
    public boolean insert(BoardVO board);

    @Delete("delete from board where bno = #{bno}")
    public boolean delete(BoardVO board);

    @Select("select * from board where bno = #{bno}")
    public List<BoardVO> content(BoardVO board);

    @Update("update board set isComplete = TRUE, updateDate = #{updateDate} where bno = #{bno}")
    public boolean update(BoardVO board);

    @Update("update board set isComplete = False, updateDate = #{updateDate} where bno = #{bno}")
    public boolean undo(BoardVO board);
}
