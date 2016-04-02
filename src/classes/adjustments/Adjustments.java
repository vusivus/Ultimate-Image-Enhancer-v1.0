/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.adjustments;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Electronics
 */
public class Adjustments {

    public Mat changeBrightness(Mat source, double alpha, double beta) {
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        source.convertTo(destination, -1, alpha, beta);
        return destination;
    }
//==============================================================================

    public Mat changeSharpness(Mat source, int value) {
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.GaussianBlur(source, destination, new Size(0, 0), value);
        Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
        return destination;
    }
//==============================================================================

    public Mat changeSize(Mat source, int w, int h, int r) {

        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.resize(source, destination, new Size(w, h));

        return destination;
    }
//==============================================================================

    public Mat flipImage(Mat source, int status) {

        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Core.flip(source, destination, status);

        return destination;
    }
}
