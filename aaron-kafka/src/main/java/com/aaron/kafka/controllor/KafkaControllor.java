package com.aaron.kafka.controllor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: KafkaControllor
 * @Description : 消息提供者
 * @Author Aaron
 * @Date 2018/7/5
 * @Version 1.0
 */
@RestController
@Slf4j
public class KafkaControllor {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send")
    public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
        try {
            String message = request.getParameter("message");
            log.info("kafka的消息={}", message);
            kafkaTemplate.send("aaron", "key", message);
            log.info("发送kafka成功.");
            return  "发送kafka成功";
        } catch (Exception e) {
            log.error("发送kafka失败", e);
            return "发送kafka失败";
        }
    }

}
