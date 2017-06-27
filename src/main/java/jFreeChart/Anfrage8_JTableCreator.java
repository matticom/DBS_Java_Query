package jFreeChart;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.Anfrage8;
import model.Anfrage_IF;

public class Anfrage8_JTableCreator {
	protected List<Anfrage8> anfrageList;

	private Anfrage8_JTableCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage8>) anfrageList;
	}

	public static JTable createAnfrage8Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage8_JTableCreator creator = new Anfrage8_JTableCreator(anfrageList);
		return creator.createChart();
	}

	protected JTable createChart() {

		Anfrage8_TableModel tableModel = new Anfrage8_TableModel(anfrageList);
		JTable table = new JTable(tableModel);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		return table;
	}
}
