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

    @NotBlank
    private String patientId;

    @NotBlank
    private String message;

    @FutureOrPresent
    private LocalDateTime scheduledTime;

    @NotBlank
    private String status;

}
