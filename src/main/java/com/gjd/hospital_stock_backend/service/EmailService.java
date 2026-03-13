package com.gjd.hospital_stock_backend.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
