package banknote.com.final_banknote;

import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageAdapter {

    public static Bitmap toBitmap(Mat mat) {
        //Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2RGBA);
        Bitmap bitmap = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat, bitmap);
        return bitmap;
    }

    public static Mat toMat(Bitmap img) {

        Mat mat = new Mat();

        Bitmap bmp32 = img.copy(Bitmap.Config.ARGB_8888, true);

        Utils.bitmapToMat(bmp32, mat);
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGBA2RGB);

        return mat;
    }
}
