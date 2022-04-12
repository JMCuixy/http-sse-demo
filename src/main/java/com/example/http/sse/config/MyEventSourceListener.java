package com.example.http.sse.config;

import okhttp3.Response;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

/**
 * @author cxy17@xxx.com
 * @date 2022/3/31 7:05 PM
 * @descption
 */
public class MyEventSourceListener extends EventSourceListener {

    @Override
    public void onClosed(EventSource eventSource) {
        super.onClosed(eventSource);
    }

    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        super.onEvent(eventSource, id, type, data);
    }

    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        super.onFailure(eventSource, t, response);
    }

    @Override
    public void onOpen(EventSource eventSource, Response response) {
        super.onOpen(eventSource, response);
    }


}
