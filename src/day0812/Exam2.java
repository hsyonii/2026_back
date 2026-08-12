package day0812;

public class Exam2 {  
    public static void main(String[] args) {
        KeyBoard myBoard;
        myBoard = new SportsGame();
        myBoard.aKey();
        myBoard = new ActionGame();
        myBoard.aKey();
    }
}

class ActionGame implements KeyBoard{
    @Override
    public void aKey(){
        System.out.println("공격");
    }
    @Override
    public int bKey(int x){
        System.out.println("방어");
        return x;
    }
}
class SportsGame implements KeyBoard{
    @Override
    public void aKey(){
        System.out.println("슈팅");
    }
    @Override
    public int bKey(int x){
        System.out.println("수비");
        return x;
    }
}

interface Buy{
    // 인터페이스 메서드
    // **1. 추상메소드 : 구현부 X 
    public abstract void method1();
    // 2. 디폴트메소드 : 구현부 ㅇ
    public default void method2(){};
    // 3. 정적 메소드 : static 이면 인스턴스(구현체) 없이 사용ㅇ
    public static void method3(){};
    // 4. 비공개 메소드 : 하위타입 오버라이딩(구현) 불가능 메소드
    private void method4(){}
}
interface Sell{
    void method5 (); //생략시 default 적용
}
class Customer implements Buy, Sell{ //1개 구현 클래스 - 2개 이상 인터페이스 가능!!
    @Override public void method1(){}
    @Override public void method5(){}
}

// 인터페이스 끼리의 상속 가능
interface CutomerControl extends Buy, Sell{
    void order(); // 추상 메소드
}

class Customer2 implements CustomerControl{
    @Override public void method1(){}
    @Override public void method5(){}
    @Override public void order(){}
}