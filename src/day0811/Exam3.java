package day0811;

public class Exam3 {
    public static void main(String[] args) {
        Car myCar = new Car();
        Car yourCar = new Car(); //동일한 클래스로 서로다른 인스턴스 생성
        myCar.tire = new Tire(); 
        myCar.run(); 
        myCar.tire = new HankookTire(); 
        myCar.run(); 
        myCar.tire = new KumhoTire();
        myCar.run(); 
        System.out.println( myCar.tire instanceof Tire ); // true
        System.out.println( myCar.tire instanceof KumhoTire ); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false
      
    } // main
} // class end
class Car{ // 자동차
//멤버변수
 Tire tire;
 //메소드
 void run() { this.tire.roll(); }
}
class Tire{ // 타이어
    //메소드
    void roll(){
    System.out.println("[일반] 타이어가 회전");
 }
}
class HankookTire extends Tire{
 void roll(){ System.out.println("[한국] 타이어가 회전(업그레이드)"); }
}
class KumhoTire extends Tire{ 
    @Override //오버라이딩 : 부모 클래스로부터 물려받은 메소드를 재정의
     void roll(){ System.out.println("[금호] 타이어가 회전(업그레이드)"); }
}