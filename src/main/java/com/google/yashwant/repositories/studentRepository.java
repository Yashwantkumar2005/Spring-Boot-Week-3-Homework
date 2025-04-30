package com.google.yashwant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.google.yashwant.entities.*;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<studentEntity,Long> {
}
