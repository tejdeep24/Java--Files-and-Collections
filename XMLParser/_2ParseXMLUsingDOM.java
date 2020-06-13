package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class _2ParseXMLUsingDOM {
	
	private static final String INPUT_FILE1_PATH ="D:/Deepu/Inputfile/ex3/employee.xml";
	private static final String OUTPUT_FILE_PATH = "D:/Deepu/Inputfile/ex3/employee_DOM_details.txt";
	
	private FileWriter writer = null;
	private File inputfile;
	private StringBuffer sb = new StringBuffer();
	Employee emp;
	private int Employee_id ;
	private String Employee_name;
	private int Employee_salary;
	private String Employee_dob;
	private String Employee_email;
	private long Employee_Ofcphone;
	private long Employee_homephone;
	
	
	public _2ParseXMLUsingDOM() {
		try {
			inputfile = new File(INPUT_FILE1_PATH);
			writer = new FileWriter(OUTPUT_FILE_PATH);
		} 
		catch (FileNotFoundException e) {
			System.out.println("ParseXMLUsingDOM ex:"+e);
		}
		catch (IOException e) {
			System.out.println("ParseXMLUsingDOM ex:"+e);
		}
		
	}
	private void getEmployeeDetails()
	{
		try{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputfile);
		doc.getDocumentElement().normalize();
		System.out.println("Root element :"  + doc.getDocumentElement().getNodeName());
	    NodeList nList = doc.getElementsByTagName("employee");
	    System.out.println("----------------------------");
	    for (int temp = 0; temp < nList.getLength(); temp++)
	    {
	    		emp = new Employee();
	    		Node nNode = nList.item(temp);
	    		System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	
	               Element eElement = (Element) nNode;
	               emp.setEmpId(Integer.parseInt(eElement.getElementsByTagName("empId").item(0).getTextContent()));
	               emp.setEmpName(eElement.getElementsByTagName("empName").item(0).getTextContent());
	               emp.setEmpSalary(Integer.parseInt(eElement.getElementsByTagName("empSalary").item(0).getTextContent()));
	               emp.setEmpDOB(eElement.getElementsByTagName("empDOB").item(0).getTextContent());
	               emp.setEmpEmail(eElement.getElementsByTagName("empEmail").item(0).getTextContent());
	               emp.setEmpOfficePhone(Long.parseLong(eElement.getElementsByTagName("phone").item(0).getTextContent()));
	               emp.setEmpHomePhone(Long.parseLong(eElement.getElementsByTagName("phone").item(1).getTextContent()));
	               
	               Employee_id= emp.getEmpId();
	               Employee_name = emp.getEmpName();
	               Employee_salary = emp.getEmpSalary();
	               Employee_dob = emp.getEmpDOB();
	               Employee_email = emp.getEmpEmail();
	               Employee_Ofcphone = emp.getEmpOfficePhone();
	               Employee_homephone = emp.getEmpHomePhone();
	               printEmployeeDetails(Employee_id,Employee_name,Employee_salary,Employee_dob,Employee_email,Employee_Ofcphone,Employee_homephone);
	            }
		} 
	    closeResources();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			System.out.println("ParseXMLUsingDOM.getEmployeeDetails Exception:"+e);
		} 
		catch (SAXException e) {
			System.out.println("ParseXMLUsingDOM.getEmployeeDetails Exception:"+e);
		} 
		catch (IOException e) {
			System.out.println("ParseXMLUsingDOM.getEmployeeDetails Exception:"+e);
		} 
		catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void printEmployeeDetails(int id,String name,int sal,String dob,String email,Long ofcphone,Long homephone)
	{
		
		sb.setLength(0);
		sb.append("\n");
		sb.append("Employee details");
		sb.append("\n");
		sb.append(id);
		sb.append("\n");
		sb.append(name);
		sb.append("\n");
		sb.append(sal);
		sb.append("\n");
		sb.append(dob);
		sb.append("\n");
		sb.append(email);
		sb.append("\n");
		sb.append(ofcphone);
		sb.append("\n");
		sb.append(homephone);
		sb.append("\n");
		sb.append("----------------------------------");
		System.out.println(sb);
		try{
			writer.append(sb);
		}
		catch(IOException e)
		{
			System.out.println("_2ParseXMLUsingDOM.printEmployeeDetails(-,-) Exception:"+e);
		}
		
	}
	
	private void closeResources()
	{
		try{
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("_2ParseXMLUsingDOM.closeResources(-,-) Exception:"+e);
		}
	}
	public static void main(String args[])
	{
		_2ParseXMLUsingDOM dom = new _2ParseXMLUsingDOM();
		dom.getEmployeeDetails();
	}
}
