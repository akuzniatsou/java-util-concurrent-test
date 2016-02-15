package util;

import java.util.Random;

/**
 * Created by Andrei Kuzniatsou on 15.02.2016.
 */
public class GeneratingUtil {

    private static Random generator = new Random();

    public static long getValueFromRange(int start, int end) {
        end++;
        return (long) (generator.nextInt(end - start) + start);
    }


}
