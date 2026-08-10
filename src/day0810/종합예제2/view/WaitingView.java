package day0810.종합예제2.view;

import java.util.ArrayList;
import java.util.Scanner;
import day0810.종합예제2.controller.WaitingController;
import day0810.종합예제2.model.dto.WaitingDto;

//view <-> cotroller <-> dao
//view/controller/dao : 싱글톤, 시스템관리
//dto: 데이터 객체

//기본클래스는 public
public class WaitingView {
    //1. 접근제한된 생성자 정의
    private WaitingView() {}
    // -> 생성자 정의할때 중괄호ㅇ
    // ex) 접근제한자 클래스명(){}

    //2. 객체(인스턴스) 생성
    private static final WaitingView instance = new WaitingView();
    //3. get/set
    //get(내부>외부): 가져오기(클래스 내부의 값을 읽어서 외부로 가져올때)
    //set(외부>내부): 외부에서 가져온 값을 내부변수에 저장or 변경
    //              ** 싱글톤에서는 set 사용하지 않음
    public static WaitingView getInstance() {
        return instance;
    }

    private WaitingController wc = WaitingController.getInstance();

    private Scanner scan = new Scanner(System.in);

    public void index() {
        while (true) { //무한루프
            System.out.println("[ 웨이팅 ]");
            System.out.println(" 1.대기등록  2.대기보기  3.대기삭제  4.대기수정");
            System.out.print("번호 선택: ");
            int ch = scan.nextInt();

            if (ch == 1) {
                addWaiting();
            } else if (ch == 2) {
                findAll();
            } else if (ch == 3) {
                deleteWaiting();
            } else if (ch == 4) {
                updateWaiting();
            }
        }
    }

    // 1. 대기등록 화면
    private void addWaiting() {
        System.out.println("[ 대기등록 ]");
        System.out.print("이름: ");
        String name = scan.next();
        System.out.print("\n인원: ");
        int num = scan.nextInt();

        //WaitingController에서 실행한 값 가져오기
        boolean result = wc.updateWaiting(name, num);
        if (result) {
            System.out.println("(안내) 대기 등록 성공\n");
        } else {
            System.out.println("(안내) 대기 등록 실패\n");
        }
    }

    // 2. 대기보기 화면
    private void findAll() {
        System.out.println("[ 대기 보기 ]");
        //ArrayList : 동적배열(크기 자동 조정), 자바 기본 클래스
        //상단에 import java.util.ArrayList;
        //ArratList<WaitingDto> : WaitingDto만 담을수 있는 ArratList
        ArrayList<WaitingDto> result = wc.findAll();
        for (int i = 0; i <= result.size()-1; i++) {
            System.out.printf("%d. %s %d명",i+1,result.get(i).getName(),result.get(i).getNum());
        }
        System.out.println();
    }

    // 3. 대기삭제 화면
    private void deleteWaiting() {
        System.out.println("[ 대기 삭제 ]");
        System.out.print("삭제할 대기자: ");
        String name = scan.next();

        boolean result = wc.deleteWaiting(name);
        if (result) {
            System.out.println("(안내) 삭제 완료");
        } else {
            System.out.println("(안내) 삭제 실패");
        }
    }

    // 4. 대기수정 화면
    private void updateWaiting() {
        System.out.print("수정할 대기자:");
        String name = scan.next();
        System.out.print("수정 인원: ");
        int num = scan.nextInt();

        boolean result = wc.updateWaiting(name, num);
        if (result) {
            System.out.println("[안내] 수정 완료\n");
        } else {
            System.out.println("[안내] 수정 실패 (대상 없음)\n");
        }
    }
}
