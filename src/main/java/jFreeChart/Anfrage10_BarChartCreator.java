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

import model.Anfrage10_JUR;
import model.Anfrage10_MOD;
import model.Anfrage9;
import model.Anfrage_IF;

public class Anfrage10_BarChartCreator {
	protected List<Anfrage10_JUR> anfrageListJUR;
	protected List<Anfrage10_MOD> anfrageListMOD;

	private Anfrage10_BarChartCreator(List<? extends Anfrage_IF> anfrageListJUR, List<? extends Anfrage_IF> anfrageListMOD) {
		this.anfrageListJUR = (List<Anfrage10_JUR>) anfrageListJUR;
		this.anfrageListMOD = (List<Anfrage10_MOD>) anfrageListMOD;
	}

	public static JFreeChart createAnfrage10Chart(List<? extends Anfrage_IF> anfrageListJUR, List<? extends Anfrage_IF> anfrageListMOD) {
		Anfrage10_BarChartCreator creator = new Anfrage10_BarChartCreator(anfrageListJUR, anfrageListMOD);
		return creator.createChart();
	}

	protected JFreeChart createChart() {

		DefaultCategoryDataset bar_chart_dataset = new DefaultCategoryDataset();
		
		for (int i = 0; i < anfrageListJUR.size(); i++) {
			int mm = Integer.parseInt(anfrageListJUR.get(i).getDate_MMDD().substring(1, 2));
			int dd = Integer.parseInt(anfrageListJUR.get(i).getDate_MMDD().substring(3, 5));
			int value = mm*100+dd;
			
			if (value < 404) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 1");
				continue;
			} else if (value < 411) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 2");
				continue;
			} else if (value < 418) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 3");
				continue;
			} else if (value < 425) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 4");
				continue;
			} else if (value < 502) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 5");
				continue;
			} else if (value < 509) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 6");
				continue;
			} else if (value < 516) {
				anfrageListJUR.get(i).setDate_MMDD("Woche 7");
				continue;
			} else {
				anfrageListJUR.get(i).setDate_MMDD("Woche 8");
			}
		}
		
		for (int i = 0; i < anfrageListMOD.size(); i++) {
			int mm = Integer.parseInt(anfrageListMOD.get(i).getDate_MMDD().substring(1, 2));
			int dd = Integer.parseInt(anfrageListMOD.get(i).getDate_MMDD().substring(3, 5));
			int value = mm*100+dd;
			
			if (value < 404) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 1");
				continue;
			} else if (value < 411) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 2");
				continue;
			} else if (value < 418) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 3");
				continue;
			} else if (value < 425) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 4");
				continue;
			} else if (value < 502) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 5");
				continue;
			} else if (value < 509) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 6");
				continue;
			} else if (value < 516) {
				anfrageListMOD.get(i).setDate_MMDD("Woche 7");
				continue;
			} else {
				anfrageListMOD.get(i).setDate_MMDD("Woche 8");
			}
		}
		
		for(Anfrage10_MOD anfrage: anfrageListMOD) {
			System.out.println(anfrage);
		}
		
		for(Anfrage10_JUR anfrage: anfrageListJUR) {
			System.out.println(anfrage);
		}
		
		List<Anfrage10_JUR> personList = new ArrayList<Anfrage10_JUR>();
		
		List<String> modJur = new ArrayList<String>();
		modJur.add("Ryan Seacrest");
		modJur.add("Paula Abdul");
		modJur.add("Simon Cowell");
		modJur.add("Randy Jackson");
		
		List<String> weeks = new ArrayList<String>();
		weeks.add("Woche 1");
		weeks.add("Woche 2");
		weeks.add("Woche 3");
		weeks.add("Woche 4");
		weeks.add("Woche 5");
		weeks.add("Woche 6");
		weeks.add("Woche 7");
		weeks.add("Woche 8");

		for (String week : weeks) {
			for (String person : modJur) {
				int count = 0;
				for (int i = 0; i < anfrageListJUR.size(); i++) {
					if (anfrageListJUR.get(i).getDate_MMDD().equals(week) && anfrageListJUR.get(i).getName().equals(person)) {
						count = anfrageListJUR.get(i).getNumberOfQueries();
					}
				}
				for (int i = 0; i < anfrageListMOD.size(); i++) {
					if (anfrageListMOD.get(i).getDate_MMDD().equals(week) && anfrageListMOD.get(i).getName().equals(person)) {
						count = anfrageListMOD.get(i).getNumberOfQueries();
					}
				}
				bar_chart_dataset.addValue((double) count, person, week);
				
			}
		}

		JFreeChart barChart = ChartFactory.createBarChart3D("Wie häufig waren die Suchanfragen zu den Moderatoren/Jury (pro Person) "
				+ "im Verlauf der Ausstrahlungen (vom 28.03. bis 24.05 pro Woche)?", "Moderator bzw. Juror / Woche",	"Anfragen", 
				bar_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
		final CategoryAxis domainAxis = barChart.getCategoryPlot().getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 3));
		domainAxis.setUpperMargin(0.01);
		domainAxis.setLowerMargin(0.01);
		domainAxis.setTickLabelFont(new Font("Helvetica", Font.BOLD, 8));

		return barChart;
	}
}
