package me.khai.notification;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("[SMS] Nội dung: " + message);
    }
}