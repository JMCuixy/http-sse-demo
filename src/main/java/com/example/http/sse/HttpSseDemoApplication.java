package com.example.http.sse;

import com.example.http.sse.config.MyEventSourceListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpSseDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HttpSseDemoApplication.class, args);
    }

    private EventSource newEventSource() {
        return newEventSource(null);
    }

    private EventSource newEventSource(String accept) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request.Builder builder = new Request.Builder().url("http://127.0.0.1:8080/spring/sse/listener?dateId=cache");
        if (accept != null) {
            builder.header("Accept", accept);
        }
        Request request = builder.build();
        EventSource.Factory factory = EventSources.createFactory(okHttpClient);
        return factory.newEventSource(request, new MyEventSourceListener());
    }

    @Override
    public void run(String... args) throws Exception {
        newEventSource();
    }
}
