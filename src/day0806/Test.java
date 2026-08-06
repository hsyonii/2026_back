package day0806;
//import
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //코드: 메인함수 안
        //1~4 if,else if ,else 
    }
}

//클래스

//overallcontroller: 정보를 쓰고, 출력
// 1)신청서  2)보호소

class OverallController {
    // 보호소 객체들을 담을 배열
    Shelter[] shelters = new Shelter[30];
    // 신청서
}

class Shelter{
    int 보호소번호;
    String 보호소이름;
    public Shelter(int 보호소번호, String 보호소이름) {
        this.보호소번호 = 보호소번호;
        this.보호소이름 = 보호소이름;
    }
}
