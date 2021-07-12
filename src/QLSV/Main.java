package QLSV;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManagerStudent managerStudent = new ManagerStudent();
        ValidateStudent validateStudent = new ValidateStudent();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(".............!< Menu >!................");
            System.out.println("1.Thêm Sinh viên : ");
            System.out.println("2.Hiển Thị: ");
            System.out.println("3.Tìm Kiếm Thông Tin Sinh Viên: ");
            System.out.println("4.Xóa Thông Tin Sinh Viên Theo Id: ");
            System.out.println("5.Sửa Thông Tin Sinh Viên Theo Id: ");
            System.out.println("6.Sắp xếp sinh viên: ");
            System.out.println("7.Ghi vào File: ");
            System.out.println("8.Đọc Từ File: ");
            System.out.println("9.Thoát: ");
            int choice = -1;
            while (choice == -1) {
                try {
                    System.out.println("........!  Nhập lựa chọn : !.........: ");
                    choice = sc.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập vào số đi ! " + "Lỗi : " + ex.getMessage());
                } finally {
                    sc.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    System.out.println("Nhập Thông Tin Sinh Viên : ");
                    System.out.println("Nhập Vào id :");
                    String id = "";
                    do {
                       id = sc.nextLine();
                       if (validateStudent.valid(id,validateStudent.ID_REGEX)==false)
                           System.out.println("Sai Định Dạng- Nhập Lại ");
                    }while (!validateStudent.valid(id,validateStudent.ID_REGEX));
                    if (managerStudent.checkExistedId(id)) {
                        Student student = InputOutput.inputStudent();
                        student.setId(id);
                        managerStudent.add(student);
                    } else
                        System.out.println("id trùng");
                    break;
                case 2:
                   for (int i =0;i<managerStudent.getAll().size();i++){
                       InputOutput.outputStudent(managerStudent.getAll().get(i));
                   }
                    break;
                case 3:
                    System.out.println("Nhập id Cần Tìm: ");
                    String idFind = sc.nextLine();
                    int pos = managerStudent.findById(idFind);
                    if (managerStudent.findById(idFind) == -1)
                        System.out.println("Không có id cần tìm !");
                    else
                        InputOutput.outputStudent(managerStudent.getAll().get(pos));
                    break;
                case 4:
                    System.out.println("Nhập id Cần Xóa: ");
                    String idDelete = sc.nextLine();
                    boolean isNotExitsted = managerStudent.checkExistedId(idDelete);
                    if (isNotExitsted) {
                        System.out.println("Không Có id Cần Xóa ! ");
                    } else {
                        System.out.println("Bạn Có Muốn Xóa Không ? < Nhập \"yes\" Để Đồng ý ! > ");
                        String acc = sc.nextLine();
                        if (acc.equals("yes")) {
                            managerStudent.delete(idDelete);
                            System.out.println("Xóa thành công");
                        }

                    }
                    break;
                case 5:
                    System.out.println("Nhập id Cần Sửa: ");
                    String idEdit = sc.nextLine();
                    isNotExitsted = managerStudent.checkExistedId(idEdit);
                    if (isNotExitsted) {
                        System.out.println("Không Có id Cần Sửa ! ");
                    } else {
                        Student student = InputOutput.inputStudent();
                        student.setId(idEdit);
                        managerStudent.edit(student);
                    }
                    break;
                case 6:
                    managerStudent.sort();
                    break;
                case 7:
                    FileStudent.writeToFile("file.csv", managerStudent.getStudents());
                    break;
                case 8:
                    managerStudent.setStudentList(FileStudent.readFromFile("file.csv"));
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có giá trị cần tìm ");
            }

        }
    }
}
