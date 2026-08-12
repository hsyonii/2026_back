package day0812;

import day0812.Exam1.ExamInterface;

public class Exam1 {
    // 인터페이스 
    //  - interface 인터페이스명 {}
    //  - 주요멤버: 상수, 추상메소드
    //  - 추상메소드 구현할 클래스 필요 (구현 객체)
    //      : 클래스명 implemnets 인터페이스명, 인터페이스명
    interface ExamInterface{
        int a = 10; //인터페이스에서 public static final 생략해도 상수!!
        // =
        public static final int b = 20; //상수

        // 생성자 없음. new 인터페이스; -> 불가능!!
        // 목적: 여러인스턴스 호환 / 관리

        // **추상 메소드: { }동작 (구현부) 없는 메소드
        void method1(int x);
        // =
        public abstract int method2(int x,int y); //public abstract 생략가능
        //구현부 작성 필수. 미작성시 오류!!
    }
    public static void main(String[] args) {
            //ExamInterface ei = new ExamInterface(); // 인터페이스로 인스턴스 생성 불가능!!
            ExamClass ec= new ExamClass(); //구현 클래스에서 객체 생성 가능
            ec.method1(10); //가능
            ec.method2(1, 2); // 가능

            ExamInterface ei = new ExamClass(); // 업캐스팅
            //인터페이스 타입 이더라도 오버라이딩 우선!!
            ei.method1(10); //가능
            ei.method2(10, 20); //가능
    }
}
class ExamClass implements ExamInterface{ //해당 클래스가 지정한 인터페이스 구현
    //오버라이딩 필수
    @Override
    // 추상메소드와 동일하게 작성
    // 우클릭 -> 소스작업 -> Override/Implement
    public void method1(int x){
        System.out.println(x);
    }
    @Override
    public int method2(int x , int y){
        return x + y;
    }
}