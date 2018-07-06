package com.aaron.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * @ClassName: KafkaReceiver
 * @Description : 消费者
 * @Author Aaron
 * @Date 2018/7/5
 * @Version 1.0
 */
@Slf4j
@Component
public class Consumer {
    /**
     * 监听aaron主题,有消息就读取
     *
     * @param record
     */
    @KafkaListener(topics = {"aaron"})
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("kafka的key: " + record.key());
        log.info("kafka的value: " + record.value().toString());
    }


}
