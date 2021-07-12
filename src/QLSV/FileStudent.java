package QLSV;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileStudent {
    public static void  writeToFile(String path, List<Student> students) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        String str= "id,name,dateOfBirth\n";
        for (Student st : students){
            str+=st.getId() + "," + st.getName() + "," + st.getDateOfBirth() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }
    public static List<Student> readFromFile(String path) throws IOException {
        List<Student> studentList = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
       String content= bufferedReader.readLine();
       while ((content =bufferedReader.readLine())!=null){
           String [] values = content.split(",");
           String [] date = values[2].split("-");
           studentList.add(new Student(values[0],values[1], LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]))));
//           System.out.println(content);
       }
       return studentList;
    }
}
