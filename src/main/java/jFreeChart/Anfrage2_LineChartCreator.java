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
import model.Anfrage2;
import model.Anfrage_IF;

public class Anfrage2_LineChartCreator {
	protected List<Anfrage2> anfrageList;

	private Anfrage2_LineChartCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage2>) anfrageList;
	}
	
	public static JFreeChart createAnfrage2Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage2_LineChartCreator creator = new Anfrage2_LineChartCreator(anfrageList);
		return creator.createChart();
	}
	
	protected JFreeChart createChart() {
	      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	      for(int i = 0; i < anfrageList.size(); i++) {
	    	  line_chart_dataset.addValue(anfrageList.get(i).getNumberOfQueries(), "Anfragen", anfrageList.get(i).getDate_MMDD());
			}
	      
	      JFreeChart lineChartObject = ChartFactory.createLineChart(
	         "Anzahl der Anfragen zu „american idol“ pro Stunde über alle Tage","Stunde","Anzahl der Anfragen",
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
