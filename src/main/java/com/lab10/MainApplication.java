package com.lab10;

import com.lab10.models.Quadrilateral;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

public class MainApplication extends Application {

    private TableView<Quadrilateral> table = new TableView<Quadrilateral>();
    private final ObservableList<Quadrilateral> data =
        FXCollections.observableArrayList(
            new Quadrilateral(5,6,3,2,7,4,6,7),
            new Quadrilateral(3,5,1,5,7,3,5,3),
            new Quadrilateral(7,3,1,4,2,4,5,6),
            new Quadrilateral(3,1,4,3,8,3,3,5)
        );

    final HBox hb1 = new HBox();
    final HBox hb2 = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lab10");
        stage.setWidth(436);
        stage.setHeight(550);

        final Label label = new Label("Quadrilaterals");
        label.setFont(new Font("Arial", 20));

        table.setPrefWidth(400);
        table.setEditable(true);

        TableColumn<Quadrilateral, Double> x1Col = new TableColumn<Quadrilateral, Double>("X1");
        x1Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("x1"));
        x1Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        x1Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setX1(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> y1Col = new TableColumn<Quadrilateral, Double>("Y1");
        y1Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("y1"));
        y1Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        y1Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setY1(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> x2Col = new TableColumn<Quadrilateral, Double>("X2");
        x2Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("x2"));
        x2Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        x2Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setX2(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> y2Col = new TableColumn<Quadrilateral, Double>("Y2");
        y2Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("y2"));
        y2Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        y2Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setY2(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> x3Col = new TableColumn<Quadrilateral, Double>("X3");
        x3Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("x3"));
        x3Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        x3Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setX3(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> y3Col = new TableColumn<Quadrilateral, Double>("Y3");
        y3Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("y3"));
        y3Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        y3Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setY3(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> x4Col = new TableColumn<Quadrilateral, Double>("X4");
        x4Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("x4"));
        x4Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        x4Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setX4(event.getNewValue());
            }
        });

        TableColumn<Quadrilateral, Double> y4Col = new TableColumn<Quadrilateral, Double>("Y4");
        y4Col.setCellValueFactory(new PropertyValueFactory<Quadrilateral, Double>("y4"));
        y4Col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        y4Col.setOnEditCommit(new EventHandler<CellEditEvent<Quadrilateral, Double>>() {
            @Override
            public void handle(CellEditEvent<Quadrilateral, Double> event) {
                Quadrilateral quadrilateral = event.getRowValue();
                quadrilateral.setY4(event.getNewValue());
            }
        });

        table.setItems(data);
        table.getColumns().addAll(x1Col, y1Col, x2Col, y2Col, x3Col, y3Col, x4Col, y4Col);

        final TextField addX1 = new TextField();
        addX1.setPromptText("x1");
        addX1.setMaxWidth(x1Col.getPrefWidth());

        final TextField addY1 = new TextField();
        addY1.setPromptText("y1");
        addY1.setMaxWidth(y1Col.getPrefWidth());

        final TextField addX2 = new TextField();
        addX2.setPromptText("x2");
        addX2.setMaxWidth(x2Col.getPrefWidth());
        final TextField addY2 = new TextField();
        addY2.setPromptText("y2");
        addY2.setMaxWidth(y2Col.getPrefWidth());

        final TextField addX3 = new TextField();
        addX3.setPromptText("x3");
        addX3.setMaxWidth(x3Col.getPrefWidth());
        final TextField addY3 = new TextField();
        addY3.setPromptText("y3");
        addY3.setMaxWidth(y3Col.getPrefWidth());

        final TextField addX4 = new TextField();
        addX4.setPromptText("x4");
        addX4.setMaxWidth(x4Col.getPrefWidth());
        final TextField addY4 = new TextField();
        addY4.setPromptText("y4");
        addY4.setMaxWidth(y4Col.getPrefWidth());

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Quadrilateral(
                        Double.parseDouble(addX1.getText()),
                        Double.parseDouble(addY1.getText()),
                        Double.parseDouble(addX2.getText()),
                        Double.parseDouble(addY2.getText()),
                        Double.parseDouble(addX3.getText()),
                        Double.parseDouble(addY3.getText()),
                        Double.parseDouble(addX4.getText()),
                        Double.parseDouble(addY4.getText())
                        ));
                    addX1.clear();
                    addY1.clear();
                    addX2.clear();
                    addY2.clear();
                    addX3.clear();
                    addY3.clear();
                    addX4.clear();
                    addY4.clear();
            }
        });

        hb1.getChildren().addAll(addX1, addY1, addX2, addY2);
        hb1.setSpacing(3);

        hb2.getChildren().addAll(addX3, addY3, addX4, addY4, addButton);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb1, hb2);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}