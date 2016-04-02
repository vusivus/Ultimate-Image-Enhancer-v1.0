/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.adjustments;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Electronics
 */
public class Effects {

    public Mat RGB2GrayScale(Mat source) {

        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);
        return destination;
    }
//==============================================================================

    public Mat gaussiabBlurr(Mat source, int value) {

        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.GaussianBlur(source, destination, new Size(value, value), 0);

        return destination;
    }
//==============================================================================

    public Mat boxFilterBlurr(Mat source, int kernelSize) {

        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Mat kernel = Mat.ones(kernelSize, kernelSize, CvType.CV_32F);
        for (int i = 0; i < kernel.rows(); i++) {
            for (int j = 0; j < kernel.cols(); j++) {
                double[] m = kernel.get(i, j);
                for (int k = 0; k < m.length; k++) {
                    m[k] = m[k] / (kernelSize * kernelSize);
                }
                kernel.put(i, j, m);
            }
        }
        Imgproc.filter2D(source, destination, -1, kernel);

        return destination;
    }
}
