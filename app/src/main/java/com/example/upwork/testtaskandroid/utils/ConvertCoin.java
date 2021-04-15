package com.example.upwork.testtaskandroid.utils;

import java.util.Locale;

public class ConvertCoin {

    public static String convertСapitalization(Double count) {
        Double delT = count / 1_000_000_000_000.0;
        Double delM = count / 1_000_000_000;

        if (count >= 0. && count < 1_000.) {
            return String.format(Locale.US, "%.2f", delM);
        } else if (count >= 1_000. && count < 1_000_000.) {
            return String.format(Locale.US, "%.2f", delM) + "K";
        } else if (count >= 1_000_000. && count < 1_000_000_000.) {
            return String.format(Locale.US, "%.2f", delM) + "M";
        } else if (count >= 1_000_000_000. && count < 1_000_000_000_000.) {
            return String.format(Locale.US, "%.2f", delM) + "B";
        } else if (count >= 1_000_000_000_000. && count <= 1_000_000_000_000_000.) {
            return String.format(Locale.US, "%.2f", delT) + "T";
        }
        return "a lot of";
    }
}
