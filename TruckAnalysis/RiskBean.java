package ex9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RiskBean {
	
	private String driverId;
	private String truckId;
	private String model;
	private List<TruckUsage> truckUsageList;
	private List<RiskBean> riskbean = new ArrayList<RiskBean>();
	
	private static final String INPUT_FILE_PATH = "D:/Deepu/Inputfile/ex9/trucks.csv";
	private static final String OUT_FILE_PATH = "D:/Deepu/Inputfile/ex9/output.csv";
	private StringBuffer sb = new StringBuffer();
	private FileWriter writer;
	private Scanner scan;
	private String currentLine;
	private String vehicledetails[];
	TruckUsage truck;
	public void getVehicleDetails()
	{
		try 
		{
			scan = new Scanner(new File(INPUT_FILE_PATH));
			writer = new FileWriter(OUT_FILE_PATH);
			while(scan.hasNext())
			{
				scan.nextLine();
				currentLine = scan.next().trim();
				RiskBean obj = new RiskBean();
				vehicledetails = currentLine.split(",");
				obj.setDriverId(vehicledetails[0]);
				obj.setTruckId(vehicledetails[1]);
				obj.setModel(vehicledetails[2]);
				int distance =0;
				int fuel =0;
				Date date = null;
				int i =3;
				int j =4;
				int MM = 4;
				int dd =1;
				int year = 2013;
				truckUsageList = new ArrayList<TruckUsage>();
				while(i<vehicledetails.length)
				{
					if(MM > 12)
					{
						MM =01;
						year--;
					}
					distance = Integer.parseInt(vehicledetails[i]);
					fuel= Integer.parseInt(vehicledetails[i+1]);
					String observetime = MM+"/"+dd+"/"+year;
					truck = new TruckUsage(distance, fuel, observetime);
					i=i+2;
					truckUsageList.add(truck);
					MM++;
				}
				obj.setTruckUsageList(truckUsageList);
				riskbean.add(obj);
			}
			printVehicledetails();
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("The process cannot access the file because it is being used by another process");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void printVehicledetails()
	{
		Iterator<RiskBean> it = riskbean.iterator();
		try{
		writer.append("TruckId");
		writer.append(",");
		writer.append("DriverId");
		writer.append(",");
		writer.append("ModelNumber");
		writer.append(",");
		writer.append("Distance");
		writer.append(",");
		writer.append("fuelconsumed");
		writer.append(",");
		writer.append("obersvationtime");
		writer.append("\n");
		for(int i=0;i<riskbean.size();i++)
		{
			RiskBean r = it.next();
			List<TruckUsage> li = r.getTruckUsageList();
			Iterator<TruckUsage> it1 = li.iterator();
			for(int j=0;j<li.size();j++)
			{
				TruckUsage t = it1.next();
				writer.append(r.getTruckId());
				writer.append(",");
				writer.append(r.getDriverId());
				writer.append(",");
				writer.append(r.getModel());
				writer.append(",");
				writer.append(Integer.toString(t.getMiles()));
				writer.append(",");
				writer.append(Integer.toString(t.getGas()));
				writer.append(",");
				writer.append(t.getObservationTime());
				writer.append("\n");
				
			}
		}
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try 
		{
			writer.close();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public List<TruckUsage> getTruckUsageList() {
		return truckUsageList;
	}

	public void setTruckUsageList(List<TruckUsage> truckUsageList) {
		this.truckUsageList = truckUsageList;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getTruckId() {
		return truckId;
	}

	public void setTruckId(String truckId) {
		this.truckId = truckId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
