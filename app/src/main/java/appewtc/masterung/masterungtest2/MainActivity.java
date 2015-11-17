package appewtc.masterung.masterungtest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import dji.sdk.api.DJIDrone;
import dji.sdk.interfaces.DJIGerneralListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread() {
            public void run() {
                try {
                    DJIDrone.checkPermission(MainActivity.this, new DJIGerneralListener() {
                        @Override
                        public void onGetPermissionResult(int i) {

                            Log.e(TAG, "ผมลัพธ์ที่ได้ == " + i);
                        }   // event
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } // run
        }.start();


    }   // Main Method
}   // Main Class
