package day0805;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        OverallController controller = new OverallController();
        Scanner scan = new Scanner(System.in);
        for(;;){
            System.out.println("[게시판]");
            System.out.println("1.쓰기  2.보기");
            System.out.print("선택: ");
            int ch = scan.nextInt();

            if(ch == 1){
                System.out.println("게시물 작성: ");
                String content = scan.next();
                System.out.print("\n작성자: ");
                String writer = scan.next();
                Post post = new Post(content,writer);

                boolean result = false;

                for(int i = 0; i <= controller.posts.length-1; i++){
                    if(controller.posts[i] == null){
                        controller.posts[i] = post;
                        result = true;
                        break;
                    }
                }

                if (result == true)
                    System.out.println("(안내) 쓰기 성공!");
                else
                    System.out.println("(안내) 쓰기 실패!");
            }
            else{
                for(Post post: controller.posts){
                    if(post != null){
                        System.out.printf("게시물: %s\n작성자: %s",post.content,post.writer);
                    }
                }
            }
        }
    }
}
