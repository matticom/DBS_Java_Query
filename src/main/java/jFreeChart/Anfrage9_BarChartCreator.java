package jFreeChart;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import static jFreeChart.Util.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Anfrage9;
import model.Anfrage_IF;

public class Anfrage9_BarChartCreator {
	protected List<Anfrage9> anfrageList;

	private Anfrage9_BarChartCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage9>) anfrageList;
	}

	public static JFreeChart createAnfrage9Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage9_BarChartCreator creator = new Anfrage9_BarChartCreator(anfrageList);
		return creator.createChart();
	}

	protected JFreeChart createChart() {

		DefaultCategoryDataset bar_chart_dataset = new DefaultCategoryDataset();

		List<String> interpreten = new ArrayList<String>();
		interpreten.add("Katherine McPhee");
		interpreten.add("Stevie Wonder");
		interpreten.add("KT Tunstall");
		interpreten.add("Judy Garland");
		interpreten.add("Elton John");
		interpreten.add("Tyler Hicks");
		List<String> dates = new ArrayList<String>();
		dates.add("05.23");
		dates.add("05.24");
		dates.add("05.25");
		dates.add("05.26");

		for (String in : interpreten) {
			for (String date : dates) {
				for (int i = 0; i < anfrageList.size(); i++) {
					if (anfrageList.get(i).getDate_MMDD().equals(date) && anfrageList.get(i).getName().equals(in)) {
						bar_chart_dataset.addValue((double) (anfrageList.get(i).getNumberOfQueries()), anfrageList.get(i).getName(),
								conventMonth(anfrageList.get(i).getDate_MMDD()));
					}
				}
			}
		}

		JFreeChart barChart = ChartFactory.createBarChart3D("Wie groß war die Anzahl der Suchanfragen zu den Interpreten der Top 2 Songs "
				+ "im Verlauf von drei Tage nach der Sendung?", "Interpreten/Tage",	"Anfragen", bar_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
		final CategoryAxis domainAxis = barChart.getCategoryPlot().getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 3));
		domainAxis.setUpperMargin(0.01);
		domainAxis.setLowerMargin(0.01);
		domainAxis.setTickLabelFont(new Font("Helvetica", Font.BOLD, 8));

		return barChart;
	}
}
