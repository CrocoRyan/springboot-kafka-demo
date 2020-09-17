package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.KafkaConfiguration;
import com.example.demo.service.KafkaService;
import com.example.demo.service.KafkaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaServiceImpl kafkaService;

    @Autowired
    private KafkaConfiguration kafkaConfiguration;

    /**
     * 发送文本消息
     * @param msg
     * @return
     */
    @GetMapping("/send/{msg}")
    public String send(@PathVariable String msg) {
        kafkaService.send(kafkaConfiguration.getMyTopic1(), msg);
        return "生产者发送消息给topic1："+msg;
    }
}
