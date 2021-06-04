

import java.util.Scanner;

public final class Extrance {
    private Extrance(){}
    public static void UI(){
        System.out.println("*********************       학생 성적 관리 시스템입니다       **************************");
        System.out.println("***  1.학생 성적을 입력하시오      2.전체 학생 성적입니다          3.학생 성적을 삭제합니다    ***");
        System.out.println("***  4.학생 성적을 수정합니다  5.불합격 학생 정보를 확인합니다 6.학생 성적을 증서하여 줄을 서시오   ***");
        System.out.println("***  7.학생 성적을 하향 조정하여 순위를 매깁니다                 0.프로그램을 종료합니다.      ***");
        System.out.println("************************************************************");
    }
    public static void UI_back(){
        System.out.println("************************************************************");
        System.out.println("***           이 시스템을 사용해 주셔서 감사합니다!               ***");
        System.out.println("************************************************************");
    }
    public static void start(int key) {
        new InformationIO();
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        switch (key) {
            case 0:{//시스템을 종료하고 정보를 파일에 기록합니다.
                InformationIO.writeFile();
                Extrance.UI_back();
                System.exit(0);
            }break;
            case 1: {
                while(true) {
                    System.out.println("성명, 학번, 고수, 대학 영어, 웹 디자인 성적을 차례로 입력하고, 차를 돌려 확인하세요： ");
                    if(InformationIO.addMessage(in.next(),in.next(),in.nextInt(),in.nextInt(),in.nextInt())){
                        System.out.println("저장하는 데 성공했습니다！");
                    }else{
                        System.out.println("학번이 이미 존재합니다！");
                    }
                    System.out.println("계속 추가할 지 여부입니다.<Y/N>");
                    String str = in.next();
                    if(str.equalsIgnoreCase("N")){
                        System.out.println("입력이 끝났습니다");
                        break;
                    }else if(str.equalsIgnoreCase("Y")){
                        continue;
                    }else{
                        System.out.println("명령이 잘못되었습니다. 기본값은 계속 입력하십시오!");
                    }
                }
            }break;
            case 2: {//전체 학생 성적을 조회하시오
                if(InformationIO.returnSize() != 0){
                    InformationIO.printMessage();
                }else{
                    System.out.println("현재 성적이 없습니다！");
                }
            }break;
            case 3: {//학생 성적을 삭제합니다
                System.out.print("삭제학생의 학번을 입력하세요：");
                if(InformationIO.delMessage(in.nextLine())){
                    System.out.println("삭제에 성공했습니다！");
                }else{
                    System.out.println("학번이 존재하지 않거나 입력 오류입니다!");
                }
            }break;
            case 4:{//학생 성적을 수정합니다
                System.out.println("수정할 학생의 학번 및 성적(고수, 대학 영어, web 디자인)을 지번으로 구분하여 입력해주세요");
                String str[] = in.nextLine().split(";");
               if(InformationIO.setMessage(str[0],Double.parseDouble(str[1]),Double.parseDouble(str[2]),Double.parseDouble(str[3]))){
                   System.out.println("수정되었습니다！");
               }else{
                   System.out.println("학번이 존재하지 않습니다");
               }
            }break;
            case 5:{//불합격 학생 정보를 확인합니다
                System.out.print("조회할 학과를 입력하세요（math、English、web、sum、average）: ");
                InformationIO.printDmessage(in.nextLine());
            }break;
            case 6:{//학생 정보를 올려 정렬하시오
                System.out.print("대응 옵션을 입력해 주세요(1.num、2.math、3.English、4.web、5.sum、6.average): ");
                try{
                InformationIO.shortMessage_Min(in.nextInt());
                }catch(Exception e){
                    System.out.println("입력 형식이 잘못되었습니다！");
                }
            }break;
            case 7:{//학생 정보를 줄여서 정렬합니다
                System.out.print("키워드를 입력해 주세요(1.num、2.math、3.English、4.web、5.sum、6.average): ");
                try{
                   InformationIO.shortMessage_Max(in.nextInt());
                 }catch(Exception e){
                    System.out.println("입력 형식이 잘못되었습니다！");
                }
            }break;
            default:
                System.out.println("옵션이 틀렸습니다. 올바른 옵션을 입력해 주세요！");
        }
    }
}

