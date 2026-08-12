package day0812;

//폴더 우클릭 -> new java file -> interface
public interface KeyBoard {
    //1. 상수
    public static final String info = "인텔";
    String date = "2026-08-12";
    //2. 추상메소드
    public abstract void aKey();
    int bKey (int x);
}
