package com.spring.orm.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

import java.util.*;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	
	
public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//	save method
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
//	get single data
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
//	get all students
	public List<Student> getAllStudents(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
//	deleting the data
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
//	update the data
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}

}
