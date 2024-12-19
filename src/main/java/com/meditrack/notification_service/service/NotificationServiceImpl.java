package com.meditrack.notification_service.service;

import com.meditrack.notification_service.entity.Notification;
import com.meditrack.notification_service.exception.NotificationNotFoundException;
import com.meditrack.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing notifications.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    /**
     * Creates a new notification.
     *
     * @param notification The notification entity to be created.
     * @return The created notification.
     */
    @Override
    public Notification createNotification(Notification notification) {
        log.info("Creating notification for patient ID: {}", notification.getPatientId());
        try {
            return notificationRepository.save(notification);
        } catch (Exception e) {
            log.error("Error occurred while creating notification for patient ID: {}", notification.getPatientId(), e);
            throw new RuntimeException("Failed to create notification");
        }
    }

    /**
     * Retrieves all notifications for a specific patient by their ID.
     *
     * @param patientId The unique ID of the patient.
     * @return A list of notifications associated with the given patient.
     */
    @Override
    public List<Notification> getNotificationsByPatient(String patientId) {
        log.info("Fetching notifications for patient ID: {}", patientId);
        try {
            List<Notification> notifications = notificationRepository.findByPatientId(patientId);
            if (notifications.isEmpty()) {
                throw new NotificationNotFoundException("No notifications found for patient ID: " + patientId);
            }
            return notifications;
        } catch (NotificationNotFoundException e) {
            log.warn("No notifications found for patient ID: {}", patientId, e);
            throw e;
        } catch (Exception e) {
            log.error("Error occurred while fetching notifications for patient ID: {}", patientId, e);
            throw new RuntimeException("Failed to fetch notifications for patient ID: " + patientId);
        }
    }
}
