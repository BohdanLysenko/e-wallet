package ua.lysenko.quartzservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@Entity
@Table(name = "qrtz_job_history")
@AllArgsConstructor
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String jobClass;

    Long runTime;
    Date fireTime;

    String status;

    String errorMessage;

    public JobHistory() {

    }
}
