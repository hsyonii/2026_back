package day0812.종합예제.model.dao;

import java.util.ArrayList;

public interface IBaseDao {
    // [DB 연동 정보 상수 선언] * 추후에 사용 됩니다.
    String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    String DB_ID = "root";
    String DB_PW = "1234";

    boolean save(Object obj);
    ArrayList<Object> findAll();

}

// product <-> board 동작 로직/데이터 저장위치 가 다르므로 추상메소드 사용
// 동작은 implements에서 정의
// 추후 코드확장에도 용이
// 상속(부모-자식)사용하지 않는 이유?
// 코드 동작이 다르기때문에 코드 정의까지만 interface