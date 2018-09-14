import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {


    //Oppgave 2, metode som looper igjennom og sjekker om tabellen stiger, thrower Exception vis
    //tabellen ikke stiger. Den teller også antall ulike verdier den har i tabellen
    public static int antallUlikeSortert(int[] a) {


        boolean check = true;
        int teller=0;

        if (a.length!=0) {
            teller++;
        }

        //Looper gjennom og ser om tabellen stiger
        for (int i = 0; i <a.length-1; ++i) {
            if (a[i] != a[i+1]) {
                teller++;
            }
            if (a[i] > a[i+1]) {
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
        boolean check;

        //Looper gjennom tabellen og teller antall ulike verdier
        for (int i = 0; i < a.length; ++i) {
            check = false;
            for (int j = 0; j<i; ++j) {

                if (a[i] == a[j]) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                teller++;
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
    public static String flett(String... s) {
        String flettet = "";

        if (s.length!=0) {
            int lengde = s[0].length();

            for (int i = 0; i<s.length-1; ++i) {

                if (s[i].length()<=s[i+1].length()) {
                    lengde += s[i+1].length();
                }
            }

            for (int i = 0; i < lengde; ++i) {

                for (int j = 0; j < s.length; ++j) {
                    if (s[j].length() > i) {
                        flettet += s[j].charAt(i);
                    }

                }
            }
        }

        return flettet;

    }

    //oppgave 8, sortering med indeks
    public static int[] indekssortering(int[] a) {

        int[] temp = new int[a.length];                 //Lager en hjelpetabell
        int[] indeks = new int[a.length];

        for (int i=0; i < a.length; ++i) {
            temp[i] = a[i];
        }

        bubblesort(temp);                               //Sorterer tabellen med bubblesort

        for (int i = 0; i<a.length; ++i) {
            for (int j = 0; j < a.length; ++j) {

                if (temp[i] == a[j]) {
                    indeks[i] = j;
                }
            }
        }

        return indeks;
    }

    //oppgave 9, finne indeksene til de tre minste verdiene i tabellen og opprett hjelpetabell som viser det
    //skal ikke ha en fullstendig sortering siden den vil gjøre algoritmen tregere og skape bug
    //Punkt 2. skal kase Exception hvis tabellen er kortere enn 3 verdier eller tabellen inneholder ugyldige verdier
    //Hjelpetabellen skal vise verdien til den minste først og i stiffende rekkefølge.

    public static int[] tredjeMin(int[] a) {

        if (a.length <3) {
            throw new NoSuchElementException("Tabellen inneholder ikke nok verdier. OutOfBoundException");
        }

        int[] b = new int[3];

        for (int i = 0; i < b.length; ++i) {
            b[i] = a[i];
        }

        int[] indeks = indekssortering(b);

        /*
        a[0] = b[indeks[0]];
        a[1] = b[indeks[1]];
        a[2] = b[indeks[2]];

        int m = a[0];
        int nm = a[1];
        int tm = a[2];
        */

        int m = b[indeks[0]];
        int nm = b[indeks[1]];
        int tm = b[indeks[2]];


        for (int i = 3; i < a.length; ++i) {
            int tmp = a[i];

            if (tmp<tm) {
                tm = a[i];
                if (tmp<nm) {
                    tm = nm;
                    nm = a[i];
                    if (tmp<m) {
                        nm = m;
                        m = a[i];
                    }
                }
            }
        }

        for (int i = 0; i<a.length; ++i) {
            if (a[i] == tm) {
                b[2] = i;
            }
            if (a[i] == nm) {
                b[1] = i;
            }
            if (a[i] == m) {
                b[0] = i;
            }
        }

        return new int[] {b[0],b[1],b[2]};
    }

    public static void bubblesort(int[] a) {
        for (int i = 0; i<a.length; ++i) {
            bubble(a);
        }
    }

    public static void bubble(int[] a) {
        for (int i = 0; i<a.length-1; ++i) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
    }


    public static int bokstaver(String[] s) {
        int antallBokstaver = s[0].length();

        for (int i = 0; i < s.length-1;++i) {
            if (s[i].length()<s[i+1].length()) {
                antallBokstaver = s[i+1].length();
            }
        }

        return antallBokstaver;
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
