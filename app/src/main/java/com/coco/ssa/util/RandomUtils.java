package com.coco.ssa.util;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author yangbo
 *  @qq	903023560
 */

public class RandomUtils {

   static ArrayList<String> random = new ArrayList<>();
   static ArrayList<String> random2 = new ArrayList<>();
   //红球的总号数
   public static int redAll = 10;
   //蓝球的总号数
   public static int blueAll = 10;
   //选多少个红球
   public static int redNumber = 6;
   //选多少个篮球
   public static int blueNumber = 1;
   //选多少组红球
   public static int redCount = 1;

    public static ArrayList<String> creatRandomRed() {
        random.clear();
        int number = redAll;
        List arr = new ArrayList();
        for (int i = 0; i < redAll ; i++)
            arr.add(i + 1);
        for (int j = 0; j < redNumber; j++){
            int index = (int) (Math.random() * number);
            int i = (int) arr.get(index);
            String s = i + "";
            random.add(s);
            arr.remove(index);
            number--;
        }
        return random;
    }

    public static ArrayList<String> creatRandomBlue() {
        random2.clear();
        int number = blueAll;
        List arr = new ArrayList();
        for (int i = 0; i < blueAll ; i++)
            arr.add(i + 1);

        for (int j = 0; j < blueNumber; j++){

            int index = (int) (Math.random() * number);
            int i = (int) arr.get(index);
            String s = i + "";
            random2.add(s);
            arr.remove(index);
            number--;
        }

        return random2;
    }
}
