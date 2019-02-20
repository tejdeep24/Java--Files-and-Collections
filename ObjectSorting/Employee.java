package ex7;


public class Employee implements Comparable<Employee> {

	private int Employee_Id;
	private String Employee_Name;
	private String Employee_dept;
	private int Employee_salary;
	private String Employee_doj;
	

	public Employee(int Employee_Id, String Employee_Name,
			String Employee_dept, int Employee_salary, String Employee_doj) {

		this.Employee_Id = Employee_Id;
		this.Employee_Name = Employee_Name;
		this.Employee_dept = Employee_dept;
		this.Employee_salary = Employee_salary;
		this.Employee_doj = Employee_doj;
	}
	public int getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return Employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}
	public String getEmployee_dept() {
		return Employee_dept;
	}
	public void setEmployee_dept(String employee_dept) {
		Employee_dept = employee_dept;
	}
	public int getEmployee_salary() {
		return Employee_salary;
	}
	public void setEmployee_salary(int employee_salary) {
		Employee_salary = employee_salary;
	}
	public String getEmployee_doj() {
		return Employee_doj;
	}
	public void setEmployee_doj(String employee_doj) {
		Employee_doj = employee_doj;
	}
	
	@Override
	public int compareTo(Employee empsalary) {
		
		int empsal = ((Employee)empsalary).getEmployee_salary();
		return this.Employee_salary-empsal;
	}
	}
