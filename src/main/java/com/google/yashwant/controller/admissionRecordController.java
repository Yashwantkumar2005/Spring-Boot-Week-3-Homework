package com.google.yashwant.controller;

import com.google.yashwant.entities.admissionRecordEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.google.yashwant.service.*;

@RestController
@RequestMapping("/admissionrecord")
@RequiredArgsConstructor
public class admissionRecordController {
    private final admissionRecordService admissionRecordService;

    @GetMapping("/{studentid}")
    private admissionRecordEntity getStudentDetailsById(@PathVariable Long studentid) {
        return admissionRecordService.getStudentDetailsById(studentid);
    }

    @PostMapping
    private admissionRecordEntity saveStudentDetails(@RequestBody admissionRecordEntity details) {
        return admissionRecordService.saveStudent(details);
    }

    @PutMapping("/{admissionid}/student/{studentid}")
    private admissionRecordEntity updateStudentDetails(@PathVariable Long studentid, @PathVariable Long admissionid) {
        return admissionRecordService.takeadmission(studentid, admissionid);
    }
}
