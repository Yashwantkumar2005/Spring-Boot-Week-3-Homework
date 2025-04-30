package com.google.yashwant.service;

import com.google.yashwant.entities.professorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.yashwant.repositories.*;
import com.google.yashwant.entities.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class professorService {
    private final professorRepository professorRepository;
    private final studentRepository studentRepository;
    private final subjectRepository subjectRepository;


    public professorEntity getProfessorById(Long professorid) {
        return professorRepository.findById(professorid).orElse(null);
    }

    public professorEntity createNewProfessor(professorEntity professor) {
        return professorRepository.save(professor);
    }

    public professorEntity assignProfessorTOStudent(Long professorid, Long studentid) {
        Optional<professorEntity> professorEntity = professorRepository.findById(professorid);
        Optional<studentEntity> studentEntity = studentRepository.findById(studentid);
        return professorEntity.flatMap(professor -> studentEntity.map(student -> {
            professor.getStudents().add(student);
            return professorRepository.save(professor);
        })).orElse(null);
    }

    public professorEntity assignProfessorTOSubject(Long professorid, Long subjectid) {
        Optional<professorEntity> professorEntity = professorRepository.findById(professorid);
        Optional<subjectEntity> subjectEntity = subjectRepository.findById(subjectid);
        return professorEntity.flatMap(professor -> subjectEntity.map(subject -> {
            professor.getSubjects().add(subject);
            subject.setProfessor(professor);
            subjectRepository.save(subject);
            return professorRepository.save(professor);
        })).orElse(null);
    }
}
