package com.db.table;

import java.util.ArrayList;

public class ServiceDevInformationSum {
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<ServiceDevInformation> getRows() {
		return rows;
	}
	public void setRows(ArrayList<ServiceDevInformation> rows) {
		this.rows = rows;
	}
	private int total;
	private ArrayList<ServiceDevInformation> rows;

}
