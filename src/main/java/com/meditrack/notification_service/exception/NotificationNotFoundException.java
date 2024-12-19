package com.meditrack.notification_service.exception;

/**
 * Custom exception for notification not found scenarios.
 */
public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(String message) {
        super(message);
    }
}
