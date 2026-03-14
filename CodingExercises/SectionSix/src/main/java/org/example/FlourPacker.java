package org.example;

public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        boolean canPack = false;
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;
        int kilosPerBigBag = 5, kilosPerSmallBag = 1;
        int kilosBigBag = kilosPerBigBag * bigCount, kilosSmallBag = kilosPerSmallBag * smallCount;
        if (goal > kilosBigBag + kilosSmallBag) return false;

        outer:
        for(int bigKilo = 0; bigKilo <= kilosBigBag; bigKilo+=kilosPerBigBag) {
            for (int smallKilo = 0; smallKilo <= kilosSmallBag; smallKilo++) {
                if (bigKilo + smallKilo == goal) {
                    canPack = true;
                    break outer;
                }
            }
        }
        return canPack;
    }
}
