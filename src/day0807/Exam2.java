package day0807;

public class Exam2 {
    public static void main(String[] args) {
        // 1. getter / setter
        User u1 = new User();
        //u1.name = 유재석 //멤버변수가 private -> 접근 불가
        u1.setName("유재석"); //간접접근 허용
        //System.out.println(u1.name); //직접 접근 불가능
        System.out.println(u1.getName()); //간접 접근 ㅇ
        
        // 2. toString
        //  - java : 객체 출력 시 객체 주소값 반환된다.
    }
}

class User {
    // 1.
    // 클래스 내 멤버변수는 관례적으로 private
    private String name;
    private int age;
    //**private에 대한 간접접근 메소드: setter, getter, set멤버변수, get멤버변수
    //  getter존재하면 VO(value object) 읽기모드
    //  setter/getter존재하면 DTO(data transfer object) 읽기/쓰기모드

    //우클릭 -> 소스작업 -> generate setter and getter : 자동완성
    //생성자 지정시 간접 접근 메소드 함께 설정
    public void/*반환값X 메소드*/ setName /*set~~~*/(String name){
        //추후에 유효성 검사 활용 가능
        this.name = name;
    }
    public String/*문자열반환 메소드*/ getName(){
            return this.name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // 2.
    // 매개변수에 대한 toString
    // 우클릭 -> 소스작업 -> generate to string : 객체 호출시 주소값 대신 문자열 반환(js, python 같이)
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
    /* DTO: DB -> 이동DTO -> 프론트엔드
            (1)관례적으로 멤버변수는 private
            (2)setter/getter 제공
            (3)toString 제공
            (4)생성자는 기본생성자 1(깡통) + 전체매개변수 담은 생성자 1        
    */
    /* MVC 패턴: 대규모-체계적으로 클래스 역할 나누기
        v : view (입출력)
        c : controller (제어 back/front 중계)
        m : model (데이터 담당)
        ex) - 1인 식당 : 사장이 요리-서빙-재료관리
            - n인 식당 : 요리사 / 서버 / 재료담당자
    */
}