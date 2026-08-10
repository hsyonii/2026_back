package day0810;

public class Exam2 {
    public static void main(String[] args) {
        //싱글톤 패턴: 프로그램내 단 하나의 인스턴스(객체) 갖는 설계 구조
        //목적) - 다수 인스턴스 생성 방지
        //      - 1개의 인스턴스 사용하여 메모리 공유
        View 인스턴스1 = new View();
        System.out.println(인스턴스1);
        View 인스턴스2 = new View();
        System.out.println(인스턴스1);

        Controller 인스턴스3 = Controller.getInstance();
        System.out.println(인스턴스3);
        Controller 인스턴스4 = Controller.getInstance();
        System.out.println(인스턴스4);
    }
}

class View{} // 일반 객체 클래스

class Controller{//싱글톤 클래스
    //1. private 생성자
    private Controller(){}
    //2. 1개의 인스턴스(객체) 생성
    private static final Controller instance = new Controller();
    //3. 생성한 인스턴스 간접사용되도록 getter 생성
    public static Controller getInstance(){
        return instance;
    }
}
