package ro.tu.pt2022_30423_chete_doru_assignment_1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ro.tu.pt2022_30423_chete_doru_assignment_1.model.Monomial;
import ro.tu.pt2022_30423_chete_doru_assignment_1.model.Operation;
import ro.tu.pt2022_30423_chete_doru_assignment_1.model.Polynomial;
import ro.tu.pt2022_30423_chete_doru_assignment_1.model.Translator;

public class Controller {
    private Operation operation = new Operation();
    private Translator translator = new Translator();
    @FXML private TextField polynomial1;
    @FXML private TextField polynomial2;
    @FXML private Label result;

    @FXML
    private void addOperation() throws Exception {
        Polynomial firstPolynomial = new Polynomial(translator.stringToPolynomial(polynomial1.getText()));
        Polynomial secondPolynomial = new Polynomial(translator.stringToPolynomial(polynomial2.getText()));
        firstPolynomial.standardForm();
        secondPolynomial.standardForm();

        Polynomial sum = operation.addition(firstPolynomial, secondPolynomial);
        sum.standardForm();
        sum.orderMonomials();

        print(sum);
    }

    @FXML
    private void subtractOperation() throws Exception {
        Polynomial firstPolynomial = new Polynomial(translator.stringToPolynomial(polynomial1.getText()));
        Polynomial secondPolynomial = new Polynomial(translator.stringToPolynomial(polynomial2.getText()));
        firstPolynomial.standardForm();
        secondPolynomial.standardForm();

        Polynomial difference = operation.subtraction(firstPolynomial, secondPolynomial);
        difference.standardForm();
        difference.orderMonomials();

        print(difference);
    }

    @FXML
    public void multiplicationOperation() throws Exception {
        Polynomial firstPolynomial = new Polynomial(translator.stringToPolynomial(polynomial1.getText()));
        Polynomial secondPolynomial = new Polynomial(translator.stringToPolynomial(polynomial2.getText()));
        firstPolynomial.standardForm();
        secondPolynomial.standardForm();

        Polynomial product = operation.multiplication(firstPolynomial, secondPolynomial);
        product.standardForm();
        product.orderMonomials();

        print(product);
    }

    @FXML
    public void differentiateOperation() throws Exception {
        Polynomial firstPolynomial = new Polynomial(translator.stringToPolynomial(polynomial1.getText()));
        firstPolynomial.standardForm();

        Polynomial derivative = operation.differentiate(firstPolynomial);
        derivative.standardForm();
        derivative.orderMonomials();

        print(derivative);
    }

    @FXML
    public void integrateOperation() throws Exception {
        Polynomial firstPolynomial = new Polynomial(translator.stringToPolynomial(polynomial1.getText()));
        firstPolynomial.standardForm();

        Polynomial primitive = operation.integrate(firstPolynomial);
        primitive.standardForm();
        primitive.orderMonomials();

        printAntiderivative(primitive);
        result.setText(result.getText() + " + C");
    }

    @FXML
    public void divideOperation() throws Exception {
        Polynomial firstPolynomial = new Polynomial(translator.stringToPolynomial(polynomial1.getText()));
        Polynomial secondPolynomial = new Polynomial(translator.stringToPolynomial(polynomial2.getText()));
        firstPolynomial.standardForm();
        secondPolynomial.standardForm();

        if((firstPolynomial.getMonomials().get(0).getDegree() == 0) || secondPolynomial.getMonomials().isEmpty()) {
            // invalid input
            result.setText("Invalid input");
        }
        else {
            Polynomial quotient = operation.divide(firstPolynomial, secondPolynomial)[0];
            Polynomial remainder = operation.divide(firstPolynomial, secondPolynomial)[1];

            result.setText("Quotient: " + polynomialToString(quotient) + ", Remainder: " + polynomialToString(remainder));
        }
    }

    @FXML
    private String polynomialToString(Polynomial polynomial) {
        StringBuilder stringToBePrinted = new StringBuilder();
        int i = 0;
        for(Monomial monomial: polynomial.getMonomials()) {
            if(monomial.getCoeff() > 0 && i != 0) {
                stringToBePrinted.append("+");
            }
            if(!(monomial.getCoeff() == 1)) {
                if((monomial.getCoeff() % 1) == 0) {
                    stringToBePrinted.append(String.valueOf((int)monomial.getCoeff()));
                }
                else {
                    stringToBePrinted.append(String.valueOf(monomial.getCoeff()));
                }
            }
            else {
                if(monomial.getCoeff() == -1) {
                    stringToBePrinted.append("-");
                }
            }
            stringToBePrinted.append("x^");
            stringToBePrinted.append(String.valueOf(monomial.getDegree()));
            i ++;
        }
        return stringToBePrinted.toString();
    }

    @FXML
    private void print(Polynomial polynomial) {
        StringBuilder stringToBePrinted = new StringBuilder();
        int i = 0;
        for(Monomial monomial: polynomial.getMonomials()) {
            if(monomial.getCoeff() > 0 && i != 0) {
                stringToBePrinted.append("+");
            }
            if(!(monomial.getCoeff() == 1)) {
                if((monomial.getCoeff() % 1) == 0) {
                    stringToBePrinted.append(String.valueOf((int)monomial.getCoeff()));
                }
                else {
                    stringToBePrinted.append(String.valueOf(monomial.getCoeff()));
                }
            }
            else {
                if(monomial.getCoeff() == -1) {
                    stringToBePrinted.append("-");
                }
            }
            stringToBePrinted.append("x^");
            stringToBePrinted.append(String.valueOf(monomial.getDegree()));
            i ++;
        }
        if(stringToBePrinted.toString().equals("")) {
            result.setText("0");
        }
        else {
            result.setText(stringToBePrinted.toString());
        }
    }

    @FXML
    private void printAntiderivative(Polynomial polynomial) {
        StringBuilder stringToBePrinted = new StringBuilder();
        int i = 0;
        for(Monomial monomial: polynomial.getMonomials()) {
            if(monomial.getCoeff() > 0 && i != 0) {
                stringToBePrinted.append("+");
            }
            if(!(monomial.getCoeff() == 1)) {
                if((monomial.getCoeff() % 1) == 0) {
                    stringToBePrinted.append(String.valueOf((int)monomial.getCoeff()));
                }
                else {
                    stringToBePrinted.append(String.valueOf(monomial.getCoeff()));
                }
            }
            else {
                if(monomial.getCoeff() == -1) {
                    stringToBePrinted.append("-");
                }
            }
            if(monomial.getDegree() == 0) {
                stringToBePrinted.append("ln|x|");
            }
            else {
                stringToBePrinted.append("x^");
                stringToBePrinted.append(String.valueOf(monomial.getDegree()));
            }
            i ++;
        }
        if(stringToBePrinted.toString().equals("")) {
            result.setText("0");
        }
        else {
            result.setText(stringToBePrinted.toString());
        }
    }


}