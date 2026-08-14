package day0813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam2 {
    public static void main(String[] args) {
    try{
    // **lib폴더에 .jar 있어야함
    //1. MYSQL에서 제공하는 Driver구현체(java-DB 연결) 로드 **예외처리 필수
    Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName() : 문자열로된 클래스이름을 받아 불러오는 자바메소드
        //"com.mysql.cj.jdbc.Driver" : .jar 파일 내 물리적 위치(파일 주소)
    //성공시
    System.out.println("Driver 연동성공");

    //2. 데이터베이스 서버연동
    String url = "jdbc:mysql://127.0.0.1:3306/mydb0813"; //DB 주소
    //mysql 계정정보
    String user = "root";
    String password = "1234";
    //DB url & mysql 계정정보 conn객체에 담아 연동
    Connection conn = DriverManager.getConnection(url,user,password);
    //성공시
    System.out.println("데이터 베이스 연동성공");

    // 1. insert : insert into test(필드명) values(값)
    String sql = "insert into test(name) values('유재석')";// 자바문자열에 SQL작성
    PreparedStatement ps = conn.prepareStatement(sql); //작성한 sql문장을 이상이 없는지 검사후 변수ps 에 저장
    int result = ps.executeUpdate(); //작업 처리여부 검증하는 문장
        //excuteUpdate() : DB 추가/수정/삭제 구문 실행하는 메소드
        //                 반환 값 : 정수(int) 1. insert실행시 추가된 데이터 개수
        //                                     2. update : 수정된 데이터 개수
        //                                     3. delete : 삭제된 데이터 개수 
        //vs
        //excuteQuery : DB에서 찾은 데이터 목록 반환
    System.out.println(result);
    System.out.println("레코드 등록성공");

    // 2. select : select 필드명 from 테이블명;
    String sql2 = "select * from test";
    PreparedStatement ps2 = conn.prepareStatement(sql2); //sql2 검증
    ResultSet rs = ps2.executeQuery();
        //ResultSet : 2차원 표 담는 객체 타입
    rs.next();
        //Resultset타입변수.next(); : 헤더가 아닌 데이터가 있는 1번째행에 데이터 존재 여부를 확인하여 true/false 리턴
    //ResultSet에서 데이터 추출
    System.out.println(rs.getInt("no"));
    System.out.println(rs.getString("name"));
    System.out.println("레코드 조회 성공");
    }
    catch(ClassNotFoundException e){ //e : 에러객체변수명 (변경가능)
        System.out.println("클래스가 존재하지 않습니다"+e);
    }
    catch(SQLException e){
        System.out.println("DB서버와 연동 실패했다."+e);
    }
}
}
