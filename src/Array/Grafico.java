package Array;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame {
    public Grafico(int arraySize, long multiTElapsedTime, long singleTElapsedTime) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tempo de execução: Multithread vs Singlethread");
        setSize(500, 700);
        setLocationRelativeTo(null);

        createChart(arraySize, multiTElapsedTime, singleTElapsedTime);

        setVisible(true);
    }

    public void createChart(int arraySize, long multiTElapsedTime, long singleTElapsedTime) {

        DefaultCategoryDataset barChart = new DefaultCategoryDataset();

        barChart.setValue((float) multiTElapsedTime / 1000000, "Multithread", "");
        barChart.setValue((float) singleTElapsedTime / 1000000, "Singlethread", "");

        JFreeChart chart = ChartFactory.createBarChart("Search time in " + arraySize + " array size",
                "", "Time (ms)", barChart, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
    }
}
