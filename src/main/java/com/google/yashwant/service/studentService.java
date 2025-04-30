package com.google.yashwant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.yashwant.entities.*;
import com.google.yashwant.repositories.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class studentService {
    private final studentRepository studentRepository;
    private final subjectRepository subjectRepository;

    public studentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    public studentEntity createNewStudent(studentEntity studentDetails) {
        return studentRepository.save(studentDetails);

    }

    public studentEntity assignSubjectToStudent(Long studentid, Long subjectid) {
        Optional<studentEntity> studentEntity = studentRepository.findById(studentid);
        Optional<subjectEntity> subjectEntity = subjectRepository.findById(subjectid);
        return studentEntity.flatMap(student -> subjectEntity.map(subject -> {
            student.getSubjects().add(subject);
            return studentRepository.save(student);
        })).orElse(null);
    }
}
