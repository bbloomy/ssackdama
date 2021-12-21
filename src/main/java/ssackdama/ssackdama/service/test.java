package ssackdama.ssackdama.service;

import org.springframework.stereotype.Service;

@Service
public class test {
    //비지니스 로직을 처리 @Service 선언
    // 컨트롤러가 서비스 호출! 서비시는 데이터베이스에 접근하는 dao를 이용해 결과값 받아옴.
}

/*
    서비스가 구현해야할 것!! (2가지)
    1. service 인터페이스
    2. service 인터페이스가 구현한 class 만들기 (service interface 구현체)
 */

/*
    --------인터페이스 예제------------

    package board.board.service;
    import board.board.dto.BoardDto;
    import java.util.List;

    public interface BoardService {
        List<BoardDto> selectBoardList() throws Exception;

    }


    --------구현체 예제 -------------------
    package board.board.service;
    import board.board.dto.BoardDto;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import board.board.mapper.BoardMapper;

    import java.util.List;
    
    @Service
    public class BoardServicelmpl implements BoardService {

        @Autowired
        private BoardMapper boardMapper;

        @Override
        public List<BoardDto> selectBoardList() throws Exception {
            return boardMapper.selectBoardList(); //dao 즉 mapper를 호출하는 부분
        }

    }


 */