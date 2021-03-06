package com.google.zxing.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.SurfaceView;

import com.google.zxing.R;
import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.ViewfinderView;


/**
 * 默认的扫描界面
 */
public class DefaultCaptureActivity extends CaptureActivity {

    private static final String TAG = DefaultCaptureActivity.class.getSimpleName();

    private SurfaceView surfaceView;
    private ViewfinderView viewfinderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.__zxinglite_activity_capture);
        surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
    }

    @Override
    public SurfaceView getSurfaceView() {
        return (surfaceView == null) ? (SurfaceView) findViewById(R.id.preview_view) : surfaceView;
    }

    @Override
    public ViewfinderView getViewfinderHolder() {
        return (viewfinderView == null) ? (ViewfinderView) findViewById(R.id.viewfinder_view) : viewfinderView;
    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        Intent intent=new Intent();
        intent.putExtra("result", rawResult.toString());
        playBeepSoundAndVibrate(true, true);
        setResult(1001, intent);//返回string结果

//        对此次扫描结果不满意可以调用
//        reScan();
    }
}
