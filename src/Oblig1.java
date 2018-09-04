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
