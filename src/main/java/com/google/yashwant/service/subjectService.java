package com.google.yashwant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.yashwant.repositories.*;
import com.google.yashwant.entities.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class subjectService {
    private final subjectRepository subjectRepository;
    private final studentRepository studentRepository;
    private final professorRepository professorRepository;

    public subjectEntity createNewSubject(subjectEntity subject) {
        return subjectRepository.save(subject);
    }
    public List<subjectEntity> getall(){return subjectRepository.findAll();}
    public subjectEntity getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public subjectEntity assignSubjectToStudent(Long subjectid, Long studentid) {
        Optional<subjectEntity> subjectEntity = subjectRepository.findById(subjectid);
        Optional<studentEntity> studentEntity = studentRepository.findById(studentid);
        return subjectEntity.flatMap(subject -> studentEntity.map(student -> {
            subject.getStudents().add(student);
            return subjectRepository.save(subject);
        })).orElse(null);
    }

    public subjectEntity assignSubjectToProfessor(Long subjectid, Long professorid) {
        Optional<subjectEntity> subjectEntity = subjectRepository.findById(subjectid);
        Optional<professorEntity> professorEntity = professorRepository.findById(professorid);
        return subjectEntity.flatMap(subject -> professorEntity.map(professor -> {
            subject.setProfessor(professor);
            return subjectRepository.save(subject);
        })).orElse(null);
    }
}