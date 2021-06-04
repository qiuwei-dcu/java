
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class InformationIO {
    private static LinkedList<Student> message = null;   //학생 정보를 저장합니다
    public InformationIO() {
        if (message == null) {
            message = new LinkedList<>();
            try {//파일 원본 내용을 읽어 들어갑니다.
                File file = new File("message.txt");
                if (file.exists()) {     //파일이 존재할 때 데이터를 읽습니다
                    BufferedReader buff = new BufferedReader(new FileReader("message.txt"));//파일을 엽니다
                    String row;
                    while ((row = buff.readLine()) != null) {
                        String[] str = row.split(";");
                        message.add(new Student(str[0], str[1], Double.parseDouble(str[2]), Double.parseDouble(str[3]), Double.parseDouble(str[4])));
                    }
                    buff.close(); //캐시 스트림이 닫힙니다
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //학생 정보를 추가합니다
    public static boolean addMessage(String name, String num, double math, double english, double web) {
        for (Student stud : message) {                       //학번 중복 방지합니다
            if (stud.getNum().equalsIgnoreCase(num)) {
                return false;
            }
        }
        message.add(new Student(name, num, math, english, web));
        return true;
    }
    //모든 학생 성적을 확인하세요
    public static void printMessage() {
        for (Student temp : message) {
            System.out.print("이름：" + temp.getName() + "  학번：" + temp.getNum() + "  고수：" + temp.getMath()
                    + "  대학영어：" + temp.getEnglish() + "  웹디자인：" + temp.getWeb() + "   합계：" + temp.getSum()
                    + "  평균성적" + temp.getAverage() + '\n');
        }
    }
    //List의 길이를 되돌려줍니다
    public static int returnSize() {
        return message.size();
    }
    //학생 성적을 삭제합니다
    public static boolean delMessage(String key) {
        int i = 0;
        int size = message.size();
        for (; i < size; ++i) {
            if (message.get(i).getNum().equalsIgnoreCase(key)) {           //지정한 데이터를 삭제하고 검색을 종료합니다.
                message.remove(i);
                break;
            }
        }
        return i != size;
    }
    //학생 성적을 수정합니다
    public static boolean setMessage(String num, double math, double English, double web) {
        for (Student student : message) {
            if (student.getNum().equalsIgnoreCase(num)) {   //기존 정보와 비교합니다
                student.setMath(math);
                student.setEnglish(English);
                student.setWeb(web);
                student.setSum(math + English + web);
                student.setAverage(student.getSum() / 3);
                return true;
            }
        }
        return false;     //정보가 존재하지 않습니다
    }
    //기존 학생 정보를 업그레이드하여 정렬합니다
    public static void shortMessage_Min(int choose) {
        switch (choose) {
            case 1: {
                sort_Max_1(message, 1);
            }
            break;
            case 2: {
                sort_Max_1(message, 2);
            }
            break;
            case 3: {
                sort_Max_1(message, 3);
            }
            break;
            case 4: {
                sort_Max_1(message, 4);
            }
            break;
            case 5: {
                sort_Max_1(message, 5);
            }
            break;
            case 6: {
                sort_Max_1(message, 6);
            }
            break;
        }
    }
    //존재하는 학생 정보를 줄여서 정렬합니다
    public static void shortMessage_Max(int choose) {
        switch (choose) {
            case 1: {
                sort_Min_1(message,1);
            }
            break;
            case 2: {
                sort_Min_1(message,2);
            }
            break;
            case 3: {
                sort_Min_1(message,3);
            }
            break;
            case 4: {
                sort_Min_1(message,4);
            }
            break;
            case 5: {
                sort_Min_1(message,5);
            }
            break;
            case 6: {
                sort_Min_1(message,6);
            }
            break;
        }
    }
    //성적이 불합격한 학생 정보를 내보냅니다
    public static void printDmessage(String key) {
        boolean flag = false;
        switch (key) {
            case "math": {
                for (Student stud : message) {
                    if (stud.getMath() < 60) {
                        System.out.print("이름：" + stud.getName() + "  학번：" + stud.getNum() + "  고수：" + stud.getMath()
                                + "  대학영어：" + stud.getEnglish() + "  웹디자인：" + stud.getWeb() + "   합계：" + stud.getSum()
                                + "  평균성적" + stud.getAverage() + '\n');
                    }
                    flag = true;
                }
                if (!flag) {
                    System.out.println("그 학과에는 낙제자가 없습니다!");
                }
            }
            break;
            case "English": {
                for (Student stud : message) {
                    if (stud.getEnglish() < 60) {
                        System.out.print("이름：" + stud.getName() + "  학번：" + stud.getNum() + "  고수：" + stud.getMath()
                        + "  대학영어：" + stud.getEnglish() + "  웹디자인：" + stud.getWeb() + "   합계：" + stud.getSum()
                        + "  평균성적" + stud.getAverage() + '\n');
            }
            flag = true;
        }
        if (!flag) {
            System.out.println("그 학과에는 낙제자가 없습니다!");
        }
    }
    break;
            case "web": {
                for (Student stud : message) {
                    if (stud.getWeb() < 60) {
                        System.out.print("이름：" + stud.getName() + "  학번：" + stud.getNum() + "  고수：" + stud.getMath()
                        + "  대학영어：" + stud.getEnglish() + "  웹디자인：" + stud.getWeb() + "   합계：" + stud.getSum()
                        + "  평균성적" + stud.getAverage() + '\n');
            }
            flag = true;
        }
        if (!flag) {
            System.out.println("그 학과에는 낙제자가 없습니다!");
        }
    }
    break;
            case "sum": {
                for (Student stud : message) {
                    if (stud.getSum() < 60) {
                        System.out.print("이름：" + stud.getName() + "  학번：" + stud.getNum() + "  고수：" + stud.getMath()
                        + "  대학영어：" + stud.getEnglish() + "  웹디자인：" + stud.getWeb() + "   합계：" + stud.getSum()
                        + "  평균성적" + stud.getAverage() + '\n');
            }
            flag = true;
        }
        if (!flag) {
            System.out.println("그 학과에는 낙제자가 없습니다!");
        }
    }
    break;
            case "average": {
                for (Student stud : message) {
                    if (stud.getAverage() < 60) {
                        System.out.print("이름：" + stud.getName() + "  학번：" + stud.getNum() + "  고수：" + stud.getMath()
                        + "  대학영어：" + stud.getEnglish() + "  웹디자인：" + stud.getWeb() + "   합계：" + stud.getSum()
                        + "  평균성적" + stud.getAverage() + '\n');
            }
            flag = true;
        }
        if (!flag) {
            System.out.println("그 학과에는 낙제자가 없습니다!");
        }
    }
    break;
            default:
                System.out.println("입력 정보가 잘못되었습니다!");
        }
    }
    //파일 내용을 기록하고 있다.
    public static void writeFile() {
        File file = new File("message.txt");
        String row;
        try {
            if (!file.exists()) {  //파일이 존재하지 않을 때 파일을 만듭니다
                file.createNewFile();
            }
            BufferedWriter write = new BufferedWriter(new FileWriter("message.txt"));
            for (Student std : message) {
                row = std.getName() + ";" + std.getNum() + ";" + std.getMath() + ";" + std.getEnglish() + ";"
                        + std.getWeb() + ";" + std.getSum() + ";" + std.getAverage();
                write.write(row);
                write.newLine();
            }
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //비교된 데이터를 되돌려줍니다 (데이터 할당)
    private static double renumber(LinkedList<Student> info, int index, int number) {//인자: 체인시트를 조작합니다. 요소 표시, 데이터에 대응합니다.
        switch (number) {
            case 1: {
                return Double.parseDouble(info.get(index).getNum());
            }
            case 2: {
                return info.get(index).getMath();
            }
            case 3: {
                return info.get(index).getEnglish();
            }
            case 4: {
                return info.get(index).getWeb();
            }
            case 5: {
                return info.get(index).getSum();
            }
            case 6: {
                return info.get(index).getAverage();
            }
        }
        return -1;
    }
    //사용자 정의 정렬 함수입니다. (정렬을 선택하십시오)
    private static void sort_Max_1(LinkedList<Student> info, int number) {
        Student stud_max;   //중간 변수입니다
        Student temp;
        int index_max;
        int size = info.size();
        for (int i = size - 1; i > 0; i--) {
            stud_max = info.get(0);
            index_max = 0;
            for (int j = 1; j <= i; j++) {
                if (renumber(info, j, number) > renumber(info, index_max, number)) {
                    stud_max = info.get(j);
                    index_max = j;
                }
            }
            temp = info.get(i);
            info.set(i, stud_max);
            info.set(index_max, temp);
        }
    }
    private static void sort_Min_1(LinkedList<Student> info, int number) {
        Student stud_min;   //중간 변수입니다
        Student temp;
        int index_min;
        int size = info.size();
        for (int i = size - 1; i > 0; i--) {
            stud_min = info.get(0);
            index_min = 0;
            for (int j = 1; j <= i; j++) {
                if (renumber(info, j, number) < renumber(info, index_min, number)) {
                    stud_min = info.get(j);
                    index_min = j;
                }
            }
            temp = info.get(i);
            info.set(i, stud_min);
            info.set(index_min, temp);
        }
    }

}
