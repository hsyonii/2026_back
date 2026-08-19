package day0819;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Exam1 {
    public static void main(String[] args) {
        // 1. 래퍼 클래스 : 기본타입 -> 참조타입 표현
        int value1 = 100;
        // System.out.println(value1.toString()); -> 불가능
        Integer value2 = 100;
        System.out.println(value2.toString(value1)); // -> 가능
        // 기본타입: 기능없음 -> 참조타입 변환 후 기능 사용!!
        // 1) 언박싱 / 오토박싱
        int value3 = value2; //언박싱 : Integer(참조) -> int(기본) 변환
        Integer value4 = value1; //오토박싱 : int(기본) ->Integer 변환
        // 2) 타입변환 (CSV,excel,api,Python,json...)
        // 타입.parse타입(문자열) : 원하는 타입으로 변환
        int value5 = Integer.parseInt("100"); //"100" -> 100 (스프링에서는 자동)
        double value6 = Double.parseDouble("3.14");
        boolean value7 = Boolean.parseBoolean("true");
        // String.valueOf(리터럴) : 기본타입 -> 문자열 변환
        String s1= 100+""; //100 -> "100"
        String s2 = String.valueOf(100); // 100 -> "100"

        // 2. 날짜/시간 클래스
        // 1) 현재날짜 가져오기
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 2) 현재시간 가져오기
        LocalTime localtime = LocalTime.now();
        System.out.println(localtime);
        // 3) 현재 날짜/시간 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 4) LocalDateTime.of(): 정해진 날짜/시간 객체 생성(*오버로딩)
        //                          *오버로딩: 매개변수에 따른 메소드를 여러개 만듬
        LocalDateTime localDateTime2 = LocalDateTime.of(2026,8,19,11,11,30);

    }
}
