package Email_SMS;

public interface Notification {
    void send (String message);
    String getDeliveryStatus();
}
