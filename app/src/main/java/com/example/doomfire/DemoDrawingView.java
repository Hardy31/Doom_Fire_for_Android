package com.example.doomfire;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.max;

public class DemoDrawingView extends View {

    private Canvas canvas = new Canvas();
    private final Paint paintB = new Paint();
//    private final Paint paint = new Paint();

    private Random rnd = new Random(System.currentTimeMillis());

    private  byte[][] temp;
    private Bitmap bitMap ;



    private void DemoDrawingView (Canvas canvas) {

    }

    public DemoDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {


        int fireWigth = w/8;
        int fireHigth = h/8;
        temp = new byte[fireHigth][fireWigth];

        Arrays.fill(temp[fireHigth-1], (byte) (firePalette.length-1));
//        for(int x = 0; x < w; x++){
//            temp[h-1][x] = (byte) firePalette[firePalette.length-1];
////            System.out.print(temp[dotsHeight-1][x] + "  ,");
//        }

        bitMap = Bitmap.createBitmap(fireWigth,fireHigth,Bitmap.Config.RGB_565);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int y = 0; y < temp.length-1; y++) {
            for (int x = 0; x < temp[y].length; x++) {

                int dx = rnd.nextInt(3)-1;
                int dy = rnd.nextInt(6);

                int dt = (byte) rnd.nextInt(2);

                int x1 = Math.min(temp[y].length-1, Math.max(0,x + dx));
                int y1 = Math.min(temp.length-1, (y + dy));

//                temp [y][x] = (byte) (temp [y1][x1] - dt );

                temp [y][x] = (byte) Math.max(0,( temp [y1][x1] - dt ));
//                temp[y][x] = temp[y1][x1]-  dt;


            }
        }
//        paintB.setColor(Color.GREEN);

        for (int y = 0; y < temp.length; y++) {
            for (int x = 0; x < temp[y].length; x++) {

                int color = firePalette[temp[y][x]];

//                paintB.setColor(color);
                bitMap.setPixel(x,y, color);
//
//                canvas.drawPoint(x,y,paintB);
//
            }
        }

        float scale = (float) (getWidth()/bitMap.getWidth());
//        System.out.println("=== getWidth() ======" + getWidth());
//        System.out.println("=== bitMap.getWidth() ======" + bitMap.getWidth());
//        System.out.println("=== scale ======" + scale);

        canvas.scale(scale,scale);
        canvas.drawBitmap(bitMap,0,0,paintB);
        invalidate();

    }


    private static final int[] firePalette = {
            0xff070707,
            0xff1F0707,
            0xff2F0F07,
            0xff470F07,
            0xff571707,
            0xff671F07,
            0xff771F07,
            0xff8F2707,
            0xff9F2F07,
            0xffAF3F07,
            0xffBF4707,
            0xffC74707,
            0xffDF4F07,
            0xffDF5707,
            0xffDF5707,
            0xffD75F07,
            0xffD75F07,
            0xffD7670F,
            0xffCF6F0F,
            0xffCF770F,
            0xffCF7F0F,
            0xffCF8717,
            0xffC78717,
            0xffC78F17,
            0xffC7971F,
            0xffBF9F1F,
            0xffBF9F1F,
            0xffBFA727,
            0xffBFA727,
            0xffBFAF2F,
            0xffB7AF2F,
            0xffB7B72F,
            0xffB7B737,
            0xffCFCF6F,
            0xffDFDF9F,
            0xffEFEFC7,
            0xffFFFFFF
    };
}
