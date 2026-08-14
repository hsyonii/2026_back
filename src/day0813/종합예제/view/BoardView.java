package day0813.종합예제.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import day0812.종합예제.controller.*;
import day0812.종합예제.model.dto.BoardDto;

public class BoardView {
    private BoardView(){} // 1.
    private static final BoardView instance = new BoardView(); // 2.
    public static BoardView getInstance( ){ return instance; } // 3. 

    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private BoardController bc = BoardController.getInstance();
    // 입력객체
    private Scanner scan = new Scanner(System.in);
    //최초 루프/화면
    public void run(){
        while(true){
            try{
            System.out.println("1.등록  2.전체조회  3.개별수정  4.개별삭제  선택: ");
            int ch = scan.nextInt();
            if (ch == 1){
                save();
            }
            else if(ch == 2){}
            else if(ch == 3){}
            else if(ch == 4){}
            }
            catch (InputMismatchException e) {
                scan = new Scanner(System.in); //입력받은 값의 타입이 일치하지 않을때 입력객체 초기화
                System.out.println("다시 입력"+e);
            }
        }
    }

    // 1. 등록 view
    public void save(){
        System.out.print("내용: ");
        String 내용 = scan.next();
        System.out.print("\n작성자: ");
        String 작성자 = scan.next();
        BoardDto boardDto = new BoardDto(0,내용,작성자);
        boolean result = bc.save(boardDto;)
        if(result){
            System.out.println("등록성공!");
        }
        else{
            System.out.println("등록실패!");
        }
    }
}

