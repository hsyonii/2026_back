package day0811;

public class Exam1 {
    public static void main(String[] args) {
        //1. 동물객체 생성
        동물 animal1 = new 동물(); //생성자 실행
        animal1.name = "강아지"; //멤버변수 접근
        animal1.show(); //메소드 실행

        //2. 조류객체 생성
        조류 bird1 = new 조류(); //조류생성자 + 동물생성자 실행
        bird1.name = "비둘기";
        //조류 클래스에는 변수 name이 없지만 부모클래스에 있으므로 사용 가능
        bird1.show(); //부모의 메소드 실행 가능
        //하위클래스의 객체(인스턴스)는 상위클래스의 멤버(변수/메소드) 사용가능
        
        참새 sparrow1 = new 참새();
        sparrow1.name = "참새";
        sparrow1.show();
        닭 chicken1 = new 닭(); //닭생성자 - 조류생성자 - 동물생성자
        chicken1.name = "닭";
        chicken1.show();
        //하위클래스의 객체를 생성하면 상위클래스의 객체가 먼저 생성되고 하위 클래스 객체가 생성

        // **다형성
        //  - 하나의 자료가 다양한 형(형식/모양/형태/구분)
        //  - 참새 타입에서 조류 타입 가능한이유?
        //      참새 인스턴스가 생성될때 조류+동물 인스턴스생성
            조류 bird2 = sparrow1; //업캐스팅
            동물 animal2 = sparrow1; //업캐스팅
            참새 sparrow2 = (참새)animal2; //강제타입변환, 다운캐스팅
            참새 sparrow3 = (참새)animal1; // -> 오류발생
        
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();
    }
}

//부모(상위) 클래스
class 동물{
    //1. 멤버변수
    String name;
    //2. 생성자
    동물(){
        System.out.println("동물 탄생");
    }
    //3. 메소드
    void show(){
        System.out.println("동물 입니다.");
    }
}
//하위 클래스
class 조류 extends 동물{ }
class 참새 extends 조류{ }
class 닭 extends 조류{ }

/*
     < 가계부 >

        동물
         |
        조류
       /    \
    닭      참새

*/

class A{
    A(){
        System.out.println("A객체");
    }
}

class B extends A{
    B(){
        System.out.println("B객체");
    }
}

class C extends A{
    C(){
        System.out.println("C객체");
    }
}

class D extends B{
    D(){
        System.out.println("D객체");
    }
}

class E extends C{
    E(){
        System.out.println("E객체");
    }
}