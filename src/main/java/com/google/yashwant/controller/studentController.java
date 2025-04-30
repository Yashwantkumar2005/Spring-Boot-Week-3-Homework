package com.google.yashwant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.google.yashwant.entities.*;
import com.google.yashwant.service.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class studentController {
    private final studentService studentService;

    @GetMapping("/{studentid}")
    private studentEntity getStudentById(@PathVariable Long studentid) {
        return studentService.getStudentById(studentid);
    }

    @PostMapping
    private studentEntity createNewStudent(@RequestBody studentEntity student) {
        return studentService.createNewStudent(student);
    }

    @PutMapping("/{studentid}/subject/{subjectid}")
    private studentEntity assignsubjecttostudent(@PathVariable Long studentid, @PathVariable Long subjectid) {
        return studentService.assignSubjectToStudent(studentid, subjectid);
    }
}
