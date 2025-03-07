/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nguyenhuuphucdocker;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList; // Nhập thư viện ArrayList
import java.util.List; // Nhập thư viện List
import java.util.Scanner; // Nhập thư viện Scanner

public class User {

    private String userId; // Khai báo thuộc tính id của người dùng
    private String email; // Khai báo thuộc tính email của người dùng

    // Constructor khởi tạo đối tượng User với userId và email
    public User(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    // Getter và setter cho các thuộc tính
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    // Phương thức hiển thị thông tin người dùng dưới dạng bảng
    @Override
    public String toString() {
        return String.format("| %-10s | %-20s |", userId, email);
    }

    private static List<User> users = new ArrayList<>(); // Tạo danh sách lưu trữ người dùng
    private static Scanner scanner = new Scanner(System.in); // Tạo đối tượng Scanner để nhập liệu

    public static void main(String[] args) {
        // Nhập số lượng người dùng cần thêm
        System.out.print("Nhap so luong nguoi dung can them: ");
        int numUsers = Integer.parseInt(scanner.nextLine()); // Nhập số lượng người dùng từ bàn phím

        // Nhập thông tin người dùng
        for (int i = 0; i < numUsers; i++) {
            System.out.println("Nhap thong tin nguoi dung thu " + (i + 1) + ":");
            System.out.print("ID: ");
            String userId = scanner.nextLine(); // Nhập ID của người dùng
            System.out.print("Email: ");
            String email = scanner.nextLine(); // Nhập email của người dùng

            users.add(new User(userId, email)); // Thêm người dùng vào danh sách
        }

        // Hiển thị thông tin người dùng dưới dạng bảng
        displayUsers();

        // Hiển thị menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Xoa nguoi dung");
            System.out.println("2. Sua nguoi dung");
            System.out.println("3. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine()); // Nhập lựa chọn của người dùng

            // Xử lý lựa chọn của người dùng
            switch (choice) {
                case 1:
                    deleteUser(); // Xóa người dùng
                    break;
                case 2:
                    updateUser(); // Sửa thông tin người dùng
                    break;
                case 3:
                    System.exit(0); // Thoát chương trình
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai."); // Thông báo lựa chọn không hợp lệ
            }

            displayUsers(); // Cập nhật bảng sau mỗi thao tác
        }
    }

    // Phương thức hiển thị bảng thông tin người dùng
    private static void displayUsers() {
        System.out.println("+------------+----------------------+");
        System.out.println("| ID         | Email                |");
        System.out.println("+------------+----------------------+");
        for (User user : users) {
            System.out.println(user); // Hiển thị thông tin từng người dùng
        }
        System.out.println("+------------+----------------------+");
    }

    // Phương thức xóa người dùng theo ID
    private static void deleteUser() {
        System.out.print("Nhap ID nguoi dung can xoa: ");
        String userId = scanner.nextLine(); // Nhập ID người dùng cần xóa
        users.removeIf(user -> user.getUserId().equals(userId)); // Xóa người dùng khỏi danh sách
        System.out.println("Nguoi dung da duoc xoa."); // Thông báo người dùng đã được xóa
    }

    // Phương thức cập nhật thông tin người dùng theo ID
    private static void updateUser() {
        System.out.print("Nhap ID nguoi dung can sua: ");
        String userId = scanner.nextLine(); // Nhập ID người dùng cần sửa
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                System.out.println("Chon thong tin can sua:");
                System.out.println("a. ID");
                System.out.println("b. Email");
                System.out.print("Lua chon cua ban: ");
                char option = scanner.nextLine().charAt(0); // Nhập lựa chọn của người dùng

                // Xử lý lựa chọn của người dùng
                switch (option) {
                    case 'a':
                        System.out.print("Nhap ID moi: ");
                        user.setUserId(scanner.nextLine()); // Cập nhật ID mới
                        break;
                    case 'b':
                        System.out.print("Nhap Email moi: ");
                        user.setEmail(scanner.nextLine()); // Cập nhật email mới
                        break;
                    default:
                        System.out.println("Lua chon khong hop le."); // Thông báo lựa chọn không hợp lệ
                }

                System.out.println("Thong tin nguoi dung da duoc cap nhat."); // Thông báo thông tin người dùng đã được cập nhật
                break;
            }
        }
    }
}
