package com.food.ordering.system.order.service.dataaccess.outbbox.payment.exception;

public class PaymentOutboxNotFoundException extends RuntimeException {

    public PaymentOutboxNotFoundException(String message) {
        super(message);
    }
}
