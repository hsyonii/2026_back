package day0810.종합예제.model.dto;

public class BoardDto {
    // DTO: 데이터 이동 객체
    // 1. DB에서 사용할 자료들을 private 멤버 변수로 구성
    private String content;
    private String wirter; 
    // 2. 기본생성자, 전체매개변수 생성자
    public BoardDto(String content, String wirter) {
        this.content = content;
        this.wirter = wirter;
    }
    // 3. getter/setter , toString
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWirter() {
        return wirter;
    }
    public void setWirter(String wirter) {
        this.wirter = wirter;
    }
    @Override
    public String toString() {
        return "BoardDto [content=" + content + ", wirter=" + wirter + "]";
    }
    
}
