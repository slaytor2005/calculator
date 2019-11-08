package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    private Model model=new Model ();
    private boolean isNewNumber = true;
    private boolean isNewOperation = true;

    @FXML
    TextArea display;

    @FXML
    private void inputDigit(ActionEvent event) {
        String value=((Button)(event.getSource())).getText();
        if(isNewNumber) {
            display.setText("");
        }
        display.setText(display.getText()+value);
        isNewNumber=false;
    }

    @FXML
    private void inputOperation(ActionEvent event) {
        String value=((Button)(event.getSource())).getText();
        switch (value){
            case "+": model.setOperation(Model.Operation.addition); break;
            case "-": model.setOperation(Model.Operation.subtraction); break;
            case "*": model.setOperation(Model.Operation.multiplication); break;
            case "/": model.setOperation(Model.Operation.division); break;

        }
        model.setFirstNumber(Double.parseDouble(display.getText()));
        isNewOperation=true;
        isNewNumber=true;
    }

    @FXML
    private void inputResult() {
        double value = Double.parseDouble(display.getText());
        if (isNewOperation) {
            model.setSecondNumber(value);
        } else {
            model.setFirstNumber(value);
        }
        display.setText(String.valueOf(model.calculate()));
        isNewOperation=false;
        isNewNumber = true;

    }
}

