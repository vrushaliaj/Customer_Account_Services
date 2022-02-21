package com.example.Customer_Service.Config;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignClientRetryer implements Retryer {
      /* private int retryMaxAttempt;

    private long retryInterval;

    private int attempt;


    public FeignClientRetryer() {
        this(10000L, 6);
    }

    public FeignClientRetryer(long retryInterval, int retryMaxAttempt) {
        this.retryInterval = retryInterval;
        this.retryMaxAttempt = retryMaxAttempt;
        this.attempt = 1;
    }

    @SneakyThrows
    @Override
    public void continueOrPropagate(RetryableException e) {
        log.info("Feign retry attempt {} due to {} ", attempt, e.getMessage());

        if (attempt++ >= retryMaxAttempt) {
            throw e;
        }
        try {
            log.info("waiting for: " + System.currentTimeMillis());
            Thread.sleep(retryInterval);
            log.info("wait over: " + System.currentTimeMillis());
        } catch (InterruptedException ignored) {
            Thread.sleep(retryInterval);
            Thread.currentThread().interrupt();
        }

    }

    @Override
    public Retryer clone() {
        return new FeignClientRetryer(retryInterval, retryMaxAttempt);
    }*/

    @Override
    public void continueOrPropagate(RetryableException e) {
        throw e;
    }

    @Override
    public Retryer clone() {
        log.info("Feign retry attempt");
        return new Retryer.Default(10000, 5000, 5);
    }
}
