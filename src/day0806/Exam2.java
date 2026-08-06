package day0806;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        OverallController controller = new OverallController();
        Scanner scan = new Scanner(System.in);
        
        for(;;){
            System.out.println("[메인메뉴]\n1.신청서 등록  2.신청서 출력  3.보호소 등록  4.보호소 출력");
            System.out.print("번호 입력: ");
            int 선택 = scan.nextInt();

            if(선택 == 1){
                // 신청서 등록
                System.out.println("[신청서 등록]");
                System.out.print("신청자: ");
                String fname = scan.next();
                System.out.print("\n전화번호: ");
                String fnumber = scan.next();
                System.out.print("\n가구원수: ");
                int ffamily = scan.nextInt();
                System.out.print("\n반려동물 경험(예:1 아니오:0): ");
                int exp = scan.nextInt();
                boolean fexp=false;
                if(exp==1)
                    fexp = true;
                System.out.print("\n이유: ");
                String freason = scan.next();
                System.out.print("\n개인정보 동의(예:1 아니오:0): ");
                int agree = scan.nextInt();
                boolean acode = false;
                if(agree==1)
                    acode = true;
                System.out.print("\n입양동물 코드: ");
                int pcode = scan.nextInt();
                System.out.print("\n거주 시: ");
                String scode = scan.next();
                //Form
                //작은박스(form) -> 큰박스(forms)
                //반복문 -> 넣을 위치
                boolean result1 = false;
                for (int i=0; i<=controller.forms.length-1; i++){
                    if ( controller.forms[i] == null){
                        int fcode = i+1;
                        Form form = new Form(fcode,fname,fnumber,ffamily,fexp,freason,acode,pcode,scode);
                        controller.forms[i] = form;
                        result1 = true;
                        break;
                    }
                }
                if(result1){
                    System.out.println("(안내) 등록 성공!");
                }
                else
                    System.out.println("(안내) 등록 실패! (용량 초과)");
            }
            else if(선택 == 2){
                // 신청서 출력
                System.out.println("[신청서 출력]");
                for(Form forms: controller.forms){
                    if(forms != null){
                        String fexp2;
                        if(forms.fexp == true){
                            fexp2 = "있음";
                        }
                        else
                            fexp2 = "없음";
                        String acode2;
                        if(forms.acode == true){
                            acode2 = "동의";
                        }
                        else
                            acode2 = "미동의";
                        System.out.printf("\n코드: %d\n이름: %s\n전화번호: %s\n 가구원 수: %d\n반려동물 경험: %s\n이유: %s\n동의여부: %s\n입양할 동물: %d\n거주 시: %s",forms.fcode,forms.fname,forms.fnumber,forms.ffamily,fexp2,forms.freason,acode2,forms.pcode,forms.scode);
                    }
                }
            }
            else if(선택 == 3){
                System.out.println("[보호소 등록]");
                System.out.print("보호소 이름: ");
                String shname = scan.next();

                boolean result2 = false;
                for(int i = 0; i < controller.shelters.length; i++){
                    if(controller.shelters[i] == null){
                        int shcode = i+1;
                        Shelter shelter = new Shelter(shcode, shname);
                        controller.shelters[i] = shelter;
                        result2 = true;
                        break;
                    }
                }
                // 0    1     2  index+1 = shcode
                // 1.~~ 2.~~~ 3. null
                if(result2) {
                    System.out.println("(안내) 등록 성공!");
                } else {
                    System.out.println("(안내) 등록 실패! (용량 초과)");
                }
            }
            else if(선택 == 4){
                System.out.println("[보호소 출력]");
                boolean 확인2 = false;
                for(Shelter shelters: controller.shelters){
                    if(shelters != null){
                        System.out.printf("코드: %d  이름: %s\n", shelters.shcode, shelters.shname);
                        확인2 = true;
                    }
                }
                if(확인2 == false){
                    System.out.println("등록된 보호소가 없습니다.");
                }
            }
        }
    }
}

class OverallController { //controller
    //1.신청서 2.보호소
    Form[] forms = new Form[10];
    Shelter[] shelters = new Shelter[30];

}

//형식 지정
class Shelter {
    int shcode;
    String shname;
    
    public Shelter(int shcode, String shname) {
        this.shcode = shcode;
        this.shname = shname;
    }
}

class Form{
    int fcode;
    String fname;
    String fnumber;
    int ffamily;
    boolean fexp;
    String freason;
    boolean acode;
    int pcode;
    String scode;
    public Form(int fcode, String fname, String fnumber, int ffamily, boolean fexp, String freason, boolean acode,
            int pcode, String scode) {
        this.fcode = fcode;
        this.fname = fname;
        this.fnumber = fnumber;
        this.ffamily = ffamily;
        this.fexp = fexp;
        this.freason = freason;
        this.acode = acode;
        this.pcode = pcode;
        this.scode = scode;
    }
}