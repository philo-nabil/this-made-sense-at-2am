package Email_SMS;

public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }

    @Override
    public String getDeliveryStatus() {

        return "Email delivered successfully";
    }

}
