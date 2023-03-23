package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    Translator translator = new Translator();

    @Test
    void getHighestDegreeMonomial() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("2x^3+x^7"));
        Polynomial test = new Polynomial();
        polynomial.orderMonomials();
        test.addMonomial(polynomial.getHighestDegreeMonomial());
        assertEquals("x^7", test.translateIntoString());
    }

    @Test
    void standardForm() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("x^1-1x^1+2x^2-3x^2+x^2+x^3"));
        polynomial.standardForm();
        assertEquals("x^3", polynomial.translateIntoString());
    }

    @Test
    void orderMonomials() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("3x^3+2x^2+7x^6+4x^8"));
        polynomial.orderMonomials();
        assertEquals("4x^8+7x^6+3x^3+2x^2", polynomial.translateIntoString());
    }

    @Test
    void testToString() throws Exception {
        Polynomial polynomial = new Polynomial(translator.stringToPolynomial("3x^3+1x^7+2x^2+7x^6+4x^8"));
        assertEquals("3x^3+x^7+2x^2+7x^6+4x^8", polynomial.translateIntoString());
    }
}