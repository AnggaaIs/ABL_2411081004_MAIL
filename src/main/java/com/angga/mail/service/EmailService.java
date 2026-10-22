package com.angga.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.angga.mail.dto.OrderEvent;

@Service
public class EmailService {

  @Autowired
  private JavaMailSender mailSender;

  public void sendOrderConfirmation(OrderEvent event) {
    String to = event.getEmail();

    if (to == null || to.isBlank()) {
      System.out.println("Email kosong untuk order " + event.getId());
      return;
    }

    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(to);
      message.setSubject("Konfirmasi Order #" + event.getId());
      message.setText(
          "Halo " + event.getPelangganNama() + ",\n\n" +
              "Order Anda berhasil dibuat.\n\n" +
              "No. Order    : " + event.getId() + "\n" +
              "Tanggal      : " + event.getTglTrans() + "\n" +
              "Nama Produk  : " + event.getProdukNama() + "\n" +
              "Harga Produk : " + event.getProdukHarga() + "\n" +
              "Jumlah       : " + event.getJumlah() + "\n" +
              "Total        : " + event.getTotal() + "\n" +
              "Alamat Kirim : " + event.getPelangganAlamat() + "\n\n" +
              "Terima kasih telah berbelanja.\n\n" +
              "Salam,\nPangeran");

      mailSender.send(message);
      System.out.println("Email terkirim ke " + to);

    } catch (Exception e) {
      System.err.println("Gagal mengirim email: " + e.getMessage());
    }
  }
}
