package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

public class Monomial {
    private double coeff;
    private int degree;

    public Monomial() {
        this.coeff = 0;
        this.degree = 0;
    }

    public Monomial(double coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    public double getCoeff() {
        return coeff;
    }

    public int getDegree() {
        return degree;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
