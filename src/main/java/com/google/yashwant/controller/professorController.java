package com.google.yashwant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.google.yashwant.entities.*;
import com.google.yashwant.service.*;


@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class professorController {
    private final professorService professorService;

    @GetMapping("/{professorid}")
    private professorEntity getProfessorById(@PathVariable Long professorid) {
        return professorService.getProfessorById(professorid);
    }

    @PostMapping
    private professorEntity createNewProfessor(@RequestBody professorEntity professor) {
        return professorService.createNewProfessor(professor);
    }

    @PutMapping("/{professorid}/student/{studentid}")
    private professorEntity assignProfessorTOStudent(@PathVariable Long professorid, @PathVariable Long studentid) {
        return professorService.assignProfessorTOStudent(professorid, studentid);

    }

    @PutMapping("/{professorid}/subject/{subjectid}")
    private professorEntity assignProfessorTOSubject(@PathVariable Long professorid, @PathVariable Long subjectid) {
        return professorService.assignProfessorTOSubject(professorid, subjectid);

    }
}
