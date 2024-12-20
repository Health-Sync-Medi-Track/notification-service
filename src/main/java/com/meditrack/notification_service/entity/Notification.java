package com.meditrack.notification_service.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Entity class representing notification details stored in the database.
 */
@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;

    private String patientId;

    private String message;

    private LocalDateTime scheduledTime;

    private String status;

}
