package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Monomial> monomials = new ArrayList<>();

    public Polynomial(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

    public Polynomial() {
    }

    public void setMonomials(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void addMonomial(Monomial monomial) {
        monomials.add(monomial);
    }

    public Monomial getHighestDegreeMonomial() {
        return this.getMonomials().get(0);
    }

    public Polynomial copyPolynomial() {
        Polynomial copiedPolynomial = new Polynomial();
        for(Monomial monomial: this.monomials) {
            Monomial copiedMonomial = new Monomial(monomial.getCoeff(), monomial.getDegree());
            copiedPolynomial.addMonomial(copiedMonomial);
        }
        return copiedPolynomial;
    }

    public void standardForm() {
        Polynomial reducedPolynomial = new Polynomial();
        for(Monomial monomial1: monomials) {
            boolean isInReducedPolynomial = false;
            for(Monomial monomial2: reducedPolynomial.monomials) {
                if(monomial1.getDegree() == monomial2.getDegree()) {
                    isInReducedPolynomial = true;
                    monomial2.setCoeff(monomial1.getCoeff() + monomial2.getCoeff());
                }
            }
            if(!isInReducedPolynomial) {
                Monomial reducedMonomial = new Monomial(monomial1.getCoeff(), monomial1.getDegree());
                reducedPolynomial.addMonomial(reducedMonomial);
            }
        }
        ArrayList<Monomial> zeroCoeffMonomials = new ArrayList<>();
        for(Monomial monomial: reducedPolynomial.monomials) {
            if(monomial.getCoeff() == 0){
                zeroCoeffMonomials.add(monomial);
            }
        }
        reducedPolynomial.monomials.removeAll(zeroCoeffMonomials);
        monomials = reducedPolynomial.monomials;
    }

    public void orderMonomials() {
        Monomial auxMonomial = new Monomial();
        for(Monomial monomial1 : monomials) {
            for(Monomial monomial2: monomials) {
                if(monomial2.getDegree() < monomial1.getDegree()) {
                    auxMonomial.setDegree(monomial1.getDegree());
                    auxMonomial.setCoeff(monomial1.getCoeff());
                    monomial1.setDegree(monomial2.getDegree());
                    monomial1.setCoeff(monomial2.getCoeff());
                    monomial2.setDegree(auxMonomial.getDegree());
                    monomial2.setCoeff(auxMonomial.getCoeff());
                }
            }
        }
    }

    public String translateIntoString() {
        StringBuilder stringToBePrinted = new StringBuilder();
        int i = 0;
        for(Monomial monomial: this.getMonomials()) {
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

}
