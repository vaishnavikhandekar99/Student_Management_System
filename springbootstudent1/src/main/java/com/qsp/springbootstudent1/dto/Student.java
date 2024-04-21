package com.qsp.springbootstudent1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

@Entity
public class Student 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @NotBlank(message="Name can't be blank ")
  @NotNull(message="Name can't be null")
  //@Pattern(regexp = "[a-zA-Z_$]+",message="name should contains only alphabets ")
 // @Size(min=1, max=25, message = "no of character should be less tha
  private String name;
  
  @NotBlank(message="address can't be blank")
  @NotNull(message="address can't be null")
  private String address;
  
  @Column(unique=true)
  @Min(value = 6000000000l)
  @Max(value = 9999999999l)
  //@Pattern(regexp = "[6-9][0-9]{9}")  --> regular expression is only use for String type of data
  private long phone;
  
  @Column(unique=true)
  @NotBlank(message="Email can't be blank")
  @NotNull(message="Email can't be null")
  @Email(regexp ="[a-z0-9._%$+-]+@[a-z0-9]+\\.[a-z]{2,3}" ,message="Invalid Email")
  private String email;
  
  @Min(value = 0)
  private int securedmarks;
  
  private int total_marks;
  private double percentage;
  private String grade;
  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getSecuredmarks() {
	return securedmarks;
}
public void setSecuredmarks(int securedmarks) {
	this.securedmarks = securedmarks;
}
public int getTotal_marks() {
	return total_marks;
}
public void setTotal_marks(int total_marks) {
	this.total_marks = total_marks;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email
			+ ", securedmarks=" + securedmarks + ", total_marks=" + total_marks + ", percentage=" + percentage
			+ ", grade=" + grade + "]";
}
  
  
}
