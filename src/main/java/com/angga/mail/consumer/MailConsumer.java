package com.angga.mail.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angga.mail.config.RabbitMQConfig;
import com.angga.mail.dto.OrderEvent;
import com.angga.mail.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class MailConsumer {

  @Autowired
  private EmailService emailService;

  private final ObjectMapper objectMapper = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

  @RabbitListener(queues = RabbitMQConfig.ORDER_EMAIL_QUEUE)
  public void receiveOrder(String payload) {
    try {
      OrderEvent event = objectMapper.readValue(payload, OrderEvent.class);
      System.out.println("Event order diterima untuk email: " + event.getEmail());
      emailService.sendOrderConfirmation(event);
    } catch (Exception e) {
      System.err.println("Gagal memproses event email: " + e.getMessage());
    }
  }
}
