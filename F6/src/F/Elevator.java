package F;

public class Elevator {


    static int antalResor(int n, int upp, int ner, int position, int destination, int antalResor) {
        if (position == destination ) {
            return antalResor;
        } else if (antalResor > 30) {
            return Integer.MAX_VALUE;
        } else  {
            int antalUpp = Integer.MAX_VALUE, antalNed = Integer.MAX_VALUE;
            if (position + upp <= n) {
                antalUpp = antalResor(n, upp, ner, position + upp, destination, antalResor + 1);
            }
            if (position - ner >= 1) {
                antalNed =  antalResor(n, upp, ner, position - ner, destination, antalResor + 1);
            }
            return Math.min(antalUpp, antalNed);
        }
    }


    static int antalResorHiss(int n, int upp, int ned, int destination) {
        int position = 1;
        int antalResor = 0;

        return antalResor(n, upp, ned, position, destination, antalResor);

    }

    public static class Main {
        public static void main(String[] args) {
            int antal = antalResorHiss(78, 15, 8, 35);

            System.out.println(antal);
        }
    }
}
