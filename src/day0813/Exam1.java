package day0813;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        //예외 : 에러발생시 수정 X 흐름제어
        //try{ 예외발생코드 } catch(예외클래스명 변수명){ 처리할 코드 }
        //1. 일반예외: 실행하기전 예외가 발생할 수 있는 코드에 대해 미리 예외 작성
        try{
            Class.forName("String"); //Class.forName("찾을클래스명") : 동적클래스 로드(읽어오기) 
        }
        catch(ClassNotFoundException e){
            System.out.println("존재하지 않은 클래스입니다.");
        }

        try{
            Thread.sleep(1000);
            //Thread: 컴파일된 코드를 읽어주는 흐름
            //Thread.sleep(밀리초); : 밀리초 만큼 스레드 일시정지
        }
        catch(InterruptedException e){
            System.out.println("인터럽트 문제 발생");
        }
        String str1 = null;
        System.out.println(str1.length());

        // 2. 실행예외 : 실행후 예외발생 예측 or 유지보수 시(로그)
        // NullPointerException : 참조가 없는 데 참조하는 경우
        try{
            String str1= null;
            System.out.println(str1.length());
        }
        catch(NullPointerException 변수){
            System.out.println(변수);
        }
        //NumberFormatException : 숫자타입으로 변환이 불가능한 경우
        try{
        String str2= "100";
        Integer.parseInt(str2); //Integer.paseInt(문자형변수); : 문자->정수 변환 함수
        String str3 = "100a";
        Integer.parseInt(str3); //"100" -> 100 가능 , "100a" ->  불가능!!
        }
        catch(NumberFormatException e){
            System.out.println(e);
        }
        //ArrayIndexOutOfBoundsException
        try{
        int[] 배열1= {10,25};
        System.out.println(배열1[0]);
        System.out.println(배열1[5]); //없는 인덱스 호출??
        }
        catch(ArrayIndexOutOfBoundsException e){
        // = catch(Exception e)
        // 여러타입의 예외들의 상위 클래스인 Exception으로 대체 가능 ㅇ!!
            System.out.println(e);
        }

        //외에도 수많은 예외 존재!!

        //InputMismatchException : 입력타입 예외 발생
        Scanner scan = new Scanner(System.in);
        try{
        System.out.println("정수입력");
        int ch = scan.nextInt();
        Integer.parseInt("ABC"); //예외
        }
        //3. 다중 캐치 캐치도 가능
        catch(InputMismatchException e){
            System.out.println("정수만 입력하세요"+e);
        }
        catch(NumberFormatException e){
            System.out.println("타입변환 오류"+e);
        }
        catch(Exception e){
            System.out.println("관리자에게 문의: "+ e);
        }
        //4. 예외 발생여부 상관없이 무조건 실행 
        finally {
            System.out.println("무조건 실행");
        }

        //5.예외던지기(떠넘기기) : 해당 메소드를 호출한 곳으로 예외 반환
        method1(); //예외가 반환
    }//main end
    public static void method1() throws ClassNotFoundException{
        Class.forName("java.lang.Spring"); //예외발생
    }
}
