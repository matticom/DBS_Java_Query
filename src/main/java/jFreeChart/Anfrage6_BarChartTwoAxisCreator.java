package jFreeChart;

import java.awt.Color;
import java.awt.Paint;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Anfrage6;

public class Anfrage6_BarChartTwoAxisCreator {

	protected List<Anfrage6> anfrage6List;

	protected Anfrage6_BarChartTwoAxisCreator(List<Anfrage6> anfrage6List) {
		this.anfrage6List = anfrage6List;
	}

	public static JFreeChart createAnfrage6Chart(List<Anfrage6> anfrage6List) {
		Anfrage6_BarChartTwoAxisCreator creator = new Anfrage6_BarChartTwoAxisCreator(anfrage6List);
		return creator.createChart();
	}

	protected JFreeChart createChart() {
		String[] xAxisUnits = createXAxisUnits();
		DefaultCategoryDataset datasetQueries = createNumberOfQueriesDataSet(xAxisUnits);
		DefaultCategoryDataset datasetViewers = createNumberOfViewersDataSet(xAxisUnits);
		
		BarRenderer.setDefaultBarPainter(new StandardBarPainter());
		
		final CategoryAxis domainAxis = new CategoryAxis("Shows");
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/5));
		domainAxis.setTickLabelPaint(new Color(100, 100, 100));
		domainAxis.setCategoryLabelPositionOffset(10);
        final NumberAxis rangeAxis = new NumberAxis("Anzahl der Anfragen");
        final BarRenderer renderer1 = new BarRenderer();
        renderer1.setItemMargin(0.01);
        renderer1.setSeriesPaint(0, new Color(0, 172, 178));
        renderer1.setShadowVisible(false);
        // Zahlen auf die Bars
//        renderer1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer1.setBaseItemLabelsVisible(true);
        @SuppressWarnings("serial")
		final CategoryPlot plot = new CategoryPlot(datasetQueries, domainAxis, rangeAxis, renderer1) {
          
            public LegendItemCollection getLegendItems() {

                final LegendItemCollection result = new LegendItemCollection();

                final CategoryDataset data = getDataset();
                if (data != null) {
                    final CategoryItemRenderer r = getRenderer();
                    if (r != null) {
                        final LegendItem item = r.getLegendItem(0, 0);
                        result.add(item);
                    }
                }
                
                final CategoryDataset dset2 = getDataset(1);
                if (dset2 != null) {
                    final CategoryItemRenderer renderer2 = getRenderer(1);
                    if (renderer2 != null) {
                        final LegendItem item = renderer2.getLegendItem(1, 1);
                        result.add(item);
                    }
                }
                return result;
            }
        };
        
        final JFreeChart chart = new JFreeChart("Wie ist der Verlauf der Suchanfragen an dem jeweiligen Tag der "
        		+ "Sendungen im Vergleich zur Zuschaueranzahl nach Nielson Rating?", plot);
        chart.setBackgroundPaint(Color.white);
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.getDomainAxis().setLowerMargin(.03);
        plot.getDomainAxis().setCategoryMargin(0.4);
        plot.getDomainAxis().setUpperMargin(.03); 
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        plot.setDataset(1, datasetViewers);
        plot.mapDatasetToRangeAxis(1, 1);
        final ValueAxis axis2 = new NumberAxis("Zuschaueranzahl");
        plot.setRangeAxis(1, axis2);
        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        final BarRenderer renderer2 = new BarRenderer();
        renderer2.setItemMargin(0.01);
        renderer2.setShadowVisible(false);
        renderer2.setSeriesPaint(1, new Color(240, 177, 69));
        renderer2.setGradientPaintTransformer(null);
        plot.setRenderer(1, renderer2);
      
        return chart;
	}

	protected String[] createXAxisUnits() {
		String[] xAxisUnits = new String[anfrage6List.size()];
		for (int i = 0; i < anfrage6List.size(); i++) {
			xAxisUnits[i] = anfrage6List.get(i).getShow();
		}
		return xAxisUnits;
	}

	protected DefaultCategoryDataset createNumberOfQueriesDataSet(String[] xAxisUnits) {
		final String numberOfQueries = "Anzahl der Suchanfragen";
		final String numberOfViewers = "Anzahl der Zuschauer";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < anfrage6List.size(); i++) {
			dataset.addValue(anfrage6List.get(i).getNumberOfQueries(), numberOfQueries, xAxisUnits[i]);
		}
		for (int i = 0; i < anfrage6List.size(); i++) {
			dataset.addValue(null, numberOfViewers, xAxisUnits[i]);
		}
		return dataset;
	}

	protected DefaultCategoryDataset createNumberOfViewersDataSet(String[] xAxisUnits) {
		final String numberOfQueries = "Anzahl der Suchanfragen";
		final String numberOfViewers = "Anzahl der Zuschauer";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < anfrage6List.size(); i++) {
			dataset.addValue(null, numberOfQueries, xAxisUnits[i]);
		}
		for (int i = 0; i < anfrage6List.size(); i++) {
			dataset.addValue(anfrage6List.get(i).getNumberOfViewers(), numberOfViewers, xAxisUnits[i]);
		}
		return dataset;
	}
}
