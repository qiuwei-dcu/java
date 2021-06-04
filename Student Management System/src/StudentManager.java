import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	      1. �����������������ı�д
	      2. ��Scannerʵ�ּ���¼������
	      3. ��switch�����ɲ�����ѡ��
	      4. ��ѭ������ٴλص�������
	    */

	  
	        //�������϶������ڴ洢ѧ������
	        ArrayList<Student> array = new ArrayList<Student>();

	        //��ѭ������ٴλص�������
	        while (true) {
	            // 1. �����������������ı�д
	            System.out.println("---------��ӭ����ѧ������ϵͳ------------");
	            System.out.println("1 ���ѧ��");
	            System.out.println("2 ɾ��ѧ��");
	            System.out.println("3 �޸�ѧ��");
	            System.out.println("4 �鿴����ѧ��");
	            System.out.println("5 �˳�");
	            System.out.println("-------------------------------------");

	            // 2. ��Scannerʵ�ּ���¼������
	            Scanner scanner = new Scanner(System.in);
	            int line = scanner.nextInt();


	            //3. ��switch�����ɲ�����ѡ��
	            switch (line) {
	                case 1:
	                    //System.out.println("���ѧ��");
	                    addStudent(array);
	                    break;
	                case 2:
	                    //System.out.println("ɾ��ѧ��");
	                    deleteStudent(array);
	                    break;
	                case 3:
	                    //System.out.println("�޸�ѧ��");
	                    updataStudent(array);
	                    break;
	                case 4:
	                    //System.out.println("�鿴����ѧ��");
	                    findAllStudent(array);
	                    break;
	                case 5:
	                    System.out.println("ллʹ��");
	                    System.exit(0);
	            }
	        }
	    }


	    //����һ���������������ѧ����Ϣ
	    public static void addStudent(ArrayList<Student> array) {

	        //�ü���¼��ѡ�����ѧ��,��ʾ��ʾ��Ϣ����ʾҪ���������Ϣ
	        Scanner sc = new Scanner(System.in);

	        //Ϊ����sid��whileѭ�������ܱ����ʵ������ǾͰ�����������ѭ����
	        String sid;

	        //Ϊ���ó����ܹ��ص��������ʹ��ѭ��ʹ��
	        while (true) {
	            System.out.println("������ѧ��ѧ�ţ�");
	            sid = sc.nextLine();

	            boolean flag = isUsed(array, sid);
	            if (flag) {
	                System.out.println("�������ѧ���Ѿ���ʹ�ã�����������");
	            } else {
	                break;
	            }
	        }

	        System.out.println("������ѧ��������");
	        String name = sc.nextLine();
	        System.out.println("������ѧ�����䣺");
	        String age = sc.nextLine();
	        System.out.println("������ѧ����ס�أ�");
	        String address = sc.nextLine();

	        //����ѧ�����󣬰Ѽ���¼������ݸ�ֵ��ѧ������ĳ�Ա����
	        Student s = new Student();
	        s.setSid(sid);
	        s.setName(name);
	        s.setAge(age);
	        s.setAddress(address);

	        //��ѧ��������ӵ������У����棩
	        array.add(s);

	        //������ӳɹ���ʾ
	        System.out.println("���ѧ���ɹ�");

	    }

	    //����һ���������ж�ѧ���Ƿ�ռ��
	    public static boolean isUsed(ArrayList<Student> array, String sid) {
	        //����뼯���е�ĳһ��ѧ��ѧ����ͬ������true  ���������ͬ������false

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


	    //����һ�����������ڲ鿴ѧ����Ϣ
	    public static void findAllStudent(ArrayList<Student> array) {
	        //��ʾ��ͷ��Ϣ
	        //   '\t'  ��ʵ����tab����λ��
	        
	        if (array.size() == 0) {
	            System.out.println("����Ϣ�����������Ϣ�ٲ�ѯ");
	            //Ϊ�˲��ó����������ִ��
	            return;
	        }

	        System.out.println("ѧ��\t\t\t����\t\t����\t\t��ס��");

	        //������������ȡ�����ն�Ӧ��ʽ��ʾѧ����Ϣ��������ʾ���䡱�ꡰ
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "��\t\t" + s.getAddress());
	        }
	    }

	    //����һ������������ɾ��ѧ����Ϣ
	    public static void deleteStudent(ArrayList<Student> array) {

	        // ����¼��Ҫɾ����ѧ��ѧ��,��ʾ��ʾ��Ϣ

	        Scanner sc = new Scanner(System.in);
	        System.out.println("������Ҫɾ����ѧ����ѧ��");
	        String sid = sc.nextLine();

	        //��ɾ��/�޸�ѧ������ǰ����ѧ���Ƿ���ڽ����ж�
	        //��������ڣ���ʾ��ʾ��Ϣ
	        //������ڣ�ִ��ɾ��/�޸Ĳ���
	        int index = -1;

	        // �������Ͻ���Ӧѧ������Ӽ�����ɾ��
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getSid().equals(sid)) {
	                index = i;
	                break;
	            }
	        }

	        if (index == -1) {
	            System.out.println("��ѧ�Ų����ڣ�����������");
	        } else {
	            array.remove(index);
	            System.out.println("ɾ��ѧ���ɹ�");
	        }
	    }

	    //����һ�������������޸�ѧ����Ϣ
	    public static void updataStudent(ArrayList<Student> array) {
	        // ����¼��Ҫ�޸ĵ�ѧ��ѧ�ţ���ʾ��ʾ��Ϣ

	        Scanner sc = new Scanner(System.in);
	        System.out.println("������Ҫ�޸ĵ�ѧ����ѧ��");
	        String sid = sc.nextLine();

	        //��ɾ��/�޸�ѧ������ǰ����ѧ���Ƿ���ڽ����ж�
	        //��������ڣ���ʾ��ʾ��Ϣ
	        //������ڣ�ִ��ɾ��/�޸Ĳ���
	        int index = -1;


	        // ���������޸Ķ�Ӧ��ѧ����Ϣ
	        for (int i = 0; i < array.size(); i++) {
	            Student s = array.get(i);
	            if (s.getSid().equals(sid)) {
	                index = i;
	                break;
	            }
	        }


	        if (index == -1) {
	            System.out.println("��ѧ�Ų����ڣ�����������");
	        } else {
	            for (int j = 0; j < array.size(); j++) {
	                Student student = array.get(j);
	                if (student.getSid().equals(sid)) {

	                    // ����¼��Ҫ�޸ĵ�ѧ����Ϣ
	                    System.out.println("������ѧ����������");
	                    String name = sc.nextLine();
	                    System.out.println("������ѧ����������");
	                    String age = sc.nextLine();
	                    System.out.println("������ѧ�����¾�ס��");
	                    String address = sc.nextLine();

	                    // ����ѧ������
	                    Student s = new Student();
	                    s.setSid(sid);
	                    s.setName(name);
	                    s.setAge(age);
	                    s.setAddress(address);
	                    array.set(j, s);

	                    // �����޸ĳɹ���ʾ
	                    System.out.println("�޸�ѧ���ɹ�");
	                    break;
	                }
	            }
	        }
	   

	}

}
