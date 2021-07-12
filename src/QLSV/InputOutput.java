package QLSV;

import java.time.LocalDate;
import java.util.Scanner;

public class InputOutput {
   public static Student inputStudent(){
       Scanner sc=new Scanner(System.in);
       Student student = new Student();
       ValidateStudent validateStudent = new ValidateStudent();
//       System.out.println("Nhập Thông Tin Sinh Viên: ");
       System.out.println("Nhập tên: ");
       String name ="";
       do {
           name = sc.nextLine();
           if (!validateStudent.valid(name,validateStudent.NAME_REGEX));
           System.out.println("Sai Định Dạng - nhập lại");
       }while (!validateStudent.valid(name,validateStudent.NAME_REGEX));
       student.setName(name);
       System.out.println("Nhập ngày sinh: ");
       int day = sc.nextInt();
       System.out.println("Nhập tháng sinh: ");
       int month = sc.nextInt();
       System.out.println("Nhập năm sinh: ");
       int year = sc.nextInt();
       student.setDateOfBirth(LocalDate.of(year,month,day));
       return student;
   }
   public static void outputStudent(Student student){
       System.out.println("Tên : " + student.getName() + ", Tuổi: " + student.getAge());
   }

}
