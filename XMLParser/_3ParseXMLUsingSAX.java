package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class _3ParseXMLUsingSAX  {
	private static final String INPUT_FILE1_PATH ="D:/Deepu/Inputfile/ex3/employee.xml";
	private static final String OUTPUT_FILE_PATH = "D:/Deepu/Inputfile/ex3/employee_Sax_details.txt";
	private File inputfile;
	private FileWriter writer;
	public StringBuffer sb = new StringBuffer();
	public _3ParseXMLUsingSAX() 
	{
		try 
		{
			inputfile = new File(INPUT_FILE1_PATH);
			writer = new FileWriter(OUTPUT_FILE_PATH);
		} 
		catch(FileNotFoundException e) 
		{
			System.out.println("_3ParseXMLUsingSAX ex:"+e);
		}
		catch(IOException e)
		{
			System.out.println("ParseXMLUsingSAX ex:"+e);
		}
	}
	private void getEmployeedetails()
	{
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxparser = factory.newSAXParser();
			UserHandler userhadler = new UserHandler();
			saxparser.parse(inputfile, userhadler);
			closeResources();
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
			System.out.println("_3ParseXMLUsingSAX.closeResources(-,-) Exception:"+e);
		}
	}
	public class UserHandler extends DefaultHandler{
		
		   private boolean empId = false;
		   private boolean empName = false;
		   private boolean empSalary = false;
		   private boolean empDOB = false;
		   private boolean empEmail = false;
		   private boolean emphomephone = false;
		   private boolean empofficephone = false;
		  
		   
		   Employee emp = new Employee();
		   int count=0;
		   @Override
		   
		   public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException {
		      if (qName.equalsIgnoreCase("empId")){
		    	 empId = true;
		      } else if (qName.equalsIgnoreCase("empName")) {
		         empName = true;
		      } else if (qName.equalsIgnoreCase("empSalary")) {
		         empSalary = true;
		      } else if (qName.equalsIgnoreCase("empDOB")) {
		         empDOB = true;
		      }
		      else if (qName.equalsIgnoreCase("empEmail")) {
		         empEmail = true;
		      }
		      else if (qName.equalsIgnoreCase("phone")){
		    	 String phonetype = attributes.getValue("type");
		    	 if(phonetype.equalsIgnoreCase("home"))
		    	 {
		    		 emphomephone = true;
		    	 }
		    	 if(phonetype.equalsIgnoreCase("office"))
		    	 {
			    		 empofficephone = true;
		    	 }
			  }
		   }

		   @Override
		   public void endElement(String uri, String localName, String qName) throws SAXException {
			   if (qName.equalsIgnoreCase("employee")) {
			         System.out.println("End Element :" + qName);
			      } 
		   }

		   @Override
		   public void characters(char ch[],int start, int length) throws SAXException {
			   try{
			   if(empId) {
				   count++;
				   int EmployeeId = Integer.parseInt(new String(ch,start,length));
				   emp.setEmpId(EmployeeId);
				   sb.setLength(0);
				   sb.append("Employee"+count);
				   sb.append("\n");
				   sb.append("\n");
				   sb.append("Employee Id:"+emp.getEmpId());
				   sb.append("\n");
				   writer.append(sb); 
				   empId = false; 
			   }else if (empName){
				   String EmployeeName = new String(ch, start, length);
				   emp.setEmpName(EmployeeName);
				   sb.setLength(0);
				   sb.append("Employee Name:"+emp.getEmpName());
				   sb.append("\n");
				   writer.append(sb);
		           empName = false;
		      } else if (empSalary) {
		    	   int EmployeeSalary = Integer.parseInt(new String(ch, start, length));
		    	   emp.setEmpSalary(EmployeeSalary);
		    	   sb.setLength(0);
		    	   sb.append("Employee Salary:"+emp.getEmpSalary());
		    	   sb.append("\n");
				   writer.append(sb);
		           empSalary = false;
		      } else if (empDOB) {
		    	  String EmployeeDOB = new String(ch, start, length);
				  emp.setEmpDOB(EmployeeDOB);
				  sb.setLength(0);
				  sb.append("Employee DOB:"+emp.getEmpDOB());
				  sb.append("\n");
				  writer.append(sb);
		          empDOB = false;
		      } else if (empEmail) {
		    	  String EmployeeEmail = new String(ch, start, length);
				  emp.setEmpEmail(EmployeeEmail);
				  sb.setLength(0);
				  sb.append("Employee Email"+emp.getEmpEmail());
				  sb.append("\n");
				  writer.append(sb);
		          empEmail = false;
		      }else if (emphomephone) {
		    	  Long EmployeeHomePhone = Long.parseLong(new String(ch, start, length));
		    	  emp.setEmpHomePhone(EmployeeHomePhone);
		    	  sb.setLength(0);
		    	  sb.append("Employee Home Phone:"+emp.getEmpHomePhone());
		    	  sb.append("\n");
				  writer.append(sb);
			      emphomephone = false;
			  }else if (empofficephone) {
				  Long EmployeeOfficePhone = Long.parseLong(new String(ch, start, length));
		    	  emp.setEmpOfficePhone(EmployeeOfficePhone);
		    	  sb.setLength(0);
		    	  sb.append("Employee Office Phone:"+emp.getEmpOfficePhone());
		    	  sb.append("\n");
		    	  sb.append("\n");
				  writer.append(sb);
			      empofficephone = false;
			  }
		   }
		   catch (IOException e)
		   {
			e.printStackTrace();
		   }
		   }
	}
	public static void main(String args[])
	{
		_3ParseXMLUsingSAX obj = new _3ParseXMLUsingSAX();
		obj.getEmployeedetails();
	}
}
