package com.Student_app_using_fileSystem.entities;

public class Students {
	
	private Integer studentId;
	
	private String studentName;
	
	private Integer rollNo;
	
	private String emailId;
	
	private Long mobNo;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobNo() {
		return mobNo;
	}

	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(Integer studentId, String studentName, Integer rollNo, String emailId, Long mobNo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.emailId = emailId;
		this.mobNo = mobNo;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", rollNo=" + rollNo + ", emailId="
				+ emailId + ", mobNo=" + mobNo + "]";
	}
	
	
}
