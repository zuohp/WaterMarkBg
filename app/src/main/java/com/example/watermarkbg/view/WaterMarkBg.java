package com.example.watermarkbg.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by on 18/8/5.
 */

public class WaterMarkBg extends Drawable {

    private Paint paint = new Paint();
    private String content;
    private Context context;
    private int degress;//角度
    private int fontSize;//字体大小 单位dp, 不受系统字体大小影响

    /**
     * 初始化构造
     * @param content 水印文字列表 多行显示修改content为list即可
     * @param degress 水印角度
     * @param fontSize 水印文字大小
     */
    public WaterMarkBg(Context context, String content, int degress, int fontSize) {
        this.content = "  "+content+"      "+content+"      "+content; //因为倾斜会导致第一个字显示一半,所以前面添加两个空格
        this.context = context;
        this.degress = degress;
        this.fontSize = fontSize;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {


        int width = getBounds().right;
        int height = getBounds().bottom;

        canvas.drawColor(Color.parseColor("#40F3F5F9"));
        paint.setColor(Color.parseColor("#22000000"));

        paint.setAntiAlias(true);
        paint.setTextSize(dip2px(fontSize));
        //先保存一下画布
        canvas.save();
        canvas.rotate(degress,0, (float) (height* 0.2));
        canvas.drawText(content, 0, (float) (height* 0.2), paint);
        canvas.restore();
        canvas.save();
        //画完第一条水印, 重置画布到原始状态
        canvas.rotate(degress,0, (float) (height* 0.5));
        canvas.drawText(content, 0, (float) (height* 0.5), paint);
        canvas.restore();
        canvas.save();
        //画完第二条水印, 重置画布到原始状态
        canvas.rotate(degress,0, (float) (height* 0.8));
        canvas.drawText(content, 0, (float) (height* 0.8), paint);
        canvas.restore();
        canvas.save();
        //画Y轴上的水印之前重置一下画布的圆点
        canvas.translate((float) ((float) width*0.2),0);
        canvas.rotate(degress,0, (float) (height));
        canvas.drawText(content.trim(), 0, height-10, paint);
        canvas.restore();
        canvas.save();
        canvas.translate((float) ((float) width*0.7),0);
        canvas.rotate(degress,0, (float) (height));
        canvas.drawText(content.trim(), 0, height-10, paint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

    private int dip2px(int paramFloat) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (paramFloat * f + 0.5F);
    }
}
