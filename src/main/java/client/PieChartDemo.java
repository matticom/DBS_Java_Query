package client;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import jFreeChart.PieDatasetCreator;

public class PieChartDemo {

	public static void main(String[] args) {
		PieDataset dataset = PieDatasetCreator.createKandidatenPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("Geschlechtsverteilung der Kandidaten", dataset, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		ApplicationFrame appFrame = new ApplicationFrame("Geschlechtsverteilung der Kandidaten");
		appFrame.getContentPane().add(chartPanel);
		appFrame.setSize(560, 367);
		RefineryUtilities.centerFrameOnScreen(appFrame);
		appFrame.setVisible(true);
	}

}
