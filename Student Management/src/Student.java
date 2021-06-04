 import java.text.DecimalFormat;
    public class Student {
    //학생 정보입니다
    private final String name;    
    private final String num;      
    private double math;   
    private double English;  
    private double web;      
    private double sum;     
    private double average;  
    private final DecimalFormat format;   //디지털 포맷 클래스입니다.
    public Student(String name, String num, double math, double english, double web) {
        this.name = name;
        this.num = num;
        this.math = math;
        this.English = english;
        this.web = web;
        this.sum = (math+english+web);
        format = new DecimalFormat("####");  //숫자 형식을 정의했습니다
        this.average = Double.parseDouble(format.format(this.sum/3));
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", math=" + math +
                ", English=" + English +
                ", web=" + web +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
    //get방법
    public String getName() {
        return name;
    }
    public String getNum() {
        return num;
    }
    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return English;
    }

    public double getWeb() {
        return web;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }
    //set방법
    public void setMath(double math) {
        this.math = math;
    }

    public void setEnglish(double english) {
        English = english;
    }

    public void setWeb(double web) {
        this.web = web;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setAverage(double average) {
        this.average = Double.parseDouble(format.format(average));
    }
    }
