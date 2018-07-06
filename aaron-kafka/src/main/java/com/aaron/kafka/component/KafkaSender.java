package com.aaron.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName: KafkaSender
 * @Description : 消息提供者
 * @Author Aaron
 * @Date 2018/7/6
 * @Version 1.0
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.producer.key}")
    private String key;

    /**
     * 发送消息到kafka
     * topic=aaron
     */
    public void send(){
        log.info("开始消息发送------");
        kafkaTemplate.send("aaron",key,"发送的消息");
    }

}
