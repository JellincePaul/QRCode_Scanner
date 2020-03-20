package jmjp.appmaker.samplechevre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int i=0;
    public Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        i = progressBar.getProgress();
        new Thread(new Runnable() {
            public void run() {
                while (i < 100) {
                    i += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(i);
                            }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Intent login_intent = new Intent(MainActivity.this,scanner.class);
        startActivity(login_intent);
    }
}
