package ssackdama.ssackdama.repository;


import org.springframework.stereotype.Repository;

@Repository
public class test {
    
    // 실제 db와 연결되는 영역 (dao 작성) 
    //보통 실행 될 쿼리가 들어감
}
/*
    마이바티스 사용하면 mapper인터페이스 제공
    일일이 dao를 만들지 않고 인터페이스만으로 쉽게 개발 가능
    마이바티스가 자바코드와 sql문을 분리하여 관리가능하도록!

    2가지 만들면 됨!
    1. 매퍼 인터페이스
    2. xml : sql문


    ---------매퍼 예제-----------------
    package board.board.mapper;
    import java.util.List;
    import org.apache.ibatis.annotations.Mapper;
    import board.board.dto.BoardDto;

    @Mapper
    public interface BoardMapper {
        List<BoardDto> selectBoardList() throws Exception;
    }

    -------.xml 형식의 파일의 sql---------------------
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

    <mapper namespace="board.board.mapper.BoardMapper">
      <select id="selectBoardList" resultType="board.board.dto.BoardDto">
         <![CDATA[
            SELECT
                board_idx,
                title,
                hit_cnt,
                created_datetime
            FROM
                t_board
            WHERE
                deleted_yn = 'N'
            ORDER BY board_idx DESC
         ]]>
      </select>
    </mapper>
 */