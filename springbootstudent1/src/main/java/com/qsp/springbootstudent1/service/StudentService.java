package com.qsp.springbootstudent1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootstudent1.dto.Student;
import com.qsp.springbootstudent1.dao.StudentDao;
import com.qsp.springbootstudent1.exception.DataNotFound;
import com.qsp.springbootstudent1.exception.IdNotFound;
import com.qsp.springbootstudent1.exception.EmailNotFound;
import com.qsp.springbootstudent1.exception.PhoneNotFound;
import com.qsp.springbootstudent1.util.ResponseStructure;

@Service
public class StudentService
{
	@Autowired
	private StudentDao dao;
	
	//private ResponseStructure<Student> responseStructure =new  ResponseStructure<>();
	 public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student)              
	    {
		    int secured_marks=student.getSecuredmarks();
		    int total = student.getTotal_marks();
		    int a=secured_marks*100;
		    double per=(a)/total;
		    student.setPercentage(per);
		    double percentage= student.getPercentage();
		    //double percentage= ((student.getPercentage()/student.getTotal_marks())*100);
	    	                                      
	    	 if(percentage<35)
	    	 {
	    		 student.setGrade("Fail");
	    	 }
	    	 else if(percentage>=35 && percentage<60)    //else if(student.getPercentage()>=65 && student.getPercentage()<90)
	    	 {
	    		 student.setGrade("Pass");
	    	 }
	    	 else if(percentage>=60 && percentage<75)
	    	 {
	    		 student.setGrade("First class");
	    	 }
	    	 else if(percentage>=75 && percentage<90)
	    	 {
	    		 student.setGrade("first class with distinction");
	    	 }
	    	 else
	    	 {
	    		 student.setGrade("A+");  
	    	 }
	    	 
	    	 ResponseStructure <Student> structure = new ResponseStructure<Student>();
	    	 structure.setMessage("data saved successfully");
	    	 structure.setStatus(HttpStatus.CREATED.value());
	    	 structure.setData(dao.saveStudent(student));
	    	 return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
	    }
	 
	 public ResponseEntity<ResponseStructure<Student>> getStudentById(int id) 
		{
			Student student = dao.getStudentById(id);
			ResponseStructure <Student> structure = new ResponseStructure<Student>();
			if(student != null)
			{
	   	    structure.setMessage("Data Found");
	   	    structure.setStatus(HttpStatus.FOUND.value());
	   	    structure.setData(student);
	   	    return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
			}
			else
			{
				throw new IdNotFound("Id Not Found");
			}
			
		}
	 
	
	 public ResponseEntity<ResponseStructure<List<Student>>> fetchAllStudent() 
		{
			List<Student> students = dao.fetchAllStudent();
			ResponseStructure <List <Student>> structure = new ResponseStructure<List<Student>>();
			if(students.isEmpty())
			{
				throw new DataNotFound("data not found");
			}
			else
			{
				structure.setMessage("Data Found");
		   	    structure.setStatus(HttpStatus.FOUND.value());
		   	    structure.setData(students);
		   	    return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
			}
		}

	 
	 public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) 
		{
			Student student = dao.deleteStudent(id);
			ResponseStructure <Student> structure = new ResponseStructure<Student>();
			if(student != null)
			{
	   	      structure.setMessage("Data deleted successfully");
	   	      structure.setStatus(HttpStatus.OK.value());
	   	      structure.setData(student);
	   	      return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
			}
			else
			{
				throw new IdNotFound("Id Not Found");
			}
		}	
	 
	 public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) 
	  {        
		    int secured_marks=student.getSecuredmarks();
		    int total = student.getTotal_marks();
		    int a=secured_marks*100;
		    double per=(a)/total;
		    student.setPercentage(per);
		    double percentage= student.getPercentage();
		    //double percentage= ((student.getPercentage()/student.getTotal_marks())*100);
	    	                                      
	    	 if(percentage<35)
	    	 {
	    		 student.setGrade("Fail");
	    	 }
	    	 else if(percentage>=35 && percentage<60)    //else if(student.getPercentage()>=65 && student.getPercentage()<90)
	    	 {
	    		 student.setGrade("Pass");
	    	 }
	    	 else if(percentage>=60 && percentage<75)
	    	 {
	    		 student.setGrade("First class");
	    	 }
	    	 else if(percentage>=75 && percentage<90)
	    	 {
	    		 student.setGrade("first class with distinction");
	    	 }
	    	 else
	    	 {
	    		 student.setGrade("A+");  
	    	 }
	    	 
	    	    Student student1 = dao.getStudentById(id);
				ResponseStructure<Student> structure = new ResponseStructure<Student>();
				if(student1!=null)
				{
					structure.setMessage("Data Updated Successfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dao.updateStudent(id, student));
					return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
				}
				else
				{
					throw new IdNotFound("Id Not Found");
				}	
			
	}
	 public ResponseEntity<ResponseStructure<Student>> updateEmail(int id, String email) 
	 {
		Student student = dao.getStudentById(id);
		ResponseStructure <Student> structure = new ResponseStructure<Student>();
		if(student != null)
		{
   	      structure.setMessage("Email Updated Sucessfully");
   	      structure.setStatus(HttpStatus.OK.value());
   	      structure.setData(student);
   	      student.setEmail(email);
   	      dao.updateStudent(id, student);
		  return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");  
		}
		
	 }

	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone)   //public Employee updatePhone(int id, long phone)
	{
		Student student = dao.getStudentById(id);
		ResponseStructure <Student> structure = new ResponseStructure<Student>();
		if(student != null)
		{
		  student.setPhone(phone);
   	      structure.setMessage("Phone Updated Sucessfully");
   	      structure.setStatus(HttpStatus.OK.value());
   	      structure.setData(student);
   	      dao.updateStudent(id, student);
		  return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
	   	
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
		//Employee employee = dao.findEmployee(id);
		//employee.setPhone(phone);
		//return dao.updateEmployee(id,employee);
	}
	
	public ResponseEntity<ResponseStructure<Student>> updateName(int id, String name)
	{
		Student student = dao.getStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) 
		{
			structure.setMessage("Name Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);
			student.setName(name);
			dao.updateStudent(id, student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);

		}
//		else 
//		{
//			structure.setMessage("Id Not Found ");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(employee);
//			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.NOT_FOUND);
//		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
	}
  
	public  ResponseEntity<ResponseStructure<Student>> updateAddress(int id, String address)
	{
		Student student =dao.getStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if(student !=null)
		{
			structure.setMessage("Address Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);
			student.setAddress(address);
			dao.updateStudent(id, student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		}

		else
		{
			throw new IdNotFound("Id Not Found");
		}
					
	}
	
	public ResponseEntity<ResponseStructure<Student>> updateSecuredmarks(int id, int securedmarks)  
	{
		Student student =dao.getStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if(student !=null)
		{
			structure.setMessage("Securedmarks updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);
			student.setSecuredmarks(securedmarks);
			
			int secured_marks=student.getSecuredmarks();
		    int total = student.getTotal_marks();
		    int a=secured_marks*100;
		    double per=(a)/total;
		    student.setPercentage(per);
		    double percentage= student.getPercentage();
		    //double percentage= ((student.getPercentage()/student.getTotal_marks())*100);
	    	                                      
	    	 if(percentage<35)
	    	 {
	    		 student.setGrade("Fail");
	    	 }
	    	 else if(percentage>=35 && percentage<60)    //else if(student.getPercentage()>=65 && student.getPercentage()<90)
	    	 {
	    		 student.setGrade("Pass");
	    	 }
	    	 else if(percentage>=60 && percentage<75)
	    	 {
	    		 student.setGrade("First class");
	    	 }
	    	 else if(percentage>=75 && percentage<90)
	    	 {
	    		 student.setGrade("first class with distinction");
	    	 }
	    	 else
	    	 {
	    		 student.setGrade("A+");  
	    	 }
			dao.updateStudent(id, student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findByEmail(String email) 
	{
		Student student = dao.findByEmail(email);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) 
		{
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		} 
//		else
//		{
//			structure.setMessage("Data Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(employee);
//			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.NOT_FOUND);
//		}
		else
		{
			throw new EmailNotFound("Email Not Found");
			
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findByPhone(long phone) 
	{
		Student student = dao.findByPhone(phone);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) 
		{
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		} 
		else
		{
			throw new PhoneNotFound("Phone Not Found");
		}
	}	
	
	public ResponseEntity<ResponseStructure<List<Student>>> findStudentBySecuredmarksGreaterThan(int securedmarks)
	{
		List<Student> students= dao.findStudentBySecuredmarksGreaterThan(securedmarks);
	    ResponseStructure<List<Student>> structure =new ResponseStructure<List<Student>>();
	    if(students.isEmpty())
	     {
			throw new DataNotFound("Data Not Found");
		 }
		 else
		  {
			  structure.setMessage("Data Found");
			  structure.setStatus(HttpStatus.FOUND.value());
			  structure.setData(students);
			  return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		  }	
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findStudentBySecuredmarksLessThan(int securedmarks)
	{
		List<Student> students =dao.findStudentBySecuredmarksLessThan(securedmarks);
		ResponseStructure<List<Student>> structure =new ResponseStructure<List<Student>>();
		if(students.isEmpty())   //if (student != null) possible or not check
		 {
			throw new DataNotFound("Data Not Found");
		 }
		 else
		  {
			  structure.setMessage("Data Found");
			  structure.setStatus(HttpStatus.FOUND.value());
			  structure.setData(students);
			  return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		  }	
	}

}

		 
