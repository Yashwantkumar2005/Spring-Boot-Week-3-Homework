package com.google.yashwant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.google.yashwant.entities.*;
import com.google.yashwant.service.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class subjectController {
    private final subjectService subjectService;

    @GetMapping("/{subjecttid}")
    private subjectEntity getsubjecybyid(@PathVariable Long subjectid) {
        return subjectService.getSubjectById(subjectid);
    }
    @GetMapping()
    private List<subjectEntity> getsubjecy() {
        return subjectService.getall();
    }

    @PostMapping
    private subjectEntity createnewsubject(@RequestBody subjectEntity subject) {
        return subjectService.createNewSubject(subject);
    }

    @PutMapping("/{subjectid}/student/{studentid}")
    private subjectEntity assignSubjecttostudent(@PathVariable Long subjectid, @PathVariable Long studentid) {
        return subjectService.assignSubjectToStudent(subjectid, studentid);
    }

    @PutMapping("/{subjectid}/professor/{professorid}")
    private subjectEntity assignSubjecttoprofessor(@PathVariable Long subjectid, @PathVariable Long professorid) {
        return subjectService.assignSubjectToProfessor(subjectid, professorid);
    }
}