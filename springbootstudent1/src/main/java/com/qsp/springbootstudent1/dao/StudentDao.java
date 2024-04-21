package com.qsp.springbootstudent1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootstudent1.dto.Student;
import com.qsp.springbootstudent1.repo.StudentRepo;

@Repository
public class StudentDao 
{
	 @Autowired
	 private StudentRepo repo;
	
	public Student saveStudent(Student student) 
	{
		return repo.save(student);
	}
    
	public Student getStudentById(int id)
	   {
		Optional<Student> optional=repo.findById(id);
		if(optional.isPresent())
		{
		    //return optional.get();
			Student student=optional.get();
			return student;
		}
		else
		{
		return null;
		}
	   }

	public List<Student> fetchAllStudent() 
	{
	   return repo.findAll();
	}

	public Student deleteStudent(int id)
	{
		Optional<Student> optional=repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}
	
	public Student updateStudent(int id,Student student)   
	{
		Optional<Student> optional=repo.findById(id);  //we used optional class to avoid NoSuchElementException
		if(optional.isPresent())
		{
			student.setId(id);
			return repo.save(student);
		}
		return null;
	}
	
	public Student findByEmail(String email)
	{
		return repo.findStudentByEmail(email);
	}
	
	public Student findByPhone(long phone)
	{
		return repo.findStudentByPhone(phone);
		//return repo.studentByPhone(phone);
	}

	public List<Student> findStudentBySecuredmarksGreaterThan(int securedmarks)
	{
		return repo.findStudentBySecuredmarksGreaterThan(securedmarks);
	}
	
	public List<Student> findStudentBySecuredmarksLessThan(int securedmarks)
	{
		return repo.findStudentBySecuredmarksLessThan(securedmarks);
	}

	

}
