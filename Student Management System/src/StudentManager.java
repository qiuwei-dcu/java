import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	      1. 用输出语句完成主界面的编写
	      2. 用Scanner实现键盘录入数据
	      3. 用switch语句完成操作的选择
	      4. 用循环完成再次回到主界面
	    */

	  
	        //创建集合对象，用于存储学生数据
	        ArrayList<Student> array = new ArrayList<Student>();

	        //用循环完成再次回到主界面
	        while (true) {
	            // 1. 用输出语句完成主界面的编写
	            System.out.println("---------欢迎来到学生管理系统------------");
	            System.out.println("1 添加学生");
	            System.out.println("2 删除学生");
	            System.out.println("3 修改学生");
	            System.out.println("4 查看所有学生");
	            System.out.println("5 退出");
	            System.out.println("-------------------------------------");

	            // 2. 用Scanner实现键盘录入数据
	            Scanner scanner = new Scanner(System.in);
	            int line = scanner.nextInt();


	            //3. 用switch语句完成操作的选择
	            switch (line) {
	                case 1:
	                    //System.out.println("添加学生");
	                    addStudent(array);
	                    break;
	                case 2:
	                    //System.out.println("删除学生");
	                    deleteStudent(array);
	                    break;
	                case 3:
	                    //System.out.println("修改学生");
	                    updataStudent(array);
	                    break;
	                case 4:
	                    //System.out.println("查看所有学生");
	                    findAllStudent(array);
	                    break;
	                case 5:
	                    System.out.println("谢谢使用");
	                    System.exit(0);
	            }
	        }
	    }


	    //定义一个方法，用于添加学生信息
	    public static void addStudent(ArrayList<Student> array) {

	        //用键盘录入选择添加学生,显示提示信息，提示要输入何种信息
	        Scanner sc = new Scanner(System.in);

	        //为了让sid在while循环外面能被访问到，我们就把它定义在了循环外
	        String sid;

	        //为了让程序能够回到这里，我们使用循环使用
	        while (true) {
	            System.out.println("请输入学生学号：");
	            sid = sc.nextLine();

	            boolean flag = isUsed(array, sid);
	            if (flag) {
	                System.out.println("你输入的学号已经被使用，请重新输入");
	            } else {
	                break;
	            }
	        }

	        System.out.println("请输入学生姓名：");
	        String name = sc.nextLine();
	        System.out.println("请输入学生年龄：");
	        String age = sc.nextLine();
	        System.out.println("请输入学生居住地：");
	        String address = sc.nextLine();

	        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
	        Student s = new Student();
	        s.setSid(sid);
	        s.setName(name);
	        s.setAge(age);
	        s.setAddress(address);

	        //将学生对象添加到集合中（保存）
	        array.add(s);

	        //给出添加成功提示
	        System.out.println("添加学生成功");

	    }

	    //定义一个方法，判断学号是否被占用
	    public static boolean isUsed(ArrayList<Student> array, String sid) {
	        //如果与集合中的某一个学生学号相同，返回true  如果都不相同，返回false

	        boolean flag = false;

	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getSid().equals(sid)) {
	                flag = true;
	                break;
	            }
	        }
	        return flag;
	    }


	    //定义一个方法，用于查看学生信息
	    public static void findAllStudent(ArrayList<Student> array) {
	        //显示表头信息
	        //   '\t'  其实就是tab键的位置
	        
	        if (array.size() == 0) {
	            System.out.println("无信息，请先添加信息再查询");
	            //为了不让程序继续往下执行
	            return;
	        }

	        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");

	        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充”岁“
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "岁\t\t" + s.getAddress());
	        }
	    }

	    //定义一个方法，用于删除学生信息
	    public static void deleteStudent(ArrayList<Student> array) {

	        // 键盘录入要删除的学生学号,显示提示信息

	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入要删除的学生的学号");
	        String sid = sc.nextLine();

	        //在删除/修改学生操作前，对学号是否存在进行判断
	        //如果不存在，显示提示信息
	        //如果存在，执行删除/修改操作
	        int index = -1;

	        // 遍历集合将对应学生对象从集合中删除
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getSid().equals(sid)) {
	                index = i;
	                break;
	            }
	        }

	        if (index == -1) {
	            System.out.println("该学号不存在，请重新输入");
	        } else {
	            array.remove(index);
	            System.out.println("删除学生成功");
	        }
	    }

	    //定义一个方法，用于修改学生信息
	    public static void updataStudent(ArrayList<Student> array) {
	        // 键盘录入要修改的学生学号，显示提示信息

	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入要修改的学生的学号");
	        String sid = sc.nextLine();

	        //在删除/修改学生操作前，对学号是否存在进行判断
	        //如果不存在，显示提示信息
	        //如果存在，执行删除/修改操作
	        int index = -1;


	        // 遍历集合修改对应的学生信息
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getSid().equals(sid)) {
	                index = i;
	                break;
	            }
	        }


	        if (index == -1) {
	            System.out.println("该学号不存在，请重新输入");
	        } else {
	            for (int j = 0; j < array.size(); j++) {
	                Student student = array.get(j);
	                if (student.getSid().equals(sid)) {

	                    // 键盘录入要修改的学生信息
	                    System.out.println("请输入学生的新姓名");
	                    String name = sc.nextLine();
	                    System.out.println("请输入学生的新年龄");
	                    String age = sc.nextLine();
	                    System.out.println("请输入学生的新居住地");
	                    String address = sc.nextLine();

	                    // 创建学生对象
	                    Student s = new Student();
	                    s.setSid(sid);
	                    s.setName(name);
	                    s.setAge(age);
	                    s.setAddress(address);
	                    array.set(j, s);

	                    // 给出修改成功提示
	                    System.out.println("修改学生成功");
	                    break;
	                }
	            }
	        }
	   

	}

}
