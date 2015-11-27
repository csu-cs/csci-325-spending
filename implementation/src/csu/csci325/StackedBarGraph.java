package csu.csci325;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Created by N'dia on 11/26/2015.
 */
public class StackedBarGraph extends Application {
    final static String income = "Income";
    final static String expenses = "Expenses";
    final CategoryAxis yAxis = new CategoryAxis();
    final NumberAxis xAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc = new StackedBarChart<String, Number>(yAxis, xAxis);
    XYChart.Series<String, Number> ex =
            new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> in =
            new XYChart.Series<String, Number>();

    @Override
    public void start(Stage stage){
        xAxis.setLabel("Amount");
        yAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(income)));

        ex.setName("Expenses");
        in.setName("Income");
        ex.getData().add(new XYChart.Data<>(income, 300));
        in.getData().add(new XYChart.Data<>(income,500));

        Scene scene = new Scene(sbc);
        sbc.getData().addAll(ex,in);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
