package me.khai.factory;


import me.khai.notification.EmailNotification;
import me.khai.notification.Notification;
import me.khai.notification.PushNotification;
import me.khai.notification.SMSNotification;


public class NotificationFactory {

    public static Notification createNotification(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại thông báo không được để trống.");
        }

        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Loại thông báo không hợp lệ: " + type);
        }
    }
}

