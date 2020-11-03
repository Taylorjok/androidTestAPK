package com.yeker.d6t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public String FliePath = "/sys/class/yk_d6t/yk_d6t";
//    private  Context mContex;
    private TextView tv_m = null;
    private Button bt_start = null;
    private Button bt_stop = null;
    private String  tempera = null;


    /**
     * 将文件数据读取到缓存
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readFile(String fileName) {
        String readBuf = "";
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            int length = fis.available();
            byte[] buffer = new byte[length];
            fis.read(buffer);
            readBuf = new String(buffer, 0, length, "UTF-8");
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readBuf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bt_start = findViewById(R.id.bt_start);
       bt_start.setOnClickListener(this);
       bt_stop = findViewById(R.id.bt_stop);
       bt_stop.setOnClickListener(this);

        tv_m = findViewById(R.id.tv_m);

    }


    @Override
    public void onClick(View v) {
        tempera = readFile(FliePath);

        switch (v.getId()){
            case R.id.bt_start:
                    tv_m.setText(tempera);
                break;
            case R.id.bt_stop:
                tv_m.setText("hello world");
                break;
             default:
                 break;
        }
    }
}
