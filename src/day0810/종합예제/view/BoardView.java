package day0810.종합예제.view;

import java.util.Scanner;

import day0810.종합예제.controller.BoardController;
import day0810.종합예제.model.dto.BoardDto;

public class BoardView {
    //[싱글톤 만들기]
    //클래스정의
    private BoardView(){};
    //인스턴스(객체) 생성
    private static final BoardView instance = new BoardView();
    //
    public static BoardView getInstance(){
        return instance;
    }
    //view에서 controller호출
    private BoardController bc = BoardController.getInstance();

    private Scanner scan = new Scanner(System.in);

    public void index(){
        while(true){
            System.out.print("1.등록  2.전체조회");
            int ch = scan.nextInt();
            if(ch==1) save();
            else if(ch==2) findAll();
        }
    }

    //게시물입력
    public void save (){
        System.out.print("내용: ");
        String 내용 = scan.next();
        System.out.print("\n작성자: ");
        String 작성자 = scan.next();

        BoardDto boardDto = new BoardDto(내용, 작성자);
        boolean result = bc.save(boardDto);
        if(result){
            System.out.println("등록성공");
        }
        else{
            System.out.println("등록실패");
        }
    }

    //게시물출력
    public void findAll(){
        ArrayList<BoardDto> result = bc.findAll();
        for(BoardDto board : result){
            System.out.println(board.getWriter()+":"+board.getContent());
        }
    }
}
