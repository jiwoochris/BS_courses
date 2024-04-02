package juicyjung.gachon.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int hour = 0;
    int minute = 0;
    int sec = 0;
    int msec = 0;
    TextView txt_time;
    Thread counting_thread;
    Boolean stop = true;
    String arr_history = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_time = findViewById(R.id.txt_time);

        TimeHandler myHandler = new TimeHandler();
        counting_thread = new Thread(new Runnable(){
            public void run(){

                try{
                    while(true) {
                        if(!stop){
                            Thread.sleep(10);
                            Message msg = myHandler.obtainMessage();
                            myHandler.sendMessage(msg);
                        }
                    }
                }
                catch(Exception ex){
                    Log.e("MainActivity", "Exception in processing message.", ex);
                }

            }
        });

        counting_thread.start();

        Button btn_more = findViewById(R.id.btn_more);
        btn_more.setVisibility(View.INVISIBLE);

        Button btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_start.setVisibility(View.INVISIBLE);
                btn_more.setVisibility(View.VISIBLE);

                stop = false;
            }
        });

        Button btn_pause = findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(stop){
                    stop = false;
                    btn_pause.setText("일시정지");
                }
                else{
                    stop = true;
                    btn_pause.setText("다시시작");
                }
            }
        });

        Button btn_history = findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time0 = String.format("%02d:%02d:%02d:%02d", hour, minute, sec, msec);
                arr_history += (time0 + "\n");
            }
        });

        Button btn_stop = findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stop = true;
                hour = 0;
                minute = 0;
                sec = 0;
                msec = 0;

                String time0 = String.format("%02d:%02d:%02d:%02d", hour, minute, sec, msec);


                btn_pause.setText("일시정지");
                btn_start.setVisibility(View.VISIBLE);
                btn_more.setVisibility(View.INVISIBLE);

                arr_history = "";

                txt_time.setText(time0);
            }
        });

        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop = true;
                btn_pause.setText("다시시작");

                Intent newIntent = new Intent(getApplicationContext(), NewActivity.class);
                newIntent.putExtra("history", arr_history);
                startActivity(newIntent);
            }
        });


    }

    public class TimeHandler extends Handler{
        public void handleMessage(Message msg){
            if(msec < 99){
                msec++;
            }
            else{
                msec = 0;
                if(sec < 60){
                    sec++;
                }
                else{
                    sec = 0;
                    if(minute < 60){
                        minute++;
                    }
                    else{
                        minute = 0;
                        hour++;
                    }
                }
            }

            SetTime();
        }
    }

    public void SetTime(){

        String time0 = String.format("%02d:%02d:%02d:%02d", hour, minute, sec, msec);

        txt_time.setText(time0);
    }
}