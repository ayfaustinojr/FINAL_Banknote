package banknote.com.final_banknote;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);

        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();

        String[] projection = { MediaStore.Images.Media.DATA };

        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(projection[0]);
        String picturePath = cursor.getString(columnIndex); // returns null

        System.out.println(picturePath);


        cursor.close();

        try {

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

            ImageView image_view  = (ImageView) findViewById(R.id.image_view);
            /**/image_view.setImageBitmap(bitmap);



            //
            //YourClass your_class = new YourClass(bitmap);
            //your_class.process;
            //image_view.setImageBitmap(your_class.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}