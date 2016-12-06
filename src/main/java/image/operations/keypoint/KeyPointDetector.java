package image.operations.keypoint;

import image.operations.Consts;
import org.opencv.core.Core;
import org.opencv.calib3d.Calib3d;
import org.opencv.core.*;
import org.opencv.features2d.*;
import org.opencv.highgui.Highgui;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Oda114 on 6.12.2016.
 * Key Point Detection and Description
 */
public class KeyPointDetector {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public void detectKeyPoint(){
        System.out.println("Started....");
        System.out.println("Loading images...");
        Mat objectImage = Highgui.imread(Consts.IMAGE_PATH, Highgui.CV_LOAD_IMAGE_COLOR);
        //Mat sceneImage = Highgui.imread(bookScene, Highgui.CV_LOAD_IMAGE_COLOR);

        MatOfKeyPoint objectKeyPoints = new MatOfKeyPoint();
        FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.SIFT);
        System.out.println("Detecting key points...");
        featureDetector.detect(objectImage, objectKeyPoints);
        KeyPoint[] keypoints = objectKeyPoints.toArray();
        System.out.println("keypoints = " + keypoints);

        MatOfKeyPoint objectDescriptors = new MatOfKeyPoint();
        DescriptorExtractor descriptorExtractor = DescriptorExtractor.create(DescriptorExtractor.SIFT);
        System.out.println("Computing descriptors...");
        descriptorExtractor.compute(objectImage, objectKeyPoints, objectDescriptors);



        KeyPoint[] descpriptors = objectDescriptors.toArray();
        System.out.println("descpriptors = " + descpriptors);;

        Mat matDesp =  objectDescriptors.clone();

        System.out.println( "FEATURE = "+ objectDescriptors.get(0,0)[0]);

        System.out.println(objectDescriptors.col(3));

        Size ketP = objectKeyPoints.size();
        System.out.println(ketP);

        Size desc = objectDescriptors.size();
        System.out.println(desc);

        // Create the matrix for output image.
        Mat outputImage = new Mat(objectImage.rows(), objectImage.cols(), Highgui.CV_LOAD_IMAGE_COLOR);
        Scalar newKeypointColor = new Scalar(255, 0, 0);

        System.out.println("Drawing key points on object image...");
        Features2d.drawKeypoints(objectImage, objectKeyPoints, outputImage, newKeypointColor, 0);
        Highgui.imwrite(Consts.IMAGE_PATH_OUTPUT, outputImage);

        System.out.println("Writing output image...");

    }
}
