package day0811;

public class Exam2 {
    int value1 = 10;
    int vlaue2 = 20;
    상위클래스(){
        System.out.println("상위 클래스");
    }
    void show(){
        System.out.println("상위 메소드 실행");
    }
    class 하위클래스 extends 상위클래스 {
        int value3 = 30;
        int value4 = 40;
        하위클래스(){
            System.out.println("하위 클래스");
        }
    }
}
