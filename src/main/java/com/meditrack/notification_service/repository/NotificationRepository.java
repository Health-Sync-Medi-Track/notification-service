package com.meditrack.notification_service.repository;

import com.meditrack.notification_service.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Notification entities in MongoDB.
 */
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByPatientId(String patientId);
    List<Notification> findByStatus(String status);
}
