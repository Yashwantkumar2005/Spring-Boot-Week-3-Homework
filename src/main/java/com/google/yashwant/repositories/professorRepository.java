package com.google.yashwant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.google.yashwant.entities.*;
import org.springframework.stereotype.Repository;

@Repository
public interface professorRepository extends JpaRepository<professorEntity,Long> {
}
