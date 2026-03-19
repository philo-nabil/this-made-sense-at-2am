package InterfaceExample;

public class SmsNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);

    }

    @Override
    public String getDeliveryStatus() {
        return "SMS delivered successfully";
    }

}
