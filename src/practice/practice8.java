package practice;

public class Practice8 {
    public static void main(String[] args) {
        // [1]
        Book b1 = new Book("이것이 자바다", "신용권", 30000 );
        Book b2 = new Book("자바의 정석", "남궁성", 28000 );

        // [2]
        Rectangle r1 = new Rectangle( 10, 0);

        // [3] 기본생성자 사용하는 경우 vs 정의생성자 사용하는 경우
        BankAccount account = 
            new BankAccount("111-222-3333", "유재석", 10000);

        // [문제 5 테스트]
        Member m1 = new Member(); // 기본 생성자로 객체 생성
        System.out.println("ID: " + m1.id);
        System.out.println("로그인 상태: " + m1.isLogin);
    }
}

class BankAccount{ // 클래스란? 객체(인스턴스) 만들기 위한 설계도( 실체가 아니다. )
    // * 클래스(설계도)가 동일하더라도 객체(인스턴스)는 new 마다 서로다른 실체!
    String accountNumber; // 멤버 변수(필드) : 객체가 생성되면 객체내 사용 할 변수 뜻
    String ownerName;
    int balance;
    // 생성자란? 객체(인스턴스) 생성할 때 초기값 대입
    // 매개변수? 외부로부터 생성자/메소드에게 전달되는 값(인수) 저장하는 변수
    // 관례적으로 생성자의 매개변수는 멤버변수명과 동일하며 this 구분
    BankAccount( String accountNumber, String ownerName, int balance ){
        this.accountNumber = accountNumber; // this.멤버변수명 = 매개변수명
        this.ownerName = ownerName;
        this.balance = balance;
    }
}

class Rectangle{
    double width;
    double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class Book{
    // 1.멤버변수 
    String title;
    String author;
    int price;
    // 2. 생성자 : 
    // *자동: 클래스내 빈공간 오른쪽 -> 소스 작업 
    //        -> constructor -> 멤버변수 체크 -> [확인]*
    Book( String title , String author , int price ){
        this.title = title;
        // this.멤버변수명 = 매개변수명;
        this.author = author;
        this.price = price;
    }
    // 3. 메소드 
}


// [문제4]
class Goods{
    String name;
    int price;
    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

//문제 5 
class Member{
    String id;
    boolean isLogin;
    public Member(String id, String isLogin) {
        this.id = "guest";
        this.isLogin = false;
    }
}