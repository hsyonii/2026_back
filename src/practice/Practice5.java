package practice;

import java.util.Scanner;
import java.util.ArrayList;

public class Practice5 {
    public static void main(String[] args) {
        //문제1
        for(int i=1; i<=10; i++)
            System.out.println(i);

        //문제2
        for(int i=10; i>=1; i--)
            System.out.println(i);

        //문제3
        int 합계=0;
        for(int i=1; i<=50; i++){
            합계 = 합계+i;
        }
        System.out.println(합계);

        //문제4
        for(int i=1; i<=20; i++){
            if(i%2==0)
                System.out.println(i);
        }

        //문제5
        for(int i =1; i<=30; i++){
            if(i%3 != 0){
                System.out.println(i);
            }
        }
        //문제6
        int total = 0;
        for(int i=1; ; i++){
            total = total + i;
            if(100<total){
                System.out.printf("초과시점 숫자: %d",i);
                System.out.printf("\n합계 : %d", total);
                break;
            }   
            
        }
        
        //문제7
        System.out.println("문제7");
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i ; j ++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        //문제8
        for(int i = 5; i>=1 ; i++){
            for (int j = 1; j<= i; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        //문제9
        System.out.println("문제9");
        Scanner scan = new Scanner(System.in);
        //문자열 선언
        //담을타입 배열이름[] = {내용물,내용물, ...};
        //ArrayList<담을요소타입> 리스트이름 = new ArratList<>();
        ArrayList <String> array = new ArrayList<>();
        int count = 0 ;
        while (true) {
            System.out.print("입력: ");
            String 입력 = scan.next();
            if(입력.equals("end")){
                break;
            }
            array.add(입력); //ArrayList이름.add(추가할요소);
            count ++;
        }
        for(int i = 1 ; i<=count ; i++){
            System.out.printf("%d회 입력: %s",i,array.get(i-1));
            //ArrayList.get(인덱스); 특정인덱스 값 가져오기
        }

        //문제10
        int july1 = 3532100;
        int july2 = 9123700;
        int july3 = 5183400;
        int july4 = 11738700;
        System.out.println("[ 7월 매출액 ]");
        for(int i = 1; i <= 4 ; i++){
            System.out.printf("\n%d주차: ",i);
            int 만원 = 0;
            if(i == 1) 만원 = july1/10000;
            else if (i==2) 만원 = july2/10000;
            else if (i==3) 만원 = july3/10000;
            else if (i==4) 만원 = july4/10000;
            for(int j = 1; j<=만원/100; j++){
                System.out.print("■");
            }
            System.out.printf("%d만원",만원);
        }

        //문제11
        for(;;){
        System.out.println("[ 메뉴 선택 ]");
        System.out.println("1.입금  2.출금  3.잔고  4.종료");
        System.out.print("입력: ");
        int 선택 = scan.nextInt();
        int 잔액 = 0;
        if(선택 == 1){
            System.out.println("\n[ 입금 ] ");
            System.out.print("입금액: ");
            int 입금 = scan.nextInt();
            잔액 = 잔액 + 입금;
            System.out.printf("\n%d원",잔액);
        }
        else if(선택 == 2){
            System.out.println("\n[ 출금 ]");
            System.out.print("출금액: ");
            int 출금 = scan.nextInt();
            if(잔액<출금){
                System.out.println("\n잔액 부족");
            }
            else{
                잔액 = 잔액-출금;
                System.out.printf("\n%d원",잔액);
            }
        }
        else if (선택 == 3){
            System.out.println("\n[ 잔고 ]");
            System.out.printf("%d원",잔액);
        }
        else{
            System.out.println("프로그램 종료");
            break;
        }
        }
    }
}
