package csu.csci325;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

public class PieChart extends Application {

    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Expenses by Category");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new javafx.scene.chart.PieChart.Data("Grapefruit", 13),
                        new javafx.scene.chart.PieChart.Data("Oranges", 25),
                        new javafx.scene.chart.PieChart.Data("Plums", 10),
                        new javafx.scene.chart.PieChart.Data("Pears", 22),
                        new javafx.scene.chart.PieChart.Data("Apples", 30));
        final javafx.scene.chart.PieChart chart = new javafx.scene.chart.PieChart(pieChartData);
        chart.setTitle("Expenses by Category");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}