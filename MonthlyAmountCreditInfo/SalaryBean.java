package MonthlyAmountCreditInfo;


import java.util.Comparator;
import java.util.Date;

public class SalaryBean implements Comparator<SalaryBean>{
	
	private float salary;
	private Date date;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int compare(SalaryBean s1, SalaryBean s2) {
		// TODO Auto-generated method stub
		return s1.getDate().compareTo(s2.getDate());
	}	
}
