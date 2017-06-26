package jFreeChart;

import java.awt.Font;
import java.util.List;
import static jFreeChart.Util.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Anfrage4;
import model.Anfrage_IF;

public class Anfrage4_BarChartCreator {
	protected List<Anfrage4> anfrageList;

	private Anfrage4_BarChartCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage4>) anfrageList;
	}

	public static JFreeChart createAnfrage4Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage4_BarChartCreator creator = new Anfrage4_BarChartCreator(anfrageList);
		return creator.createChart();
	}

	protected JFreeChart createChart() {

		DefaultCategoryDataset bar_chart_dataset = new DefaultCategoryDataset();
		for (int i = 0; i < anfrageList.size(); i++) {
			bar_chart_dataset.addValue(anfrageList.get(i).getNumberOfQueries(), "Anfragen", conventMonth(anfrageList.get(i).getDate_MMDD()));
		}

		JFreeChart barChart = ChartFactory.createBarChart3D("Wie hat sich das Suchverhalten (Anfragen) auf die beiden Finalisten verändert vor und nach dem Finale?", "Finalist",
				"Anfragen", bar_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
		barChart.getLegend().setVisible(false);
		final CategoryAxis domainAxis = barChart.getCategoryPlot().getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 3));
		domainAxis.setUpperMargin(0.01);
		domainAxis.setLowerMargin(0.01);
		domainAxis.setTickLabelFont(new Font("Helvetica", Font.BOLD, 8));

		return barChart;
	}
}
