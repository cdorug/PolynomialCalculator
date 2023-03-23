package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    Translator translator = new Translator();
    Operation operation = new Operation();
    @Test
    void addition() throws Exception {
        Polynomial polynomial1 = new Polynomial(translator.stringToPolynomial("3x^2+2x^6+2x^7"));
        Polynomial polynomial2 = new Polynomial(translator.stringToPolynomial("5x^2+4x^6-2x^7"));
        Polynomial sum = operation.addition(polynomial1, polynomial2);
        sum.standardForm();
        sum.orderMonomials();
        assertEquals("6x^6+8x^2", sum.translateIntoString());
    }

    @Test
    void subtraction() throws Exception {
        Polynomial polynomial1 = new Polynomial(translator.stringToPolynomial("3x^2+2x^6+2x^7"));
        Polynomial polynomial2 = new Polynomial(translator.stringToPolynomial("5x^2+4x^6-2x^7"));
        Polynomial diff = operation.subtraction(polynomial1, polynomial2);
        diff.standardForm();
        diff.orderMonomials();
        assertEquals("4x^7-2x^6-2x^2", diff.translateIntoString());
    }

    @Test
    void multiplication() throws Exception {
        Polynomial polynomial1 = new Polynomial(translator.stringToPolynomial("3x^2+2x^6"));
        Polynomial polynomial2 = new Polynomial(translator.stringToPolynomial("5x^2+4x^3"));
        Polynomial prod = operation.multiplication(polynomial1, polynomial2);
        prod.standardForm();
        prod.orderMonomials();
        assertEquals("8x^9+10x^8+12x^5+15x^4", prod.translateIntoString());
    }

    @Test
    void differentiate() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("3x^5+2x^3+x^2"));
        Polynomial derivative = operation.differentiate(polynomial);
        derivative.standardForm();
        derivative.orderMonomials();
        assertEquals("15x^4+6x^2+2x^1", derivative.translateIntoString());
    }

    @Test
    void integrate() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("2x^1+2x^0+1x^-1"));
        Polynomial antiderivative = operation.integrate(polynomial);
        antiderivative.standardForm();
        antiderivative.orderMonomials();
        assertEquals("x^2+2x^1+x^0", antiderivative.translateIntoString());
    }

    @Test
    void divide() throws Exception {
        Polynomial polynomial1 = new Polynomial(translator.stringToPolynomial("x^3-2x^2+6x^1-5x^0"));
        Polynomial polynomial2 = new Polynomial(translator.stringToPolynomial("x^2-1x^0"));
        Polynomial quotient, remainder;
        quotient = operation.divide(polynomial1, polynomial2)[0];
        remainder = operation.divide(polynomial1, polynomial2)[1];
        assertEquals("x^1-2x^0", quotient.translateIntoString());
        assertEquals("7x^1-7x^0", remainder.translateIntoString());

    }
}