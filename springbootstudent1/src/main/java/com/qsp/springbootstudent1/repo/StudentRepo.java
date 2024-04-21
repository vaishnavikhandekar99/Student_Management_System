package com.qsp.springbootstudent1.repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.qsp.springbootstudent1.dto.Student;

public interface StudentRepo  extends JpaRepository<Student, Integer>
{
	Student findStudentByEmail(String email);
	
 	Student findStudentByPhone(long phone);

 	//@Query("SELECT s FROM Student s where s.phone=?1")
 	//Student studentByPhone(long phone);
 	
	List<Student> findStudentBySecuredmarksGreaterThan(int securedmarks);  
    
	List<Student> findStudentBySecuredmarksLessThan(int securedmarks);  
	
   

}
