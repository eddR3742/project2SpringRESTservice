package com.eduardor.Student.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eduardor.Student.entity.Student;
import com.eduardor.Student.repository.StudentRepository;

@Configuration
class StudentService {

  private static final Logger log = LoggerFactory.getLogger(StudentService.class);

  @Bean
  CommandLineRunner initDatabase(StudentRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Student("Caleb",3.6,"Female")));
      log.info("Preloading " + repository.save(new Student("Aida", 3.1,"Female")));
      log.info("Preloading " + repository.save(new Student("Alex",3.4,"Male")));
      log.info("Preloading " + repository.save(new Student("Meba",3.2,"Male")));
    };
  }
}