package com.db.table;

import java.util.ArrayList;

public class ProjCatalogInfo {
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<ProjCatalog> getRows() {
		return rows;
	}
	public void setRows(ArrayList<ProjCatalog> rows) {
		this.rows = rows;
	}
	private int total;
	private ArrayList<ProjCatalog> rows;
	
}
