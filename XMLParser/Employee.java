package ex3;

import java.util.Date;

public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	private int empId;
	private String empName;
	private int empSalary;
	private String empDOB;
	private String empEmail;
	private Long empHomePhone;
	private Long empOfficePhone;
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public void setEmpHomePhone(Long empHomePhone) {
		this.empHomePhone = empHomePhone;
	}
	public void setEmpOfficePhone(Long empOfficePhone) {
		this.empOfficePhone = empOfficePhone;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public String getEmpDOB() {
	return empDOB;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public Long getEmpHomePhone() {
		return empHomePhone;
	}
	public Long getEmpOfficePhone() {
		return empOfficePhone;
	}
	
}
