package ex7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Employee_deptwise {
	
	
	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/ex7/employee.txt";
	
	private Scanner scan;
	private String currentLine;
	private String Employee_details[];
	private List<String> employee_details;
	private List<Employee> employee_obj = new ArrayList<Employee>();
	private List<Employee> employee_obj1= new ArrayList<Employee>();
	private Map<String,List<Employee>> map = new HashMap<String,List<Employee>>();
	private Employee emp;
	private int empid;
	private String empname;
	private String empdept;
	private int empsalary;
	private String empdoj;
	private void readEmployeeDetails()
	{
		try {
				scan = new Scanner(new File(INPUT_FILE_PATH));
				while(scan.hasNext())
				{
					currentLine = scan.nextLine().trim();
					Employee_details = currentLine.split(",");
					employee_details = new ArrayList<String>();
					for(int i=0;i<Employee_details.length;i++)
						{
							employee_details.add(Employee_details[i]);
						}
					Iterator<String> it = employee_details.iterator();
					while(it.hasNext())
						{
							empid =Integer.parseInt(it.next().toString());
							empname =it.next().toString();
							empdept=it.next().toString();
							empsalary = Integer.parseInt(it.next().toString());
							empdoj =it.next().toString();
						}
					emp= new Employee(empid,empname,empdept,empsalary,empdoj);
					if(emp.getEmployee_dept().equals("d001"))
					{
						employee_obj.add(emp);
						Collections.sort(employee_obj);
						map.put(emp.getEmployee_dept(),employee_obj);
					}
					else{
						
						employee_obj1.add(emp);
						Collections.sort(employee_obj1);
						map.put(emp.getEmployee_dept(),employee_obj1);
					}			
				}
				for(Entry<String,List<Employee>> entry:map.entrySet())
				{
					String key = entry.getKey();
					System.out.println("Employess of dept "+key);
					System.out.println();
					List<Employee> empdetails = entry.getValue();
					for(int i =0;i<empdetails.size();i++)
					{
						System.out.println("Employee_Id:"+empdetails.get(i).getEmployee_Id());
						System.out.println("Employee_Name:"+empdetails.get(i).getEmployee_Name());
						System.out.println("Employee_Dept:"+empdetails.get(i).getEmployee_dept());
						System.out.println("Employee_Salary:"+empdetails.get(i).getEmployee_salary());
						System.out.println("Employee_DOJ:"+empdetails.get(i).getEmployee_doj());
						System.out.println();
					}
				}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Employee_deptwise obj = new Employee_deptwise();
		obj.readEmployeeDetails();
	}

}
