package juicyjung.gachon.app220516;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_2 extends AppCompatActivity {
    TextView textView0;
    ProgressBar bar;
    ProgressHandler handler;
    boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView0 = (TextView) findViewById(R.id.TextView01);
        bar = (ProgressBar) findViewById(R.id.progress);
        handler = new ProgressHandler();
    }
    @Override
    protected void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                try{
                    for(int i=0; i<20 && isRunning; i++){
                        Thread.sleep(1000);
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                }
                catch(Exception ex){
                    Log.e("MainActivity", "Exception in processing message.", ex);
                }}
        });
        isRunning = true;
        thread1.start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }

    public class ProgressHandler extends Handler {
        public void handleMessage(Message msg){
            bar.incrementProgressBy(5);
            if(bar.getProgress()==bar.getMax()){
                textView0.setText("Done");
            } else {
                textView0.setText("Working..."+bar.getProgress());
            }
        }
    }
}

