package com.meditrack.notification_service.service;

import com.meditrack.notification_service.entity.Notification;

import java.util.List;

/**
 * Service interface defining essential methods for managing notifications.
 */
public interface NotificationService {

    /**
     * Creates a new notification.
     *
     * @param notification The notification entity to be created.
     * @return The created notification.
     */
    Notification createNotification(Notification notification);

    /**
     * Retrieves all notifications for a specific patient by their ID.
     *
     * @param patientId The unique ID of the patient.
     * @return A list of notifications associated with the given patient.
     */
    List<Notification> getNotificationsByPatient(String patientId);
}
