package com.lnyswz.asdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Main3Activity extends AppCompatActivity {

    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        show = findViewById(R.id.show);
        //new Thread(runnable).start();
        GetData1 getData = new GetData1();
        getData.execute("http://192.168.0.8/lnyswz/admin/departmentAction!listYws.action", "id=12");
    }


    class GetData1 extends SqlUtils{
//        GetData1(Context ctx){
//            super(ctx);
//        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            show.setText(s);
        }

        @Override
        protected String doInBackground(String... params) {
            return super.doInBackground(params);
        }
    }
}
