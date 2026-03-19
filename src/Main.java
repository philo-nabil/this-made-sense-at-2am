import Email_SMS.EmailNotification;
import Email_SMS.Notification;
import Email_SMS.SmsNotification;

void main()
{
    List<Notification> notifications = new ArrayList<>();
    notifications.add(new EmailNotification());
    notifications.add(new SmsNotification());

    for (Notification n : notifications) {
        n.send("Message ");
        System.out.println(n.getDeliveryStatus());

    }

}
