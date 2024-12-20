package com.meditrack.notification_service.controller;

import com.meditrack.notification_service.entity.Notification;
import com.meditrack.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for managing notifications.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    /**
     * Create a new notification.
     *
     * @param notification the notification details.
     * @return ResponseEntity with the created notification.
     */
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        log.info("API call to create a new notification");
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.status(201).body(createdNotification);
    }

    /**
     * Fetch notifications for a specific patient.
     *
     * @param patientId the patient ID.
     * @return ResponseEntity with a list of notifications for the patient.
     */
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Notification>> getNotificationsByPatient(@PathVariable String patientId) {
        log.info("API call to fetch notifications for patient ID: {}", patientId);
        List<Notification> notifications = notificationService.getNotificationsByPatient(patientId);
        return ResponseEntity.ok(notifications);
    }

}
