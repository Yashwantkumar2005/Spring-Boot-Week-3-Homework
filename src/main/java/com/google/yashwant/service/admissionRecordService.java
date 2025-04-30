package com.google.yashwant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.yashwant.repositories.*;
import com.google.yashwant.entities.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class admissionRecordService {
    private final admissionRecordRepository admissionRecordRepository;
    private final studentRepository studentRepository;

    public List<admissionRecordEntity> getallstudents(){
        return admissionRecordRepository.findAll();
    }
    public admissionRecordEntity getStudentDetailsById(Long studentid) {
        return admissionRecordRepository.findById(studentid).orElse(null);
    }

    public admissionRecordEntity saveStudent(admissionRecordEntity details) {
        return admissionRecordRepository.save(details);
    }

    public admissionRecordEntity takeadmission(Long studentid, Long admissionid) {
        Optional<studentEntity> studentEntity = studentRepository.findById(studentid);
        Optional<admissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionid);
        return admissionRecordEntity.flatMap(admissionRecord -> studentEntity.map(student -> {
            admissionRecord.setStudent(student);
            return admissionRecordRepository.save(admissionRecord);
        })).orElse(null);
    }
}