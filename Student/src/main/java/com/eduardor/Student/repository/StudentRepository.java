package com.eduardor.Student.repository;

import com.eduardor.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long>{

}
