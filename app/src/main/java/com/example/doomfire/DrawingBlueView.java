package com.example.doomfire;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawingBlueView extends View{
//    public class DemoDrawingView extends View {

        private Canvas canvas = new Canvas();


        public DrawingBlueView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawColor(Color.BLUE);
            canvas.drawColor(Color.RED);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        }
}
