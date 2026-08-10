package day0810.종합예제.model.dao;

import java.util.ArrayList;
import day0810.종합예제.model.dto.BoardDto;

public class BoardDao {
    private BoardDao(){}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    // 추후 MYSQL 서버 연동
    private ArrayList < BoardDto > boardList = new ArrayList<>();

    public boolean save(BoardDto boardDto){
        boardList.add(boardDto);
        return true;
    }

    public ArrayList<BoardDao>findAll(){
        return boardList;
    }
}
