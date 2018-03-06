package com.coco.ssa.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 根据基础Values/dimens的数据额外生成不同布局的dimens
 * 对该文件右键，Run java 生成不同布局文件
 * 效果不是特别好，暂时取消用这个方法来适配
 * Created by Hoyn on 17/3/27.
 */

public class DimenUtil {
        public static final String RES_PATH = "./app/src/main/res";
    public static void gen() {
        //以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File(RES_PATH+"/values/dimens.xml");
        System.out.println(RES_PATH+"/values/dimens.xml");
        System.out.println(file.getAbsolutePath());
        if(file.isFile()){
            System.out.print("aaaa");
        }else{
            System.out.print("bbbb");
        }
        BufferedReader reader = null;
        StringBuilder sw240 = new StringBuilder();
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();

        StringBuilder sw720 = new StringBuilder();

        StringBuilder sw800 = new StringBuilder();

        StringBuilder w820 = new StringBuilder();

        try {

            System.out.println("生成不同分辨率：");

            reader = new BufferedReader(new FileReader(file));

            String tempString;

            int line = 1;

            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {


                if (tempString.contains("</dimen>")) {

                    //tempString = tempString.replaceAll(" ", "");

                    String start = tempString.substring(0, tempString.indexOf(">") + 1);

                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1,
                                    tempString.indexOf("</dimen>") - 2));

                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。
                    sw240.append(start).append( num * 0.75).append(end).append("\r\n");

                    sw480.append(start).append(num * 1.5).append(end).append("\r\n");

                    sw600.append(start).append(num * 1.87).append(end).append("\r\n");

                    sw720.append(start).append(num * 2.25).append(end).append("\r\n");

                    sw800.append(start).append(num * 2.5).append(end).append("\r\n");

                    w820.append(start).append(num * 2.56).append(end).append("\r\n");

                } else {
                    sw240.append(tempString).append("");

                    sw480.append(tempString).append("");

                    sw600.append(tempString).append("");

                    sw720.append(tempString).append("");

                    sw800.append(tempString).append("");

                    w820.append(tempString).append("");

                }

                line++;

            }

            reader.close();
            System.out.println("<!--  sw240 -->");

            System.out.println(sw240);

            System.out.println("<!--  sw480 -->");

            System.out.println(sw480);

            System.out.println("<!--  sw600 -->");

            System.out.println(sw600);

            System.out.println("<!--  sw720 -->");

            System.out.println(sw720);

            System.out.println("<!--  sw800 -->");

            System.out.println(sw800);

            String sw240fileDic = RES_PATH+"/values-sw240dp-land/";

            String sw480fileDic = RES_PATH+"/values-sw480dp-land/";

            String sw600fileDic = RES_PATH+"/values-sw600dp-land/";

            String sw720fileDic = RES_PATH+"/values-sw720dp-land/";

            String sw800fileDic = RES_PATH+"/values-sw800dp-land/";

            String w820fileDic = RES_PATH+"/values-w820dp/";
            //将新的内容，写入到指定的文件中去
            writeFile(sw240fileDic, sw240.toString());

            writeFile(sw480fileDic, sw480.toString());

            writeFile(sw600fileDic, sw600.toString());

            writeFile(sw720fileDic, sw720.toString());

            writeFile(sw800fileDic, sw800.toString());

            writeFile(w820fileDic, w820.toString());

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (reader != null) {

                try {

                    reader.close();

                } catch (IOException e1) {

                    e1.printStackTrace();

                }

            }

        }

    }


    /**
     * 写入方法
     *
     */

    public static void writeFile(String file, String text) {
        System.out.print(file);
        File mFile = new File(file);
        if(!mFile.exists()){
            mFile.mkdirs();
        }
        file = file+"dimens.xml";
        mFile = new File(file);
        if(mFile.exists()){
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintWriter out = null;

        try {

            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            out.println(text);

        } catch (IOException e) {

            e.printStackTrace();

        }



        out.close();

    }
    public static void main(String[] args) {

        gen();

    }
}
