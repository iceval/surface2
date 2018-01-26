package com.example.ugs.surface;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    SurfaceHolder holder;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        r =0;
        press=true;

        return super.onTouchEvent(event);
    }

    public MySurfaceView(Context context) {
        super(context);
        holder=getHolder();
        holder.addCallback(this);
        p.setColor(Color.YELLOW);

    }
Paint p = new Paint();



    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        new MyThread().start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
    float x = 0;
    float y = 0;
    float r = 0;
    boolean press=false;
    class MyThread extends Thread{
        public void run (){

            while (true) {
                Canvas canvas = holder.lockCanvas();
                canvas.drawColor(Color.BLUE);
                if (press==true){
                canvas.drawCircle(x,y,r,p);}
                holder.unlockCanvasAndPost(canvas);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r+=5;
            }
        }
    }
}

