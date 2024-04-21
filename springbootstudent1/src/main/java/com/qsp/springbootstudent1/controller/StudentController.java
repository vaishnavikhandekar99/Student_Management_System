package com.qsp.springbootstudent1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootstudent1.dto.Student;
import com.qsp.springbootstudent1.service.StudentService;
import com.qsp.springbootstudent1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
public class StudentController 
{
	
	@Autowired
	private StudentService service;
	
	//@PostMapping("/save")              
    //public Student saveStudent(@RequestBody Student student)
    // {
	// return dao.saveStudent(student);
    // }
	
	@PostMapping("/save")                                                                                    
	@ApiOperation(value ="Save Student",notes ="This API is used to save the student data into database")
	@ApiResponses(value={@ApiResponse(code=201,message="Data Saved Successfully")})
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@Valid @RequestBody Student student)
	{
	    return service.saveStudent(student);                                                                                
    }
	
	@GetMapping("/fetchById")
	@ApiOperation(value ="Get Student By Id",notes ="This API is used to fetch student data using student_id")
	@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Id not found")})
	public ResponseEntity<ResponseStructure<Student>> getStudent(@RequestParam int id)  
	   {
		  return service.getStudentById(id);
	   }
	
	@ApiOperation(value ="Get AllStudent",notes ="This API is used to fetch all the student data")
	@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Data not found")})
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAllStudent()
	{
		return service.fetchAllStudent();
	}
	
	@ApiOperation(value ="Delete Student",notes ="This API is used to delete student data using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Data deleted successfully"), @ApiResponse(code=404,message="Id not found")})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id )
	{
		return service.deleteStudent(id);
	}
	
	@ApiOperation(value ="Update Student",notes ="This API is used to update student data using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Data Updated Successfully"), @ApiResponse(code=404,message="Id not found")})
	@PutMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id, @Valid @RequestBody Student student)  
	{
		return service.updateStudent(id,student);
	}
	
	@ApiOperation(value ="Update Email",notes ="This API is used to update email using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Email Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
	@PatchMapping("/updateEmail/{id}") 
	public ResponseEntity<ResponseStructure<Student>> updateEmail(@PathVariable int id, @Valid @RequestParam String email) {
		return service.updateEmail(id, email);
	}
    
	@ApiOperation(value ="Update Phone",notes ="This API is used to update phone using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Phone Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@PathVariable int id, @Valid @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}
    
	@ApiOperation(value ="Update Name",notes ="This API is used to update name using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Name Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
	@PatchMapping("/updateName/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateName(@PathVariable int id,  @Valid @RequestParam String name) {
		return service.updateName(id, name);
	}
	
	@ApiOperation(value ="Update Address",notes ="This API is used to update address using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Address updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
	@PatchMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Student>> updateAddress(@RequestParam int id, @Valid @RequestParam String address) 
	{
		return service.updateAddress(id, address);
	}
    
	@ApiOperation(value ="Update Securedmarks",notes ="This API is used to update securedmarks using student_id")
	@ApiResponses(value={@ApiResponse(code=200,message="Securedmarks updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
	@PatchMapping("/updateSecuredmarks")
	public ResponseEntity<ResponseStructure<Student>> updateSecuredmarks(@RequestParam int id,@Valid @RequestParam int securedmarks) 
	{
		return service.updateSecuredmarks(id, securedmarks);  
	}
    
	@ApiOperation(value ="Find Student By Email",notes ="This API is used to find student by email")
	@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Email not found")})
	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Student>> findByEmail(@Valid @RequestParam String email) 
	{
		return service.findByEmail(email);
	}
    
	@ApiOperation(value ="Find Student By Phone",notes ="This API is used to find student by phone")
	@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Phone not found")})
	@GetMapping("/findByPhone")
	public ResponseEntity<ResponseStructure<Student>> findByPhone(@Valid @RequestParam long phone)  
	{
		return service.findByPhone(phone);
	}
	
	@ApiOperation(value ="find Student By Securedmarks GreaterThan",
			notes ="This API is used to find the student by secured marks greater than")
	@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Data not found")})
	@GetMapping("/findBySecuredmarksGreaterThan")
	public ResponseEntity<ResponseStructure<List<Student>>> findStudentBySecuredmarksGreaterThan(@RequestParam int securedmarks)
	{
		return service.findStudentBySecuredmarksGreaterThan(securedmarks);
	}
	
	@ApiOperation(value ="find Student By Securedmarks LessThan",
			notes ="This API is used to find the student by secured marks less than")
	@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Data not found")})
	@GetMapping("/findBySecuredmarksLessThan")
	public ResponseEntity<ResponseStructure<List<Student>>> findStudentBySecuredmarksLessThan(@RequestParam int securedmarks)  
	{
		return service.findStudentBySecuredmarksLessThan(securedmarks);
	}


}


