package com.example.doomfire;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import java.util.Random;

public class CubeRandomColor extends View {



    //  размеры монитора!

    DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    double x = Math.pow(metrics.widthPixels/metrics.xdpi,2);
    double y = Math.pow(metrics.heightPixels/metrics.ydpi,2);
    double screenInches = Math.sqrt(x+y);
    int heightpixel = (Integer) metrics.heightPixels;
    int widthpixel = (Integer) metrics.widthPixels;
    //ширина
    int width = Math.round(widthpixel) ;
    int fireWidth;

    //высота
    int height = heightpixel;
    int fireHeight;



        private Canvas canvas = new Canvas();
        private final Paint paint = new Paint();
        Random rnd = new Random(System.currentTimeMillis());
        int sizePoint = (width-200)/50;
        int dotsWidth = 50;
        int dotsHeight = (height-300)/sizePoint;
        private  int[][] temp;




        public CubeRandomColor(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);

            System.out.println("====================widthpixel===================" + widthpixel);
            System.out.println("======================heightpixel=================" + heightpixel);
            System.out.println("=======================sizePoint================" + sizePoint);
            System.out.println("=======================dotsWidth================" + dotsWidth);
            System.out.println("=======================dotsHeight================" + dotsHeight);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            temp= new int[w][h];
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        for (int x = 0; x < fireWidth; x ++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLUE);
            paint.setColor(Color.GREEN);


            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.STROKE);

//        canvas.drawPoint(5,5,paint);
//
//        paint.setColor(Color.GRAY);
//        canvas.drawPoint(100,100,paint);

            for(int x = 0;x < dotsWidth; x++){
                for(int y = 0;y < dotsHeight; y++){
                    int index = rnd.nextInt(36);
                    paint.setColor(firePalette[ index]);
                    canvas.drawPoint(50+x*sizePoint,50+y*sizePoint,paint);
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

