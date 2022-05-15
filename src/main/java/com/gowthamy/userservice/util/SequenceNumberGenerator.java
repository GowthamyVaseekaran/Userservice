package com.gowthamy.userservice.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@EnableScheduling
@Slf4j
public class SequenceNumberGenerator {

    private final AtomicLong counter = new AtomicLong();

    public long getSequenceNumber() {
        return counter.incrementAndGet();
    }

    @Scheduled(cron = "${user.sequence.number.reset.cron}")
    private void reset() {
        counter.set(0);
        log.info("Sequence Number Reset");
    }
}
