package com.app.reactive;

import com.rabbitmq.client.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.Sender;

import javax.annotation.PreDestroy;
import java.util.Objects;

/**
 * @author apanthi
 */
@Configuration
@Slf4j
@RequiredArgsConstructor
public class SenderCommandLineRunner implements CommandLineRunner {

    private final Mono<Connection> connectionMono;

    private final Sender sender;

    private static final String QUEUE = "demo-queue";

    @PreDestroy
    public void close() throws Exception {
        Objects.requireNonNull(connectionMono.block()).close();
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

    }
}
