package practice;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Practice14 {
    public static void main(String[] args) {

        String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
        Scanner scan = new Scanner(System.in);
        String[] carsInfo = carParkingList.split("\n");

        while (true) {
            System.out.print("\n1.위치찾기 2.입차 3.출차 선택: ");
            int ch = scan.nextInt();

            // 1. 위치찾기
            if (ch == 1) {
                System.out.print("\n차량 번호: ");
                String carNum = scan.next();
                boolean b = false;

                for (int i = 0; i < carsInfo.length; i++) {
                    if (carsInfo[i].trim().isEmpty()) continue;
                    String[] carInfo = carsInfo[i].split(",");
                    if (carNum.equals(carInfo[1])) {
                        System.out.println("\n[차량 위치]");
                        System.out.println("위치번호: " + carInfo[0]);
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    System.out.println("(안내) 미등록 차량");
                }
            }

            // 2. 입차
            if (ch == 2) {
                System.out.println("[ 입차 ]");
                System.out.print("\n위치번호: ");
                int locationNum = scan.nextInt();
                String locationNumS = String.valueOf(locationNum);
                System.out.print("차량번호: ");
                String carNum = scan.next();
                System.out.print("입차일시(202608191423): ");
                String parkingTime = scan.next();

                boolean isOverlap = false;

                // 중복 위치 검사
                for (int i = 0; i < carsInfo.length; i++) {
                    if (carsInfo[i].trim().isEmpty()) continue;
                    String[] carInfo = carsInfo[i].split(",");
                    if (locationNumS.equals(carInfo[0])) {
                        System.out.println("\n(안내) 중복주차 불가");
                        isOverlap = true;
                        break;
                    }
                }

                // for문 종료 후 입차 처리
                if (!isOverlap) {
                    carParkingList += "\n" + locationNumS + "," + carNum + "," + parkingTime;
                    carsInfo = carParkingList.split("\n"); // 배열 목록 갱신
                    System.out.println("\n(안내) 입차처리 완료");
                    System.out.printf("위치번호: %s, 차량번호: %s\n", locationNumS, carNum);
                }
            }

            // 3. 출차
            if (ch == 3) {
                System.out.println("[ 출차 ]");
                System.out.print("차량번호: ");
                String carNum = scan.next();
                boolean b = false;
                String newCarParkingList = "";

                for (int i = 0; i < carsInfo.length; i++) {
                    if (carsInfo[i].trim().isEmpty()) continue;
                    String[] carInfo = carsInfo[i].split(",");

                    if (carInfo[1].equals(carNum)) {
                        b = true;
                        int pyear   = Integer.parseInt(carInfo[2].substring(0, 4));
                        int pmonth  = Integer.parseInt(carInfo[2].substring(4, 6));
                        int pday    = Integer.parseInt(carInfo[2].substring(6, 8));
                        int phour   = Integer.parseInt(carInfo[2].substring(8, 10));
                        int pminute = Integer.parseInt(carInfo[2].substring(10, 12));

                        LocalDateTime parkingTime = LocalDateTime.of(pyear, pmonth, pday, phour, pminute, 0);
                        LocalDateTime nowTime = LocalDateTime.now();

                        int parkingHour   = parkingTime.getHour();
                        int parkingMinute = parkingTime.getMinute();
                        int nowHour   = nowTime.getHour();
                        int nowMinute = nowTime.getMinute();

                        // 날짜 및 경과 분 계산
                        int reDay = (nowTime.getYear() - parkingTime.getYear()) * 365 
                                  + (nowTime.getDayOfYear() - parkingTime.getDayOfYear());

                        int reminutes = (reDay * 24 * 60) 
                                      + ((nowHour - parkingHour) * 60) 
                                      + (nowMinute - parkingMinute);

                        // 요금 계산 (30분 미만 무료, 10분당 1,000원)
                        int fee = 0;
                        if (reminutes > 30) {
                            fee = ((reminutes - 30) / 10) * 1000;
                        }

                        // 일일 최대 20,000원 한도 적용 (1일 = 1440분 기준)
                        if (fee >= 20000) {
                            int days = reminutes / 1440;
                            int remainMin = reminutes % 1440;
                            int mfee = (remainMin / 10) * 1000;
                            if (mfee > 20000) mfee = 20000;
                            fee = (days * 20000) + mfee;
                        }

                        System.out.println("총 주차 시간: " + reminutes + "분");
                        System.out.println("최종 주차 요금: " + fee + "원");
                    } else {
                        // 출차 대상이 아닌 차량은 새 목록 문자열에 유지
                        if (newCarParkingList.isEmpty()) {
                            newCarParkingList = carsInfo[i];
                        } else {
                            newCarParkingList += "\n" + carsInfo[i];
                        }
                    }
                }

                if (!b) {
                    System.out.println("(안내) 존재하지 않는 차량");
                } else {
                    // 데이터 반영 및 배열 갱신
                    carParkingList = newCarParkingList;
                    carsInfo = carParkingList.split("\n");
                    System.out.println("(안내) 출차처리가 완료되었습니다.");
                }
            }
        }
    }
}