package jFreeChart;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Anfrage3;
import model.Anfrage5;
import model.Anfrage_IF;

public class Anfrage5_BarChartHorizontalCreator {
	protected List<Anfrage5> anfrageList;

	private Anfrage5_BarChartHorizontalCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage5>) anfrageList;
	}

	public static JFreeChart createAnfrage5Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage5_BarChartHorizontalCreator creator = new Anfrage5_BarChartHorizontalCreator(anfrageList);
		return creator.createChart();
	}

	protected JFreeChart createChart() {

		DefaultCategoryDataset bar_chart_dataset = new DefaultCategoryDataset();
		for (int i = 0; i < anfrageList.size(); i++) {
			bar_chart_dataset.addValue(anfrageList.get(i).getNumberOfQueries(), "Anfragen", anfrageList.get(i).getTitel());
		}

		JFreeChart barChart = ChartFactory.createBarChart3D("Welche der vorgetragenen Songs ab Top 3 bis zum Finale wurde am häufigsten "
				+ "gesucht innerhalb einer Woche nach der Performance", "Songs", "Anfragen", 
				bar_chart_dataset, PlotOrientation.HORIZONTAL, true, true, false);
		barChart.getLegend().setVisible(false);
		return barChart;
	}
}
