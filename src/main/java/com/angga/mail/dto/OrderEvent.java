package com.angga.mail.dto;

import java.time.LocalDate;

public class OrderEvent {
  private String eventType;
  private Long id;
  private Long produkId;
  private Long pelangganId;
  private LocalDate tglTrans;
  private Integer jumlah;
  private Double total;
  private String email;
  private String produkNama;
  private Double produkHarga;
  private String pelangganNama;
  private String pelangganAlamat;

  public OrderEvent() {
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProdukId() {
    return produkId;
  }

  public void setProdukId(Long produkId) {
    this.produkId = produkId;
  }

  public Long getPelangganId() {
    return pelangganId;
  }

  public void setPelangganId(Long pelangganId) {
    this.pelangganId = pelangganId;
  }

  public LocalDate getTglTrans() {
    return tglTrans;
  }

  public void setTglTrans(LocalDate tglTrans) {
    this.tglTrans = tglTrans;
  }

  public Integer getJumlah() {
    return jumlah;
  }

  public void setJumlah(Integer jumlah) {
    this.jumlah = jumlah;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProdukNama() {
    return produkNama;
  }

  public void setProdukNama(String produkNama) {
    this.produkNama = produkNama;
  }

  public Double getProdukHarga() {
    return produkHarga;
  }

  public void setProdukHarga(Double produkHarga) {
    this.produkHarga = produkHarga;
  }

  public String getPelangganNama() {
    return pelangganNama;
  }

  public void setPelangganNama(String pelangganNama) {
    this.pelangganNama = pelangganNama;
  }

  public String getPelangganAlamat() {
    return pelangganAlamat;
  }

  public void setPelangganAlamat(String pelangganAlamat) {
    this.pelangganAlamat = pelangganAlamat;
  }
}
