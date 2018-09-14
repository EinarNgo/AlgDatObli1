
import java.lang.reflect.Array;
import java.util.Arrays;

// Tommy Gabrielsen - s320884

import java.util.NoSuchElementException;

public class Oblig1 {

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

    //Oppgave 2, metode som looper igjennom og sjekker om tabellen stiger, thrower Exception vis
    //tabellen ikke stiger. Den teller også antall ulike verdier den har i tabellen
    public static int antallUlikeSortert(int[] a) {

        boolean check = true;
        int teller=0;

        //legger til en verdi på teller hvis arrayed ikke er null
        if (a.length!=0) {
            teller++;
        }

        //Looper gjennom arrayed og legger til verdier hvis de er ulike og ser om tabellen stiger
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


    //Oppgave 3, metode som looper igjennom arrayed og teller hvor mange ulike verdier, tabellen er usortert
    public static int antallUlikeUsortert(int[] a) {

        int teller = 0;
        boolean check;

        //Looper gjennom tabellen og teller antall ulike verdier
        for (int i = 0; i < a.length; ++i) {
            //Ekstra boolean for sjekke om tallet er likt
            check = false;
            for (int j = 0; j<i; ++j) {

                if (a[i] == a[j]) {
                    check = true;
                    break;
                }
            }
            //Legger til verdi hvis checken var true
            if (!check) {
                teller++;
            }
        }

        return teller;
    }

    //oppgave 4
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
            kvikksortering1(a, 0, a.length-1);
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


    // Oppgave 5
    public static void rotasjon(char[] a) {
        if (a.length <= 0 || a == null) return;

        char temp = a[a.length-1];

        for (int i = a.length-2; i >= 0; i--) {
            a[i+1] = a[i];
        }
        a[0] = temp;
    }

    // Oppgave 6
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

        //sjekker om den er tom
        if (s.length!=0) {
            int lengde = s[0].length();

            //finner den lengste verdien
            for (int i = 0; i<s.length-1; ++i) {

                if (s[i].length()<=s[i+1].length()) {
                    lengde += s[i+1].length();
                }
            }

            //dobbel forløkke til å legge til verdi fra hver streng til alle strengene er tomme
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

        //kompierer hovedarrayed
        for (int i=0; i < a.length; ++i) {
            temp[i] = a[i];
        }

        bubblesort(temp);                               //Sorterer tabellen med bubblesort

        //Gir Arrayed indeksene sammenlignet med hovedtabellen
        for (int i = 0; i<a.length; ++i) {
            for (int j = 0; j < a.length; ++j) {

                if (temp[i] == a[j]) {
                    indeks[i] = j;
                }
            }
        }

        return indeks;
    }

    //oppgave 9 finne de tre minste verdiene og returner indeksen på de
    public static int[] tredjeMin(int[] a) {

        //Sjekker om de har mer enn 3 elementer
        if (a.length <3) {
            throw new NoSuchElementException("Tabellen inneholder ikke nok verdier. OutOfBoundException");
        }

        //Lager hjelpetabell
        int[] b = new int[3];

        //Kopierer de tre første verdiene
        for (int i = 0; i < b.length; ++i) {
            b[i] = a[i];
        }

        //Sorterer de tre første verdiene for å vite hvem som er minst
        int[] indeks = indekssortering(b);


        //Gir m,nm,tm verdier etter synkende rekkefølge
        int m = b[indeks[0]];
        int nm = b[indeks[1]];
        int tm = b[indeks[2]];


        //Sammenligner, starter på 3 siden vi vet allerede de tre første verdiene
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

        //Siden vi kun fant hva som er minst i forrige loop, må vi sammenligne og finne hvilken indeks de lå på
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

    // oppgave 10
    public static boolean inneholdt(String a, String b) {

        // Lagrer strengene som char array, da kan vi sortere over dem
        char[] stringA = a.toCharArray();
        char[] stringB = b.toCharArray();

        // bruker en quicksort for char arrays
        kvikksorteringChar(stringA,0, stringA.length-1);
        kvikksorteringChar(stringB, 0, stringB.length-1);


        return inklusjon(stringA, stringB);


        // return false;
    }

    //Hentet fra læreboka og notat
    public static void bubblesort(int[] a) {
        for (int i = 0; i<a.length; ++i) {
            bubble(a);
        }
    }

    //Hentet fra læreboka og notat
    public static void bubble(int[] a) {
        for (int i = 0; i<a.length-1; ++i) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
    }

    /* Tommy sine egene metoder, og metoder fra boka.

     */

    // skrevet om fra laerebok
    public static boolean inklusjon(char[] a, char[] b, int c, int d) {
        int i = 0;
        int j = 0;

        while (i < c && j < d) {
            if (a[i] > b[j]) {
                j++;
        } else if (a[i] == b[j]) {
                i++;
                j++;
            } else if (a[i] < b[j]) {
                return false;
            }
        }
        if (i < c) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean inklusjon(char[] a, char[] b) {
        return inklusjon(a, b, a.length, b.length);
    }

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

    // bytter char verdi
    public static void byttChar(char[] a, int fra, int til) {
        char temp = a[fra];
        a[fra] = a[til];
        a[til] = temp;
    }

    // Siden den andre kvikksort ikke klarte mer enn 1000 elementer, brukes denne
    public static void kvikksorteringChar(char[] a, int fra, int til) {
        // Vi har ikke noe arbeid å gjore, saa vi returnerer
        if (a == null || a.length == 0) {
            return;
        }
        // Vi har ikke noe arbeid å gjore, saa vi returnerer
        if (fra >= til) {
            return;
        }

        // formel for midtpunkt
        int midtpunkt = fra + (til - fra) / 2;
        // finner verdi til midtpunkt
        int skilleverdi = a[midtpunkt];

        int i = fra;
        int j = til;

        // itererer
        while (i <= j) {
            // verdier som er mindre enn skilleverdi
            while (a[i] < skilleverdi) {
                i++;
            }
            // verdier som er storre enn skilleverdi
            while (a[j] > skilleverdi) {
                j--;
            }

            if (i <= j) {
                byttChar(a, i, j);
                i++;
                j--;
            }
        }

        // rekursive kall
        if (fra < til) {
            kvikksorteringChar(a, fra, j);
        }
        if (til > fra) {
            kvikksorteringChar(a,i,til );
        }
    }



}
