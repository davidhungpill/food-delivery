package fooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPicked'"
    )
    public void wheneverOrderPicked_OrderStateChange(
        @Payload OrderPicked orderPicked
    ) {
        OrderPicked event = orderPicked;
        System.out.println(
            "\n\n##### listener OrderStateChange : " + orderPicked + "\n\n"
        );

        // Sample Logic //
        Order.orderStateChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_OrderStateChange(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener OrderStateChange : " +
            deliveryCompleted +
            "\n\n"
        );

        // Sample Logic //
        Order.orderStateChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderConfimed'"
    )
    public void wheneverOrderConfimed_OrderStateChange(
        @Payload OrderConfimed orderConfimed
    ) {
        OrderConfimed event = orderConfimed;
        System.out.println(
            "\n\n##### listener OrderStateChange : " + orderConfimed + "\n\n"
        );

        // Sample Logic //
        Order.orderStateChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderRejected'"
    )
    public void wheneverOrderRejected_OrderStateChange(
        @Payload OrderRejected orderRejected
    ) {
        OrderRejected event = orderRejected;
        System.out.println(
            "\n\n##### listener OrderStateChange : " + orderRejected + "\n\n"
        );

        // Sample Logic //
        Order.orderStateChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingStarted'"
    )
    public void wheneverCookingStarted_OrderStateChange(
        @Payload CookingStarted cookingStarted
    ) {
        CookingStarted event = cookingStarted;
        System.out.println(
            "\n\n##### listener OrderStateChange : " + cookingStarted + "\n\n"
        );

        // Sample Logic //
        Order.orderStateChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingFinished'"
    )
    public void wheneverCookingFinished_OrderStateChange(
        @Payload CookingFinished cookingFinished
    ) {
        CookingFinished event = cookingFinished;
        System.out.println(
            "\n\n##### listener OrderStateChange : " + cookingFinished + "\n\n"
        );

        // Sample Logic //
        Order.orderStateChange(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
