package frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class createGridPane extends GridPane {
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private DatePicker datePicker;
    private GridPane grid = new GridPane();
    private Button button;

    public createGridPane(Label label1, TextField textField1, Label label2, TextField textField2, Label label3, TextField textField3, Label label4, TextField textField4, Label label5, TextField textField5,Label label6,TextField textField6, Button button) {
        this.label1 = label1;
        this.textField1 = textField1;
        this.label2 = label2;
        this.textField2 = textField2;
        this.label3 = label3;
        this.textField3 = textField3;
        this.label4 = label4;
        this.textField4 = textField4;
        this.label5 = label5;
        this.textField5 = textField5;
        this.label6 = label6;
        this.textField6 = textField6;
        this.button = button;
        grid.setAlignment(Pos.CENTER); //Check
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.add(label1, 0, 0);
        grid.add(textField1, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(textField2, 1, 1);
        grid.add(label3, 0, 2);
        grid.add(textField3, 1, 2);
        grid.add(label4, 0, 3);
        grid.add(textField4, 1, 3);
        grid.add(label5, 0, 4);
        grid.add(textField5, 1, 4);
        grid.add(label6, 0, 5);
        grid.add(textField6, 1, 5);
        grid.add(button, 1, 6);
    }

    public createGridPane(Label label1, TextField textField1, Label label2, TextField textField2, Label label3, TextField textField3, Label label4, TextField textField4, Label label5, TextField textField5, Button button) {
        this.label1 = label1;
        this.textField1 = textField1;
        this.label2 = label2;
        this.textField2 = textField2;
        this.label3 = label3;
        this.textField3 = textField3;
        this.label4 = label4;
        this.textField4 = textField4;
        this.label5 = label5;
        this.textField5 = textField5;
        this.button = button;
        grid.setAlignment(Pos.CENTER); //Check
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(label1, 0, 0);
        grid.add(textField1, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(textField2, 1, 1);
        grid.add(label3, 0, 2);
        grid.add(textField3, 1, 2);
        grid.add(label4, 0, 3);
        grid.add(textField4, 1, 3);
        grid.add(label5, 0, 4);
        grid.add(textField5, 1, 4);
        grid.add(button, 1, 5);
    }

    public createGridPane(Label label1, TextField textField1, Label label2, TextField textField2, Label label3, TextField textField3, Label label4, TextField textField4, Button button) {
        this.label1 = label1;
        this.textField1 = textField1;
        this.label2 = label2;
        this.textField2 = textField2;
        this.label3 = label3;
        this.textField3 = textField3;
        this.label4 = label4;
        this.textField4 = textField4;
        this.button = button;
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(label1, 0, 0);
        grid.add(textField1, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(textField2, 1, 1);
        grid.add(label3, 0, 2);
        grid.add(textField3, 1, 2);
        grid.add(label4, 0, 3);
        grid.add(textField4, 1, 3);
        grid.add(button, 1, 4);
    }

    public createGridPane(Label label1, TextField textField1, Label label2, TextField textField2, Label label4, DatePicker datePicker, Button button) {
        this.label1 = label1;
        this.textField1 = textField1;
        this.label2 = label2;
        this.textField2 = textField2;
        this.label4 = label4;
        this.datePicker = datePicker;
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(label1, 0, 0);
        grid.add(textField1, 1, 0);
        grid.add(label2, 0, 1);
        grid.add(textField2, 1, 1);
        grid.add(label4, 0, 2);
        grid.add(datePicker, 1, 2);
        grid.add(button, 1, 3);
    }

    public GridPane getGridPane() {
        return grid;
    }
}
