package day0810.종합예제.controller;

import day0810.종합예제.model.dao.BoardDao;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    //view -> controller -> dao 
    //controller에서 dao호출
    private BoardDao bd = BoardDao.getInstance(); 

    // 1)게시물 작성 컨트롤러
    public boolean save(BoardDto boardDto){
        //1.view로 부터 저장할 정보 객체로 받는다.
        //**유효성검사 / 타입변환 등
        //2.DAO에게 요청하고 응답받기
        boolean result = bd.save(boardDto);
        //3.DAO에게 받은 결과를 VIEW에게 응답하기
        return result;
    }

    //
    public ArrayList<BoardDto> findAll(){
        return result;
    }
}
