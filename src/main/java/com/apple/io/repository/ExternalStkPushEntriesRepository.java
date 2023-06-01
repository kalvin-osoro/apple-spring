package com.apple.io.repository;

import com.apple.io.dto.mpesa.ExternalStkPushRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalStkPushEntriesRepository extends JpaRepository<ExternalStkPushRequest, Long> {
}
