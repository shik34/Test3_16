package com.example.test3_16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private Paint backgroundPaint;

    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);

        backgroundPaint = new Paint();
        backgroundPaint.setStyle(Paint.Style.FILL);
        //surfaceHolder = getHolder();

//        canvas = surfaceHolder.lockCanvas();
//        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.surfaceHolder = holder;
        Canvas canvas = surfaceHolder.lockCanvas();
//        canvas.drawPath(path, paint);
        backgroundPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }
int key=1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (key==1) {
            backgroundPaint.setColor(Color.GREEN);
            key++;
        }else{
            backgroundPaint.setColor(Color.RED);
        }
        Canvas canvas = surfaceHolder.lockCanvas();
//        canvas.drawPath(path, paint);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
        surfaceHolder.unlockCanvasAndPost(canvas);
        return false;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TestSurfaceView(this));

//        Paint p=new Paint();
//        p.setColor(12);
    }
}