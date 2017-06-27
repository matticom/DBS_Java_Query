package jFreeChart;

import static jFreeChart.Util.*;
import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Anfrage1;
import model.Anfrage_IF;

public class Anfrage1_LineChartCreator {
	protected List<Anfrage1> anfrageList;

	private Anfrage1_LineChartCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage1>) anfrageList;
	}
	
	public static JFreeChart createAnfrage1Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage1_LineChartCreator creator = new Anfrage1_LineChartCreator(anfrageList);
		return creator.createChart();
	}
	
	protected JFreeChart createChart() {
	      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	      for(int i = 0; i < anfrageList.size(); i++) {
	    	  line_chart_dataset.addValue(anfrageList.get(i).getNumberOfQueries(), "Anfragen", conventMonth(anfrageList.get(i).getDate_MMDD()));
			}
	      
	      JFreeChart lineChartObject = ChartFactory.createLineChart(
	         "Wie war der Verlauf der Anzahl der Anfragen zu 'american idol' pro Tag im Zeitraum (März bis Juni)?","Tage","Anzahl der Anfragen",
	         line_chart_dataset,PlotOrientation.VERTICAL,
	         true,true,false);
	      
	      final CategoryAxis domainAxis = lineChartObject.getCategoryPlot().getDomainAxis();
	      domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/3));
	      domainAxis.setUpperMargin(0.01);
	      domainAxis.setLowerMargin(0.01);
	      domainAxis.setTickLabelFont(new Font("Helvetica", Font.BOLD, 8));
	      lineChartObject.getLegend().setVisible(false);
	      return lineChartObject;
	   }

}
