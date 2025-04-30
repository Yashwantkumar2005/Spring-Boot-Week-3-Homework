package com.google.yashwant.repositories;

import com.google.yashwant.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface admissionRecordRepository extends JpaRepository<admissionRecordEntity,Long> {
}
