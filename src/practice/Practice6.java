package practice;

import java.util.Scanner;

public class Practice6 {
    public static void main(String[] args) {
        //문제1
        // (1)크기지정 , 빈배열 선언
        // 요소타입 배열이름[] = new 요소타입[배열크기];
        // (2) 배열선언 , 요소넣기
        int numbers1[] = {10, 20, 30, 40, 50};
        // 인덱스 사용하여 배열의 특정요소값 호출
        System.out.println(numbers1[2]);


        //문제2
        String season[] = new String[3];
        // 인덱스 사용하여 요소값 추가
        season[0] = "봄";
        season[1] = "여름";
        season[2] = "가을";
        System.out.println(season);

        //문제3
        String[] fruits = {"사과", "바나나", "포도", "딸기"};
        // 배열이름.length; : 배열크기 반환
        for(int i = 0; i<= fruits.length-1; i++){
            System.out.println(fruits[i]);
        }

        //문제4
        int[] scores1 = {85, 92, 78, 65, 95};
        int 합계 = 0;
        for(int i =0 ; i<=scores1.length-1; i++){
            합계 = 합계 + scores1[i];
        }
        double 평균 = 합계/scores1.length;
        System.out.printf("합계: %d, 평균: %f",합계, 평균);

        //문제5
        int[] scores2 = {77, 82, 100, 54, 96};
        for(int i = 0 ; i <= scores2.length-1 ; i++){
            if(scores2[i] == 100){
                System.out.println("만점자를 찾았습니다!");
                break;
            }
        }

        //문제6
        String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
        int count = 0;
        for(int i =0; i<=bloodTypes.length-1; i++){
            if(bloodTypes[i].equals("A")){
                count ++;
            }
        }
        System.out.printf("%d명",count);

        //문제7
        System.out.println("문제7");
        int[] numbers2 = {23, 5, 67, 12, 88, 34};
        int 큰수 = numbers2[0];
        for(int i =0 ; i<= numbers2.length-1 ; i++){
            if (큰수 < numbers2[i]){
                큰수 = numbers2[i];
            }
        }
        System.out.printf("가장 큰 수: %d",큰수);

        //문제8
        String[] products = {"볼펜", "노트", "지우개"};
        int[] stock = {10, 5, 20};
        System.out.print("문제8\n제품명: ");
        Scanner scan = new Scanner(System.in);
        String 제품 = scan.next();
        System.out.print("\n수량: ");
        int 수량 = scan.nextInt();
        for(int i = 0; i <= products.length-1; i++){
            if(products[i].equals(제품)){
                if(수량<=stock[i]){
                    stock[i] = stock[i]-수량;
                    System.out.println("구매 완료!");
                }
                else
                    System.out.println("재고가 부족합니다.");
            }
            else
                System.out.println("없는 제품명 입니다.");
                break;
        }

        //문제9
        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};
        System.out.println("문제9");
        for(int i = 0; i <= movieNames.length-1; i++){
            System.out.printf("\n%s: ",movieNames[i]);
            for(int j = 1; j <= movieRatings[i]; j++){
                System.out.print("★");
            }
            for(int j = 1; j <= 10-movieRatings[i]; j++){
                System.out.print("☆");
            }
        }

        //문제10
        System.out.println("\n문제10");
        String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
        int[] usageMinutes = {65, 30, 140, 420};
        int 요금 = 1000;
        for(int i = 0; i<=carNumbers.length-1; i++){
            System.out.printf("%s: ",carNumbers[i]);
            if(30<usageMinutes[i]){
                요금+=(usageMinutes[i]-30)/10*500;
                if(20000<=요금)
                    요금 = 20000;
            }
            System.out.printf("%d분 주차, 최종 요금: %d원\n",usageMinutes[i],요금);
        }
    }
}
