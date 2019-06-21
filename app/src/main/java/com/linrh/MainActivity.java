package com.linrh;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.linrh.easyhttp.EasyHttp;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends Activity {

    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageview);

        String url = "https://www.apiopen.top/journalismApi";

        EasyHttp.httpReq(url, null, null, "get", true, false,
                new okhttp3.Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = response.body().string();
                        Log.e("http", s);
                    }
                }, null, new EasyHttp.ProgressListener() {
                    @Override
                    public void onStart(long size) {

                    }

                    @Override
                    public void onProgress(long index) {

                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }

                    @Override
                    public void onDone(File file) {

                    }
                });



        String downlink = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1561084911&di=464a8bfafe58d35af140fbbe95878308&src=http://is5.mzstatic.com/image/thumb/Purple71/v4/4b/74/df/4b74df7b-511b-1ba9-c53f-b02f9440377c/source/512x512bb.jpg";
        EasyHttp.download(downlink, this.getCacheDir(), new EasyHttp.ProgressListener() {
            @Override
            public void onStart(long size) {
                Log.e("http",size+"");
            }

            @Override
            public void onProgress(long index) {
                Log.e("http",index+"");
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onDone(File file) {

                Log.e("http","下载完成"+file.getPath()+"");
                mImageView.post(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setImageBitmap(BitmapFactory.decodeFile(file.getPath()));
                    }
                });

            }
        });



    }
}
