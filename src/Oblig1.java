public class Oblig1 {

    //Oppgave 2, metode som looper igjennom og sjekker om tabellen stiger, thrower Exception vis
    //tabellen ikke stiger. Den teller også antall ulike verdier den har i tabellen
    public static int antallUlikeSortert(int[] a) {

        boolean check = true;
        int teller=1;

        //Looper gjennom og ser om tabellen stiger
        for (int i = 0; i <a.length-1; ++i) {
            if (a[i]<a[i+1]) {
                teller++;
            }
            else if (a[i]==a[i+1]) {

            } else {
                check = false;
            }
        }

        //Kaster Exception hvis tabellen ikke er sortert
        if (!check) {
            throw new IllegalStateException("Ikke sortert");
        }
        return teller;

    }



    //Oppgave 3, metode som looper igjennom som oppgave to, men kan også ha mange like verdier stokket i en array
    //Sender heller ikke feilkode når tabellen ikke er sortert
    public static int antallUlikesortert(int[] a) {

        int teller = 0;

        //Kaster nullpointException når tabellen er lik 0
        if (a.length<1) {
            throw new NullPointerException("Tabellen er tom");
        }

        //Looper gjennom tabellen og teller antall ulike verdier
        for (int i = 0; i < a.length - 1; ++i) {

            for (int j = 0; j<a.length - 1; ++j) {
                if (a[i] != a[j]) {
                    teller++;
                }
            }
        }

        return teller;
    }

    //Oppgave 7a, fletter sammen to strenger til en felles
    public static String flett(String s, String t) {

        String flettet = "";
        int lengde = 0;

        //Bruker verdien til den lengste Stringen
        if (s.length()<t.length()) {
            lengde = t.length();
        } else {
            lengde = s.length();
        }

        //Legger verdiene annen hvergang
        for (int i = 0; i<lengde;++i) {
            if (i<s.length()) {
                flettet += s.charAt(i);
            }
            if (i<t.length()) {
                flettet += t.charAt(i);
            }
        }

        return flettet;
    }

    //Oppgave 7b, fletter sammen x antall stringer til en string
    public static String flettV2(String[] s) {
        int antallKolonner = s.length;
        int temp=3;

        for (int i = 0; i < s.length;++i) {
            if (s[i].length()<s[i+1].length()) {

                temp = s[i+1].length();
            }
        }

        String flettet = "";

        for (int i = 0; i<antallKolonner;++i) {

            for (int j = 0; j<temp-1;++j) {
                flettet += s[j].charAt(i);
            }
        }

        return flettet;

    }

    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new IllegalArgumentException("Illegal verdi");
        }
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }

        }
        return a[a.length-1];
    }

}
