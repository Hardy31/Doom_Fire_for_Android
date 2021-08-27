package com.example.doomfire;

import android.content.Context;
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

public class FireView extends View{
    private byte[][] temp;

    int sizePoint;
    int dotsWidth ;
    int dotsHeight ;

    Paint paint = new Paint();


    public FireView(Context context, @Nullable AttributeSet attrs) { super(context, attrs);  }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        System.out.println("====================w===================" + w);
        System.out.println("====================h===================" + h);

//        temp = new byte[h][w];
        sizePoint = (w-200)/50;
        dotsWidth = 50;
        dotsHeight = (h-300)/sizePoint;
        temp = new byte[dotsHeight][dotsWidth];
        System.out.println("====================sizePoint===================" + sizePoint);
        System.out.println("====================dotsWidth===================" + dotsWidth);
        System.out.println("====================dotsHeight===================" + dotsHeight);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(sizePoint);
        paint.setStyle(Paint.Style.STROKE);


        System.out.println("====================firePalette[firePalette.length]===================" + (firePalette.length-1));

//        Arrays.fill(temp[dotsHeight-1], (byte) firePalette.length);
//        System.out.println(temp[dotsHeight-1][10]);
        for(int x = 0; x < dotsWidth; x++){
            temp[dotsHeight-1][x] = (byte) firePalette.length;
//            System.out.print(temp[dotsHeight-1][x] + "  ,");
        }
        System.out.println("====================temp.length===================" + temp.length);
        System.out.println(temp[dotsHeight-1][10]);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        System.out.println("====================temp[y][x]===================" + temp[80][5]);
//        System.out.println("====================firePalette 36 ===================" + firePalette[36]);
//        System.out.println("====================temp[y].length===================" + temp[y].length);
        for (int y = 0; y < temp.length; y++) {
            for (int x = 0; x < temp[y].length; x++) {

                int cl;
                if (x == dotsHeight){
//                    cl = firePalette[x];
                    paint.setColor(-125);
                    System.out.println("====================temp===================" + y + " - " + x);
                }


//                if (x<dotsHeight){
//                    paint.setColor(firePalette[36]);
//                }else{
//                    paint.setColor(firePalette[x-dotsHeight]);
//                }

//                if( y==80){
//                    paint.setColor(firePalette[dotsHeight]);
//                }
//                paint.setColor(firePalette[temp[y][x]]);
                canvas.drawPoint((75+x*sizePoint), (75+y*sizePoint), paint);
            }
        }

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
