package com.example.http.sse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cxy17@xxx.com
 * @date 2022/4/12 1:37 PM
 * @descption
 */
@RestController
@RequestMapping(value = "/spring/sse")
public class SpringSseController {

    private static Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 连接
     *
     * @param dateId
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/listener")
    public SseEmitter sse(@RequestParam String dateId) throws IOException {
        SseEmitter sseEmitter = new SseEmitter(300000L);
        sseEmitterMap.put(dateId, sseEmitter);
        return sseEmitter;
    }

    /**
     * 发送
     *
     * @param dateId
     * @param data
     */
    @RequestMapping(value = "/send")
    public void send(@RequestParam String dateId, @RequestParam String data) throws IOException {
        SseEmitter sseEmitter = sseEmitterMap.get(dateId);
        sseEmitter.send(data);
        sseEmitter.complete();
    }
}
