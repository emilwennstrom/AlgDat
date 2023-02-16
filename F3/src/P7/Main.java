package P7;

public class Main {
    public static void main(String[] args) throws CombEvalConvert.SyntaxErrorException {
        CombEvalConvert convert = new CombEvalConvert();
        String converted = convert.convert("10 + 10 + 10");

        System.out.println(converted);

        converted = convert.convert("4 + 3 * ");

        System.out.println(converted);
    }

}
