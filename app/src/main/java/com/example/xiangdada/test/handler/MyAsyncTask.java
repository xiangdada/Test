package com.example.xiangdada.test.handler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xdd on 2019/3/10
 */
public class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {
    private ProgressBar progressBar;
    private ImageView imageView;

    public MyAsyncTask(ProgressBar progressBar, ImageView imageView) {
        this.progressBar = progressBar;
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;
        HttpURLConnection connection = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setDoInput(true);
            connection.setConnectTimeout(20000);
            int code = connection.getResponseCode();
            if (code == 200) {
                //为了显示进度条这里使用 字节数组输出流
                is = connection.getInputStream();
                bos = new ByteArrayOutputStream();
                int length = -1;
                int progress = 0;
                int count = connection.getContentLength();
                byte[] data = new byte[1024];
                while ((length = is.read(data)) != -1) {
                    progress += length;
                    if (count == 0) {
                        publishProgress(-1);
                    } else {
                        publishProgress(progress * 100 / count);
                    }
                    bos.write(data, 0, length);
                }
                bitmap = BitmapFactory.decodeByteArray(bos.toByteArray(), 0, bos.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeInputStream(is);
            closeOutputStream(bos);
            disconnectHttpURLConnection(connection);
        }
        return bitmap;
    }

    private void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeOutputStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void disconnectHttpURLConnection(HttpURLConnection connection) {
        if (connection != null) {
            try {
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (values[0] != -1) {
            progressBar.setProgress(values[0].intValue());
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        progressBar.setVisibility(View.GONE);
        imageView.setImageBitmap(bitmap);
    }
}
