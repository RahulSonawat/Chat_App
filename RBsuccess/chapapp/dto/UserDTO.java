package com.RBsuccess.chapapp.dto;

public class UserDTO {
	String userid;
	char[] password;
	String salary;
	String phoneNumber,city,state,email,ques,answer;


			//POLYMORPHISM
public UserDTO(String userid,char[]	password) {
	// TODO Auto-generated constructor stub
	this.password=password;
	this.userid=userid;
	this.salary="10000$";
}
			//POLYMORPHISM
public UserDTO(String userid, String phoneNumber, String city, String state,char[] password,String email,String ques,String answer)
{
	this.userid=userid;
	this.phoneNumber=phoneNumber;
	this.city=city;
	this.state=state;
	this.password=password;
	this.salary="10000$";
	this.email=email;
	this.ques=ques;
	this.answer=answer;
}
			//POLYMORPHISM
public UserDTO(String email,String Question,String answer) {
	this.email=email;
	this.ques=Question;
	this.answer=answer;
}
			//POLYMORPHISM
public UserDTO(char[] password,String ques,String answer,String email)
{
	this.password=password;
	this.ques=ques;
	this.email=email;
	this.answer=answer;
}

public String getQues() {
	return ques;
}
public void setQues(String ques) {
	this.ques = ques;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public char[] getPassword() {
	return password;
}
public void setPassword(char[] password) {
	this.password = password;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
}
