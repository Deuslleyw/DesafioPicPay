package com.deusley.picpay.service.impl;

import com.deusley.picpay.clients.NotificationClient;
import com.deusley.picpay.entity.Transfer;
import com.deusley.picpay.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    private NotificationClient notificationClient;


    @Override
    public void sendNotification(Transfer transfer) {

        try {
            logger.info("Sending notification...");
            var response = notificationClient.sendNotification(transfer);

            if (response.getStatusCode().isError()) {
                logger.error("Error while sending notification, status code is not OK");
            }

        } catch (Exception e) {
            logger.error("Error while sending notification", e);


        }
    }
}