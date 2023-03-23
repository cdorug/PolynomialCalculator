package ro.tu.pt2022_30423_chete_doru_assignment_1.model;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Translator {

    Pattern p = Pattern.compile( "(-?\\b\\d?+)[xX]\\^(-?\\d+\\b)" );


    public ArrayList<Monomial> stringToPolynomial(String Polynomial) throws Exception {
        ArrayList<Monomial> translatedPolynomial = new ArrayList<Monomial>();
        int degree;
        double coeff;
        Matcher m = p.matcher(Polynomial);
        while(m.find()) {
            if(m.group(1).equals("")) {
                coeff = 1;
            }
            else if(m.group((1)).equals("-")) {
                coeff = -1;
            }
            else {
                coeff = Integer.parseInt(m.group(1));
            }
            degree = Integer.parseInt(m.group(2));
            translatedPolynomial.add(new Monomial(coeff, degree));
        }
        return translatedPolynomial;
    }

    public boolean checkStringInput(String string) throws Exception {
        try {
            for(char c: string.toCharArray()) {
                if(!(c == 'x' || c == 'X') && !(c >= '0' && c <= '9') && !(c == '^' || c == '+' || c == '-')) {
                    throw new Exception("Incorrect input");
                }
            }
            return true;
        }
        catch(Exception exception) {
            return false;
        }
    }
}
