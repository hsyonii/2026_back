package day0810.종합예제2.model.dao;

import java.util.ArrayList;
import day0810.종합예제2.model.dto.WaitingDto;

public class WaitingDao {
    private WaitingDao() {}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {
        return instance;
    }

    private ArrayList<WaitingDto> waitingList = new ArrayList<>();

    // 1. 대기등록
    public boolean addWaiting(WaitingDto waitingDto) {
        return waitingList.add(waitingDto);
    }

    // 2. 대기보기
    public ArrayList<WaitingDto> findAll() {
        return waitingList;
    }

    // 3. 대기삭제
    public boolean deleteWaiting(String name) {
        for (int i = 0; i < waitingList.size(); i++) {
            if (waitingList.get(i).getName().equals(name)) {
                waitingList.remove(i);
                return true;
            }
        }
        return false;
    }

    // 4. 대기수정
    public boolean updateWaiting(String name, int num) {
        for (WaitingDto dto : waitingList) {
            if (dto.getName().equals(name)) {
                dto.setNum(num);
                return true;
            }
        }
        return false;
    }
}