package day0812.종합예제.controller;

import java.util.ArrayList;

import day0812.종합예제.model.dao.BoardDao;
import day0812.종합예제.model.dao.IBaseDao;
import day0812.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController() {}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() { return instance; }

    private IBaseDao ib = BoardDao.getInstance();
    
    //오버라이딩X 오버로딩ㅇ : 이름만 같은 다른 메소드(매개변수 타입or개수 다른경우)
    //Object타입으로 Dao에 넘겨줘야함
    public boolean save(BoardDto boardDto) {
        // TODO 1: boardDto 전달받아 DAO의 save()를 호출하고 결과 반환
        Object obj1 = boardDto;
        boolean result = ib.save(obj1);
        return result;
    }

    public ArrayList<BoardDto> findAll() {
    // TODO 2: DAO의 findAll() 호출하여 결과 반환
    ArrayList<Object> list = ib.findAll();
    ArrayList<BoardDto> result = new ArrayList<>();
    for (Object item : list) { // Object를 하나씩 꺼내서
        result.add((BoardDto) item); //boardDto 로 형변환한 뒤
    } //게시글 전용 result에 넣기
    // **강제형변환 안됨!! Object 와 BoardDto는 상속관계이지만 ArrayList<Object>와 ArrayList<BoardDto>는 상속관계 X
        return result;
    }
}

// dto - 데이터 속성 정의 (공통 필드), dao는 데이터 관리(단순 저장,삭제, 조회 등) 의 반복적 패턴
// controller는 메소드별로 동작흐름이 다르기 때문에 상속 사용 X