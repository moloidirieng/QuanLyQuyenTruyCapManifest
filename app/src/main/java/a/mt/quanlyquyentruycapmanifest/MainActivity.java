package a.mt.quanlyquyentruycapmanifest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button btnKiemTra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnKiemTra=findViewById(R.id.btnKiemTra);
         btnKiemTra.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int permission_internet = ContextCompat.checkSelfPermission(MainActivity.this,
                         Manifest.permission.SEND_SMS);
                 if(permission_internet!=PackageManager.PERMISSION_GRANTED)
                 {
                     Toast.makeText(MainActivity.this, "Ứng dụng không được cấp quyên send SMS", Toast.LENGTH_SHORT).show();
                 }
             }
         });


//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        setSupportActionBar(toolbar);

        int permission_internet = ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET);
        int permission_send_sms = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);
        int permission_camera = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);

        if (permission_internet != PackageManager.PERMISSION_GRANTED
                || permission_send_sms != PackageManager.PERMISSION_GRANTED
                || permission_camera != PackageManager.PERMISSION_GRANTED) {
            makeRequest();
        }

    }

    private void makeRequest() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                Manifest.permission.SEND_SMS, Manifest.permission.CAMERA}, 1);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
