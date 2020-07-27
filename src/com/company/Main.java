package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));    // Zastosowałem BufferedReader z powodu przekraczania limitu czasu
        String s;
        ArrayList<String> lines = new ArrayList<>();
        while ((s = r.readLine()) != null) {
            lines.add(s);
        }

        int line = 0;
        int t = Integer.valueOf(lines.get(line));   // liczba testow
        line++;

        for (int i = 0; i < t; i++) {
            int v = Integer.valueOf(lines.get(line));   // smiertelna predkosc jablka
            line++;
            int n = Integer.valueOf(lines.get(line));   // libcza mieszkancow
            line++;
            int a[] = new int[n];
            int b[] = new int[n];
            int c[] = new int[n];
            for (int i2 = 0; i2 < n; i2++) {
                String bufor[] = lines.get(line).split(" ");
                line++;
                a[i2] = Integer.valueOf(bufor[0]);       // wzrost
                b[i2] = Integer.valueOf(bufor[1]);       // wiek
                c[i2] = Integer.valueOf(bufor[2]);       // wsp. wzrostu
            }

            // wysokosc z jakiej spadek jablka spowoduje smierc
            int h = ((v * v) * 5);  //wysokosc w cm
            // h = ((v*v)/20)*100

            int minWzrost;
            int maxWysokoscDrzewa;
            for (int i2 = 0; i2 <= 20; i2++) {       // obliczenia na nastepne 20 lat
                minWzrost = 9999;
                for (int i3 = 0; i3 < n; i3++) {    // dla kazdego mieszkanca
                    if (b[i3] <= 20 && i2 > 0) {     // inkrementuj wzrost jezeli mieszkaniec ma mniej niz 20 lat, pomin pierwsza petle 0
                        a[i3] += c[i3];
                    }

                    if (a[i3] < minWzrost) {   // najnizszy czlowiek
                        minWzrost = a[i3];
                    }
                    b[i3]++;    // inkrementacja wieku mieszkańca
                }
                maxWysokoscDrzewa = minWzrost + h;
                System.out.println(i2 + ": " + maxWysokoscDrzewa);
            }
        }
    }
}
