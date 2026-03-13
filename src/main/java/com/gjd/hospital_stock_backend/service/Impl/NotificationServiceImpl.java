package com.gjd.hospital_stock_backend.service.Impl;

import com.gjd.hospital_stock_backend.mapper.NotificationMapper;
import com.gjd.hospital_stock_backend.repository.NotificationRepository;
import com.gjd.hospital_stock_backend.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
}
