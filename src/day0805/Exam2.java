package day0805;

import java.util.Scanner; // Scanner import 필요

public class Exam2 {

    public static void main(String[] args) {
        OverallController controller = new OverallController();
        Scanner scan = new Scanner(System.in);

        for (;;) { //조건문 생략. 무한반복문
            System.out.println("============ My Community ============ ");
            System.out.println("1.게시물쓰기 2.게시물출력");
            System.out.println("====================================== ");
            System.out.print("선택>");
            int ch = scan.nextInt();

            if (ch == 1) {
                scan.nextLine();
                System.out.print("내용 : ");
                String content = scan.nextLine();
                System.out.print("작성자 : ");
                String writer = scan.nextLine();

                Post post = new Post(content, writer);
                boolean result = false;
                
                for (int index = 0; index <= controller.posts.length - 1; index++) {
                    if (controller.posts[index] == null) {
                        controller.posts[index] = post;
                        result = true;
                        break;
                    }
                }

                if (result) {
                    System.out.println("[안내] 글쓰기 성공");
                } else {
                    System.out.println("[안내] 글쓰기 실패");
                }

            } else if (ch == 2) {
                for (Post post : controller.posts) {
                    if (post != null) {
                        System.out.printf("작성자 : %s , 내용 : %s \n", post.writer, post.content);
                    }
                }
            }
        }
    }
}

// 같은 파일 내에 위치하므로 public 키워드 제거
class OverallController {
    Post[] posts = new Post[100];
}

// 같은 파일 내에 위치하므로 public 키워드 제거
class Post {
    String content;
    String writer;

    public Post() {}

    public Post(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
}