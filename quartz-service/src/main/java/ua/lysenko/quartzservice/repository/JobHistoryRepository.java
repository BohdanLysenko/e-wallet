package ua.lysenko.quartzservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lysenko.quartzservice.entity.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

}
