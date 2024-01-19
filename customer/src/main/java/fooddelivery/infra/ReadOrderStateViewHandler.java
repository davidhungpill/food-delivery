package fooddelivery.infra;

import fooddelivery.config.kafka.KafkaProcessor;
import fooddelivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReadOrderStateViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ReadOrderStateRepository readOrderStateRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            ReadOrderState readOrderState = new ReadOrderState();
            // view 객체에 이벤트의 Value 를 set 함
            readOrderState.setOrderState(orderPlaced.getOrderState());
            // view 레파지 토리에 save
            readOrderStateRepository.save(readOrderState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderStateChanged_then_UPDATE_1(
        @Payload OrderStateChanged orderStateChanged
    ) {
        try {
            if (!orderStateChanged.validate()) return;
            // view 객체 조회
            Optional<ReadOrderState> readOrderStateOptional = readOrderStateRepository.findById(
                orderStateChanged.getId()
            );

            if (readOrderStateOptional.isPresent()) {
                ReadOrderState readOrderState = readOrderStateOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                readOrderState.setOrderState(orderStateChanged.getOrderState());
                // view 레파지 토리에 save
                readOrderStateRepository.save(readOrderState);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
