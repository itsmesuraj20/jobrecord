package com.jobrecord.repository;

import com.jobrecord.model.Job;
import com.jobrecord.model.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByStatus(JobStatus status);

    List<Job> findByCompanyNameContainingIgnoreCase(String companyName);

    List<Job> findByPositionContainingIgnoreCase(String position);

    @Query("SELECT j FROM Job j WHERE j.applicationDate BETWEEN :startDate AND :endDate")
    List<Job> findByApplicationDateBetween(@Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    @Query("SELECT j FROM Job j WHERE j.followUpDate <= :date AND j.status != 'REJECTED' AND j.status != 'SELECTED'")
    List<Job> findJobsRequiringFollowUp(@Param("date") LocalDateTime date);

    @Query("SELECT j FROM Job j WHERE " +
            "(:companyName IS NULL OR LOWER(j.companyName) LIKE LOWER(CONCAT('%', :companyName, '%'))) AND " +
            "(:position IS NULL OR LOWER(j.position) LIKE LOWER(CONCAT('%', :position, '%'))) AND " +
            "(:status IS NULL OR j.status = :status)")
    List<Job> findJobsWithFilters(@Param("companyName") String companyName,
            @Param("position") String position,
            @Param("status") JobStatus status);

    long countByStatus(JobStatus status);
}