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
    // [*] 입력객체
    private Scanner scan = new Scanner(System.in);
    // [*] 최초 루프/화면
    public void run( ){
        while( true ){
            try{ // 예외처리 
                System.out.print("1.등록 2.전체조회 3.개별수정 4.개별삭제 선택:");
                int ch = scan.nextInt();
                if( ch == 1 ){ }
                else if( ch == 2 ){ }
                else if( ch == 3 ){ }
                else if( ch == 4 ){ }
            }catch( InputMismatchException e ){
                // 입력(성공) 했지만 타입반환에서 예외 이므로 입력객체 초기화
                scan = new Scanner( System.in );
                System.out.println("[다시입력]" + e);
            }
        }
    }
} // class end 

