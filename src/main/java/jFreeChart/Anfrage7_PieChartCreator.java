package jFreeChart;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;


import model.Anfrage7;
import model.Anfrage_IF;

public class Anfrage7_PieChartCreator {
	protected List<Anfrage7> anfrageList;

	private Anfrage7_PieChartCreator(List<? extends Anfrage_IF> anfrageList) {
		this.anfrageList = (List<Anfrage7>) anfrageList;
	}

	public static JFreeChart createAnfrage7Chart(List<? extends Anfrage_IF> anfrageList) {
		Anfrage7_PieChartCreator creator = new Anfrage7_PieChartCreator(anfrageList);
		return creator.createChart();
	}

	protected JFreeChart createChart() {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (int i = 0; i < anfrageList.size(); i++) {
			String name = anfrageList.get(i).getNname();
			if (name.equals("Abdul") || name.equals("Cowell") || name.equals("Jackson")) {
				name = name + " (JUROR)";
			}
			dataset.setValue(anfrageList.get(i).getVname() + " " + name, anfrageList.get(i).getNumberOfQueries());
		}

		JFreeChart chart = ChartFactory.createPieChart("Wie häufig wurden die Juroren im Vergleich zu den Kandidaten gesucht?",
				dataset, true,true, false);

		final PiePlot plot = (PiePlot) chart.getPlot();
		plot.setStartAngle(270);
		plot.setForegroundAlpha(0.60f);
		plot.setInteriorGap(0.02);
		chart.getLegend().setVisible(false);
		return chart;
	}
}
