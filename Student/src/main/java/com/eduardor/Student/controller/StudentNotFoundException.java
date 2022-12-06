package com.eduardor.Student.controller;

public class StudentNotFoundException  extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StudentNotFoundException(Long id) {
	    super("Student not found " + id);
	  }
}
