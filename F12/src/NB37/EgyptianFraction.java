package NB37;

import java.math.BigInteger;

public class EgyptianFraction {

    public static String solveFraction(BigInteger num, BigInteger denom) {
        if (denom.mod(num).equals(BigInteger.ZERO)) {
            denom = denom.divide(num);
            return 1 + "/" + denom;
        }
        BigInteger greatestSubtract = denom.divide(num).add(BigInteger.ONE);
        BigInteger commonDivisor = greatestSubtract.multiply(denom);  // gemensam nämnare mellan start och denom
        num = num.multiply(greatestSubtract).subtract(denom);                  // num förlängs med start och reduceras
        return 1 + "/" + greatestSubtract + " + " + solveFraction(num, commonDivisor);
    }
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(5);
        BigInteger denom = BigInteger.valueOf(121);
        System.out.println(num + "/" + denom + " = " + solveFraction(num, denom));
    }
}
