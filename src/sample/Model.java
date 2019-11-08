package sample;

public class Model {

    public enum Operation {addition, subtraction, multiplication, division};

    private double firstNumber;
    private double secondNumber;
    private Operation operation;

    public double calculate (){
        if(operation==null) {
            throw new IllegalArgumentException("Missing operation!");
        }
            switch (operation){
            case addition: return firstNumber + secondNumber;
            case subtraction: return firstNumber - secondNumber;
            case multiplication: return firstNumber * secondNumber;
            case division: return firstNumber / secondNumber;
        }
        return Double.NaN;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}


