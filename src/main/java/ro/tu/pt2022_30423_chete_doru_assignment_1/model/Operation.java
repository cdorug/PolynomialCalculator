package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

public class Operation {

    public Polynomial addition(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial sum = new Polynomial();
        for(Monomial monomial : firstPolynomial.getMonomials()) {
            Monomial monomialFromFirstPolynomial = new Monomial(monomial.getCoeff(), monomial.getDegree());
            sum.addMonomial(monomialFromFirstPolynomial);
        }
        for(Monomial monomial : secondPolynomial.getMonomials()) {
            Monomial monomialFromSecondPolynomial = new Monomial(monomial.getCoeff(), monomial.getDegree());
            sum.addMonomial(monomialFromSecondPolynomial);
        }
        return sum;
    }

    public Polynomial subtraction(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial difference = new Polynomial();
        for(Monomial monomial : firstPolynomial.getMonomials()) {
            Monomial monomialFromFirstPolynomial = new Monomial(monomial.getCoeff(), monomial.getDegree());
            difference.addMonomial(monomialFromFirstPolynomial);
        }
        for(Monomial monomial : secondPolynomial.getMonomials()) {
            Monomial monomialFromSecondPolynomial = new Monomial(-monomial.getCoeff(), monomial.getDegree());
            difference.addMonomial(monomialFromSecondPolynomial);
        }
        return difference;
    }

    public Polynomial multiplication(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial product = new Polynomial();
        for(Monomial monomial1 : firstPolynomial.getMonomials()) {
            for(Monomial monomial2 : secondPolynomial.getMonomials()) {
                Monomial monomialProduct = new Monomial();
                monomialProduct.setDegree(monomial1.getDegree() + monomial2.getDegree());
                monomialProduct.setCoeff(monomial1.getCoeff() * monomial2.getCoeff());
                product.addMonomial(monomialProduct);
            }
        }
        return product;
    }

    public Polynomial differentiate(Polynomial polynomial) {
        Polynomial derivative = new Polynomial();
        for(Monomial monomial : polynomial.getMonomials()) {
            Monomial differentiatedMonomial = new Monomial();
            differentiatedMonomial.setCoeff(monomial.getCoeff() * monomial.getDegree());
            differentiatedMonomial.setDegree(monomial.getDegree() - 1);
            if(differentiatedMonomial.getDegree() != 0) {
                derivative.addMonomial(differentiatedMonomial);
            }
        }
        return derivative;
    }

    public Polynomial integrate(Polynomial polynomial) {
        Polynomial primitive = new Polynomial();
        for(Monomial monomial : polynomial.getMonomials()) {
            Monomial integratedMonomial = new Monomial();
            if(monomial.getDegree() == -1) {
                integratedMonomial.setCoeff(monomial.getCoeff());
                integratedMonomial.setDegree(0);
            }
            else {
                integratedMonomial.setCoeff(monomial.getCoeff() / (monomial.getDegree() + 1));
                integratedMonomial.setDegree(monomial.getDegree() + 1);
            }
            primitive.addMonomial(integratedMonomial);
        }
        return primitive;
    }

    public Polynomial[] divide(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        // here it is assumed firstPolynomial > secondPolynomial, i.e. firstPolynomial / secondPolynomial
        // it is also assumed parameters are already in the standard form, and zeroes have been eliminated
        Polynomial quotient = new Polynomial(); // initialize quotient to 0
        Polynomial remainder = firstPolynomial.copyPolynomial(); // initialize remainder to dividend
        while((!remainder.getMonomials().isEmpty()) && remainder.getHighestDegreeMonomial().getDegree() >= secondPolynomial.getHighestDegreeMonomial().getDegree()) {
            double coeff = remainder.getHighestDegreeMonomial().getCoeff() / secondPolynomial.getHighestDegreeMonomial().getCoeff();
            int degree = remainder.getHighestDegreeMonomial().getDegree() - secondPolynomial.getHighestDegreeMonomial().getDegree();
            Monomial dividedMonomial = new Monomial(coeff, degree);
            Polynomial dividedMonomialAsPolynomial = new Polynomial();
            dividedMonomialAsPolynomial.addMonomial(dividedMonomial);
            quotient.addMonomial(dividedMonomial);
            Polynomial product = multiplication(dividedMonomialAsPolynomial, secondPolynomial);
            product.standardForm();
            product.orderMonomials();
            remainder = subtraction(remainder, product);
            remainder.standardForm();
            remainder.orderMonomials();
        }
        Polynomial[] quotientAndRemainder = new Polynomial[2];
        quotientAndRemainder[0] = quotient;
        quotientAndRemainder[1] = remainder;
        return quotientAndRemainder;
    }

}
