package com.arreglatech.project.utils.time;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WaitUtil
{

    public static void stopFor(long time){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
