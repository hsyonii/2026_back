package day0810.종합예제2.model.dto;

public class WaitingDto {
    //매개변수 접근제한
    private String name;
    private int num;

    //생성자 //오버로딩
    //기본생성자
    //new WaitingDto(); 사용할 경우 작성
    public WaitingDto() {}
    //매개변수 생성자
    public WaitingDto(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}