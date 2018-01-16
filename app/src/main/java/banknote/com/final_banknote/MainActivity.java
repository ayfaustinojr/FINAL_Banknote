package banknote.com.final_banknote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.loadLibrary("opencv_java3");
        new Thread(new Runnable() {
            @Override
            public void run() {

                initializeGui();
            }
        }).start();

    }

    private void initializeGui() {
        Button button_gallery = (Button) this.findViewById(R.id.button_gallery);
        button_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        MainActivity.this.executeActivity("gallery");
                    }
                }).start();
            }
        });

        Button button_camera= (Button) this.findViewById(R.id.button_camera);
        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        MainActivity.this.executeActivity("camera");
                    }
                }).start();
            }
        });
    }

    private void executeActivity(String activity) {

        Intent intent = null;

        switch(activity) {
            case "gallery":
                intent = new Intent(this, GalleryActivity.class);
                break;

            case "camera":
                intent = new Intent(this, CameraActivity.class);
                break;
        }

        startActivity(intent);
    }

}
