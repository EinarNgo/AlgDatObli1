import java.util.NoSuchElementException;

public class Oblig1 {

    //Oppgave 2, metode som looper igjennom og sjekker om tabellen stiger, thrower Exception vis
    //tabellen ikke stiger. Den teller også antall ulike verdier den har i tabellen
    public static int antallUlikeUsortert(int[] a) {

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
    public static int antallUlikeSortert(int[] a) {

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
    public static String flett(String... s) {
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

    public static int[] indekssortering(int[]  a) {
        return null;
    }

    public static int[] tredjeMin(int[]  a) {
        return null;
    }

    public static int maks(int[] a) {
        // sjekker at i ikke har et tomt aray
        if (a.length < 1) {
            throw new NoSuchElementException("Illegal verdi");
        }

        // vi setter a.length-1 fordi vi vil unngaa array out of bounds,
        // naar vi skal bytte siste element.
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        // sjekker at i ikke har et tomt aray
        if (a.length < 1) {
            throw new IllegalArgumentException("Illegal verdi");
        }

        int tellerOmbytte = 0;
        // vi setter a.length-1 fordi vi vil unngaa array out of bounds,
        // naar vi skal bytte siste element.
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                ++tellerOmbytte;
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }

        return tellerOmbytte;
    }

    public static void delsortering(int[] a) {
        // Sjekker forst om array kun har ett element, eller er tomt
        if (a.length <= 1) {
            return;
        }

        // Soke index
        int left = 0;
        int right = a.length-1;

        // Finner antall oddetall/partall
        int oddetall = antOddetall(a);
        int partall = antPartall(a);

        // Hvis vi har en ren par/oddetall tabell, saa sorterer vi alt med
        // engang, saa slipper vi bruke tid paa soke/bytte index
        if (partall == 0 || oddetall == 0) {
            kvikksortering(a, 0, a.length-1);
        }

        // Siden vi skal segregere par/oddetall, er det lurt aa soke
        // fra begge sider i array. Finner vi et partall paa en side,
        // og det er oddetall paa den andre posisjonen bytter vi dem
        while (left < right) {
            while ((a[left] & 1) == 1 && left < right) {
                left++;
            }
            while ((a[right] & 1) == 0 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        // Kaller kvikksort (fra laereboka) og sorterer den ferdig segregerte
        // tabellen
        kvikksortering(a,0,oddetall);
        kvikksortering(a,oddetall, a.length);

    }

    public static boolean inneholdt(String a, String b) {

   
    }

    public static void rotasjon(char[] a) {
        if (a.length <= 0 || a == null) return;

        char temp = a[a.length-1];

        for (int i = a.length-2; i >= 0; i--) {
            a[i+1] = a[i];
        }
        a[0] = temp;
    }


    public static void rotasjon(char[] a, int d) {

        int lengde = a.length;
        if (lengde < 2) {
            return;// ingen rotasjon
        }

        // Vi sjekker her om d er negativ
        if ((d %= lengde) < 0) {
            d += lengde;
        }

        // Hvis vi har en veldig stor d, altsaa vi onsker aa rotere
        // 832 ganger, kan vi bruke gcd for aa finne hvor mange steg
        // vi skal flytte. Si at en tabell er 10 lang, og skal flyttes
        // 22 plasser, saa er det det samme som aa flytte 2 plasser.
        int s = gcd(lengde, d);

        // Bruker s vi regnet ut fra gcd
        for (int k = 0; k < s; k++) {

            // lagrer variabel middlertidlig
            char temp = a[k];

            for (int i = k - d, j = k; i != k; i -= d) { // løkke
                if (i < 0) i += lengde;                        // sjekker fortegnet til i
                a[j] = a[i]; j = i;                       // kopierer og oppdaterer j
            }

            a[k + d] = temp;                           // legger tilbake verdien
        }
    }


    /* Tommy sine egene metoder, og metoder fra boka.

     */

    // Finner antall partall i et gitt array
    public static int antPartall(int[] a) {
        int antPartall = 0;
        // Bruker bitwise & maske for aa sjekke hvert element
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 0) {
                antPartall++;
            }
        }
        return antPartall;
    }

    // Finner antall oddetall i et gitt array
    public static int antOddetall(int[] a) {
        int antOdeetall = 0;
        // Bruker bitwise & maske for aa sjekke hvert element
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 1) {
                antOdeetall++;
            }
        }
        return antOdeetall;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void bytt(int[] c, int i, int j) {
        int temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static int parter(int[] a, int v, int h, int skilleverdi) {
        while (v <= h && a[v] < skilleverdi) {
            v++;     // h er stoppverdi for v
        }
        while (v <= h && a[h] >= skilleverdi) {
            h--;    // v er stoppverdi for h
        }
        while (true) // stopper når v >= h
        {
            if (v < h) {
                bytt(a, v++, h--);          // bytter om a[v] og a[h]
            } else {
                return v;                             // partisjoneringen er ferdig
            }
            while (a[v] < skilleverdi) {
                v++;             // flytter v mot høyre
            }
            while (a[h] >= skilleverdi) {
                h--;            // flytter h mot venstre
            }
        }
    }

    public static int sParter(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);   // skilleverdi a[indeks] flyttes bakerst
        int k = parter(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
        bytt(a, k, h);       // bytter for å få skilleverdien på rett plass
        return k;                   // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering1(int[] a, int v, int h) { // en privat metode
        if (v >= h) {
            return;  // a[v:h] er tomt eller har maks ett element
        }
        int k = sParter(a, v, h, (v + h) / 2);  // bruker midtverdien
        kvikksortering1(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering1(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // fra/til i sortering
    {
        kvikksortering1(a, fra, til - 1);  // v = fra, h = til - 1
    }


}
