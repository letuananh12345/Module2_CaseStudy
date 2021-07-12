package QLSV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManagerStudent {
    List<Student> studentList;


    public ManagerStudent() {
        this.studentList = new ArrayList<Student>();
//        this.studentList.add(new Student("1", "Quang", LocalDate.of(1994, 04, 11)));
//        this.studentList.add(new Student("2", "Dung", LocalDate.of(1998, 05, 16)));
//        this.studentList.add(new Student("3", "Hieu", LocalDate.of(1995, 06, 06)));
//        this.studentList.add(new Student("4", "Tien", LocalDate.of(1996, 07, 18)));
//        this.studentList.add(new Student("5", "Dung", LocalDate.of(1996, 04, 22)));
//        this.studentList.add(new Student("6", "Nam", LocalDate.of(2000, 01, 26)));
//        this.studentList.add(new Student("7", "Hai", LocalDate.of(2003, 03, 30)));
//        this.studentList.add(new Student("8", "Anh", LocalDate.of(2004, 03, 25)));
    }

    public List<Student> getStudents() {
        return studentList;

    }

    public void setStudentList(List<Student> students) {
        this.studentList = students;
    }

    public List<Student> getAll() {
        return this.studentList;
    }

    public void add(Student student) {
        this.studentList.add(student);
    }

    public boolean checkExistedId(String id) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public int findById(String id) {
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void delete(String id) {
        this.studentList.remove(findById(id));
    }

    public void edit(Student student) {
        this.studentList.set(findById(student.getId()), student);
    }

    public void sort() {
        Collections.sort(this.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                if (o1.getName().compareTo(o2.getName()) == 0)
//                    return o1.getAge() - o2.getAge();
//                return o1.getName().compareTo(o2.getName());
                if(o1.getAge() - o2.getAge()==0)
                    return o1.getName().compareTo(o2.getName());
                return o1.getAge() - o2.getAge();
            }
        });
        for (int i = 0; i < getAll().size(); i++) {
            InputOutput.outputStudent(this.studentList.get(i));
        }

    }
}


