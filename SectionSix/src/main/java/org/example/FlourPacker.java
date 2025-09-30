package org.example;

public class FlourPacker {

    public static int kilosPerBigCount = 5;
    public static int  kilosPerSmallCount = 1;
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        boolean canPack = false;
        int smallCountUsed = 0;
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;
        int bigCountWeight = bigCount * kilosPerBigCount;
        int smallCountWeight = smallCount * kilosPerSmallCount;
        int totalWeight =  bigCountWeight + smallCountWeight;
        if (totalWeight < goal) return false;

        while (smallCountUsed <= smallCount) {
            totalWeight = bigCountWeight + smallCountUsed *  kilosPerSmallCount;
            if  (totalWeight == goal) {
                canPack = true;
                break;
            }
            smallCountUsed++;
        }
        return canPack;
    }
}
