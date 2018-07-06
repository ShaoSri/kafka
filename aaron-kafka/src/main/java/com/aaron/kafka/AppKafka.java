package com.aaron.kafka;

import com.aaron.kafka.component.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class AppKafka
{

    @Autowired
    private KafkaSender kafkaSender;


    public static void main(String[] args) {
        SpringApplication.run(AppKafka.class,args);
    }

    //然后每隔1分钟执行一次
    @Scheduled(fixedRate = 1000 * 60)
    public void testKafka() {
        kafkaSender.send();
    }


}
