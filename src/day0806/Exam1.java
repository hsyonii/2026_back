package day0806;

public class Exam1 {
    public static void main(String[] args) {

        계산기 나만의계산기 = new 계산기();
    }
}
/* 메소드 = js 함수
    1. 클래스 선언
    2. 반환타입 메소드명( 타입 매개 변수){
        return 반환값
        }
        -- 반환타입: 반환값의 타입/자료형 일치, void: 반환값 X
        -- 메소드명: 소문자 시작하는 카멜표기법
*/

class 계산기{
    //매개변수ㅇ 반환값x
    double getPI(){
        return 3.14;
    }

    //매개변수x 반환값x
    void powerOn(){
        System.out.println("ON");
        return; //반환x
    }

    //매개변수ㅇ 반환값x
    void printSum(int x, int y){
        System.out.println(x+y);
    }

    //매개변수ㅇ 반환값ㅇ

}

class 사람타입{
    String name;
    int age;
    String job;
    
}