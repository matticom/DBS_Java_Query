package jFreeChart;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Anfrage8;

public class Anfrage8_TableModel extends AbstractTableModel {

	private List<Anfrage8> anfrageList;
	private String[] columns;

	public Anfrage8_TableModel(List<Anfrage8> anfrageList){
		    this.anfrageList = anfrageList ;
		    columns = new String[]{"Ranknummer", "Anzahl der Klicks" };
		  }

	public int getColumnCount() {
		return columns.length;
	}

	public int getRowsCount() {
		return anfrageList.size();
	}

	public Object getValueAt(int row, int col) {
		Anfrage8 anfrage = anfrageList.get(row);
		switch (col) {
		case 0:
			return anfrage.getItemRank();
		case 1:
			return anfrage.getNumberOfQueries();
		default:
			return null;
		}
	}
	
	@Override
	public int getRowCount() {
		return anfrageList.size();
	}

	public String getColumnName(int col) {
	    return columns[col] ;
	}
}
