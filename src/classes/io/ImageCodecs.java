/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.io;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import org.opencv.core.Mat;

/**
 *
 * @author Electronics
 */
public class ImageCodecs {

    private String JPEG = "JPEG File";
    private String JPG = "JPG File";
    private String PNG = "PNG File";
    private String TIFF = "TIFF File";
    private FileView jpegFile, jpgFile, pngFile, tiffFile;
//==============================================================================

    public Image matToImage(Mat frame) {
       int type = BufferedImage.TYPE_BYTE_GRAY;
          if ( frame.channels() > 1 ) {
              type = BufferedImage.TYPE_3BYTE_BGR;
          }
          int bufferSize = frame.channels()*frame.cols()*frame.rows();
          byte [] b = new byte[bufferSize];
          frame.get(0,0,b); // get all the pixels
          BufferedImage image = new BufferedImage(frame.cols(),frame.rows(), type);
          final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
          System.arraycopy(b, 0, targetPixels, 0, b.length);  
          return image;
    }
//==============================================================================

    public JFileChooser setUpFileChooser() {
        JFileChooser chooser = new JFileChooser("C:\\Users\\Electronics\\Pictures");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(JPG, "jpg"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(JPEG, "jpeg"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(PNG, "png"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(TIFF, "tiff"));
        chooser.setFileView(new ImageFileView());
        return chooser;
    }
//==============================================================================

    public String decodeExtention(String description) {
        String ext = "";
        if (description.equals(JPG)) {
            ext = "jpg";
        }
        if (description.equals(JPEG)) {
            ext = "jpeg";
        }
        if (description.equals(PNG)) {
            ext = "png";
        }
        if (description.equals(TIFF)) {
            ext = "tiff";
        }
        return ext;
    }
//==============================================================================

    public String removeExtention(String file) {

        String returnFile = null;
        int index = file.indexOf('.');

        if (index == -1) {
            returnFile = file;
        } else {
            returnFile = file.substring(0, index);
        }
        return returnFile;
    }
}
