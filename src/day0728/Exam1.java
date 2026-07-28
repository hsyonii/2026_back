package day0728; // package(폴더명): 클래스의 위치 식별용도

import java.util.Scanner;

public class Exam1 { 
    // 클래스 안, main 밖 에서 선언/만들기 만 가능하다.
    int a = 10;

    /* 메인 함수(메인 스레드): 번역한 코드를 읽어주는 흐름단위 */
    // m + enter: main() 자동완성
    public static void main(String[] args){
        //so + enter
        System.out.println("안녕"); // = console.log, ;으로 문장 구분/컴파일
        System.out.println(3.14);
        System.out.println('유'); // '': 문자
        System.out.println("유재석"); // "": 문자열

        /*자료형*/
        // 1. boolean (1 byte)
        boolean bool1 = true; // let/const 대신 boolean 

        // 2. char : 문자(유니코드)
        char ch1 = 'A';
        System.out.println(ch1);

        // 3. String : 객체, 문자열(n*2 byte)
        String str1 = "abc";
        System.out.println(str1);

        // 4. 정수
        // 1) byte : -128~127(1 byte)
        byte b1 = 100;
        System.out.println(b1);
        // 2) short : 약 +-3만(2 byte)
        short sh1 = 2000;
        System.out.println(sh1);
        // 3) int : 약 +-21억(4 byte), 정수 리터럴 타입
        int i1 = 200000000;
        System.out.println(i1);
        // 4) long : +-21억 이상(8 byte)
        long l1 = 200000000000L; //값에 l/L 을 붙여 저장(정수 리터럴은 int 이므로)
        System.out.println(l1);

        // 5. 실수
        // 1) float : 소수점 8자리까지(4 byte)
        float f1 = 0.1234567890123F; //값에 f/F 붙여 저장(실수 리터럴은 double 이므로)
        System.out.println(f1);
        // 2) double : 소수점 17자리까지(8byte), 실수 리터럴 타입
        double d1 = 0.1234543464346;
        System.out.println(d1);

        //8가지 타입 vs 그외(String)타입 (참조타입, 클래스/객체/인터페이스/배열 등등)

        /*출력함수*/
        //1. System.out.println(); : 출력후 자동 줄바꿈
        
        //2. System.out.print(); : 출력
        
        //3. System.out.printf(형식,자료);
        System.out.printf("저는 %s 이고 나이는 %d 입니다.","유재석",40);
        // %c : 문자, %s : 문자열, %d : 정수 , %f : 실수
        // %자릿수d : 자리수 만큼 차지, 비어있으면 공백, 우측정렬
        // %-자릿수d : 자릿수 만큼 차지, 만일 비어있으면 공백, 왼쪽정렬
        // %0자릿수d : 자릿수 만큼 차지, 비어있으면 0 채움
        // %전체자릿수.소수자릿수f
        //문자(열) & 값(변수)을 분리해서 사용

        //**이스케이프/제어 문자
        //1. \n: 줄바꿈
        //2. \t: 들여쓰기
        //3. \',\",\\: ' , " ,\ 출력

        /* 입력객체 */
        // 1. Scanner : 입력클래스, 코드파일 상단에 import java.util.Scanner; 추가해야함.
        // 2. 변수명은 관례적으로 클래스명의 소문자로 설정 (Scanner, scanner)
        // 3. new : 인스턴스화, 해당 클래스 객체 만든다는 뜻
        // 4. Scanner(System.in): 생성자 안에 시스템 입력 객체
        Scanner scanner = new Scanner(System.in);

        /* 입력함수 */
        System.out.print("문자열 입력: ");
        String str = scanner.next(); //기본형
        int j  = scanner.nextInt(); //자료형 지정해 입력받기
        System.out.printf("입력받은 자료: %d \n",j);
    }
}
