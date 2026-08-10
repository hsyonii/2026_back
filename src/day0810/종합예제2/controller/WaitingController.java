package day0810.종합예제2.controller;

import java.util.ArrayList;
import day0810.종합예제2.model.dao.WaitingDao;
import day0810.종합예제2.model.dto.WaitingDto;

//기본 클래스
public class WaitingController {
    //접근제한 생성자
    private WaitingController() {}
    //인스턴스 생성
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance() {
        return instance;
    }

    
    private WaitingDao wd = WaitingDao.getInstance();

    // 1. 대기등록 제어 : view에서 name,count 전달받고 bool값 전달해야 함
    public boolean addWaiting(String name, int num) {
        //값을 Dto로 저장
        WaitingDto waitingDto = new WaitingDto(name, num);
        return wd.addWaiting(waitingDto);
    }

    // 2. 대기보기 제어
    public ArrayList<WaitingDto> findAll() {
        return wd.findAll();
    }

    // 3. 대기삭제 제어
    public boolean deleteWaiting(String name) {
        return wd.deleteWaiting(name);
    }

    // 4. 대기수정 제어
    public boolean updateWaiting(String name, int num) {
        return wd.updateWaiting(name, num);
    }
}