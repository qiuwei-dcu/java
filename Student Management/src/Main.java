import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Extrance.UI();   //메뉴를 조작합니다
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);   //데이터를 읽어 옵니다
        while (true) {
            Extrance.start(in.nextInt());   ///옵션 처리 함수입니다
        }
    }
}
