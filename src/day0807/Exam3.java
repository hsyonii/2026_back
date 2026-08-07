package day0807;

public class Exam3 {
    public static void main(String[] args) {
        // 1. final
        D 객체 = new D();
        //객체.고정변수 = 20; //값 수정 불가 -> 오류!!

        // 2. static
        //클래스명.정적변수 : 객체없이 접근ㅇ
        D.정적변수 = 20; 
        D.정적변수 = 20; //총 메모리는 1개
        // vs 멤버변수
        D 객체1 = new D();
        객체1.멤버변수 = 20;
        D 객체2 = new D();
        객체2.멤버변수 = 30; //총 메모리 2개
    }
}


class D{
    // final : 초기값(필수), 이후 수정 불가(고정)
    public final int 고정변수 = 10;
    // static : 정적, 무분별한 사용을 메모리 낭비!! 전역변수와 같음.
    public static int 정적변수 = 10;
    public int 멤버변수 = 10;
    // public static final : 상수 ??static & final 조합 가능??
    public static final int 상수 = 30;
}