package me.khai;
import me.khai.config.AppConfig;
import me.khai.factory.NotificationFactory;
import me.khai.notification.Notification;

import java.util.Scanner;



public class Main {

    public static void showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Gửi Email");
        System.out.println("2. Gửi SMS");
        System.out.println("3. Gửi Push Notification");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Singleton
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("===== THÔNG TIN HỆ THỐNG =====");
        System.out.println("Tên ứng dụng: " + config1.getAppName());
        System.out.println("Phiên bản: " + config1.getVersion());
        System.out.println("Kiểm tra Singleton:");
        System.out.println("config1 == config2 ? " + (config1 == config2));

        int choice;

        do {
            showMenu();

            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 0) {
                System.out.println("Thoát chương trình.");
                break;
            }

            String type = "";
            switch (choice) {
                case 1:
                    type = "email";
                    break;
                case 2:
                    type = "sms";
                    break;
                case 3:
                    type = "push";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    continue;
            }

            System.out.print("Nhập nội dung thông báo: ");
            String message = scanner.nextLine();

            try {
                // Factory Method
                Notification notification = NotificationFactory.createNotification(type);
                notification.send(message);
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }

        } while (true);

        scanner.close();
    }
}