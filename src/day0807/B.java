//Exam1
package day0807;

public class B {
    public void 메소드(){
        A a = new A();
        a.공개변수=3; //public -> 가능
        //a.비공개변수=3; //private: 같은 클래스 내에서만 가능 -> 불가능!
        a.일반변수=3;//default -> 같은 패키지 내에서 가능
    }
    private B(){} //비공개 생성자
}
