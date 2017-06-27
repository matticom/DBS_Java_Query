package jFreeChart;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Anfrage3;
import model.Anfrage_IF;

public class Anfrage3_BarChartHorizontalCreator {
	protected List<Anfrage3> anfrageList;

	private Anfrage3_BarChartHorizontalCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage3>) anfrageList;
	}

	public static JFreeChart createAnfrage3Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage3_BarChartHorizontalCreator creator = new Anfrage3_BarChartHorizontalCreator(anfrageList);
		return creator.createChart();
	}

	protected JFreeChart createChart() {

		DefaultCategoryDataset bar_chart_dataset = new DefaultCategoryDataset();
		for (int i = 0; i < anfrageList.size(); i++) {
			bar_chart_dataset.addValue(anfrageList.get(i).getNumberOfQueries(), "Anfragen", anfrageList.get(i).getClickURL());
		}

		JFreeChart barChart = ChartFactory.createBarChart3D("Welche Seiten wurden mit Bezug auf 'american idol' am häufigsten angeklickt?", "Webseiten", "Klicks", 
				bar_chart_dataset, PlotOrientation.HORIZONTAL, true, true, false);
		barChart.getLegend().setVisible(false);
		return barChart;
	}
}
