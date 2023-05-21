public class OrderPlacedEvent {
    private String orderId;
    private String customerId;
    // ... other order details and getters/setters
}
public class OrderService {
    private EventPublisher eventPublisher;

    public void placeOrder(Order order) {
        // Process the order and save it to the database

        // Publish the event
        OrderPlacedEvent event = new OrderPlacedEvent(order.getId(), order.getCustomerId());
        eventPublisher.publish(event);
    }
}
public class EmailService implements EventSubscriber<OrderPlacedEvent> {

    @Override
    public void handleEvent(OrderPlacedEvent event) {
        // Retrieve order details from the event
        String orderId = event.getOrderId();
        String customerId = event.getCustomerId();

        // Send email notification to the customer
        String emailContent = "Thank you for your order with ID: " + orderId;
        sendEmail(customerId, "Order Confirmation", emailContent);
    }

    private void sendEmail(String customerId, String subject, String content) {
        // Logic to send email
    }
}
public interface EventPublisher {
    <T> void publish(T event);
}

public interface EventSubscriber<T> {
    void handleEvent(T event);
}

import java.util.ArrayList;
        import java.util.List;

// Subject (Observable)
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}
