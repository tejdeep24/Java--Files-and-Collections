package Excel_XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Excel_Xml_Generator {

		public static List<Employee> readXLSAndGetList(String filePath,String cols[]) throws IOException
		{
			List<Employee> empList = new ArrayList<Employee>();
			
			try 
			{
				FileInputStream fis = new FileInputStream(new File(filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet worksheet = workbook.getSheet("Sheet1");
				Iterator<Row> rowit = worksheet.iterator();;
				rowit.next();
				while(rowit.hasNext())
				{
					Row cuurentrow = rowit.next();
					Iterator<Cell> cellit = cuurentrow.iterator();
					while(cellit.hasNext())
					{
						Employee emp = new Employee();
						Cell currentcell = cellit.next();
						emp.setEmpName(currentcell.getStringCellValue());
						Cell currentcell1 = cellit.next();
						emp.setEmpAge((int)currentcell1.getNumericCellValue());
						Cell currentcell2 = cellit.next();
						emp.setEmpSalary((float)currentcell2.getNumericCellValue());
						empList.add(emp);
						break;
					}
				}

			} 
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			return empList;
		}
		
		public static String getXMLFromList(List<Employee> empList) throws DOMException ,ParserConfigurationException, TransformerException
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element rootElement = doc.createElement("employees");
			doc.appendChild(rootElement);
			for(Employee emp:empList)
			{
			String empName=emp.getEmpName();
			int empAge=emp.getEmpAge();
			float empSalary=emp.getEmpSalary();
			
			Element employee = doc.createElement("employee");
			rootElement.appendChild(employee);
			
			Element name = doc.createElement("name");
			name.appendChild(doc.createTextNode(empName));
			employee.appendChild(name);
			
			Element age = doc.createElement("age");
			age.appendChild(doc.createTextNode(Integer.toString(empAge)));
			employee.appendChild(age);
			
			Element salary = doc.createElement("salary");
			salary.appendChild(doc.createTextNode(Float.toString(empSalary)));
			employee.appendChild(salary);
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			//StreamResult result  = new StreamResult(new File("D:/Deepu/Inputfile/ExcelToXml/employees.xml"));
			StreamResult result  = new StreamResult(writer);
			transformer.transform(source, result);
			String xmlString = writer.toString();
			return xmlString;
			
		}
		public static void main(String[] args) throws DOMException,ParserConfigurationException, IOException, TransformerException {
			
			String arr[] = {"name","age","salary"};
			List<Employee> empList = readXLSAndGetList("D:/Deepu/Inputfile/ExcelToXml/Employee.xlsx",arr);
			String xml = getXMLFromList(empList);
			System.out.println("XML Content is:");
			System.out.println(xml);
		}

}
