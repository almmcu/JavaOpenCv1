import image.operations.ConvertMatToBufferedImage;
import image.operations.DisplayImage;
import org.opencv.core.*;
import org.opencv.features2d.FeatureDetector;
import org.opencv.highgui.Highgui;

/**
 * Created by Oda114 on 15.11.2016.
 */
public class Test {
    // Compulsory
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV Mat: " + m);
        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + m.dump());
        FeatureDetector SURF = FeatureDetector.create(FeatureDetector.SURF);
//        Mat img = Highgui.imread("C:\\Users\\Oda\\Desktop\\ICCESEN_2016_Pictures\\2.jpg");
        Mat img = Highgui.imread("C:\\Users\\Oda\\Downloads\\1.jpg");

        ConvertMatToBufferedImage convertMatToBufferedImage =
                new ConvertMatToBufferedImage(img);
        DisplayImage displayImage =
                new DisplayImage(convertMatToBufferedImage.Mat2BufferedImage());
        displayImage.display();
    }
}
