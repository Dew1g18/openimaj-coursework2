package uk.ac.soton.dew1g18;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.convolution.FGaussianConvolve;
import org.openimaj.image.processing.convolution.Gaussian2D;
import org.openimaj.image.typography.hershey.HersheyFont;

import java.io.File;
import java.net.URL;

/**
 * OpenIMAJ Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
//    	//Create an image
//        MBFImage image = new MBFImage(320,70, ColourSpace.RGB);
//
//        //Fill the image with white
//        image.fill(RGBColour.WHITE);
//
//        //Render some test into the image
//        image.drawText("Hello World", 10, 60, HersheyFont.CURSIVE, 50, RGBColour.BLACK);
//
//        //Apply a Gaussian blur
//        image.processInplace(new FGaussianConvolve(2f));
//
//        //Display the image
//        DisplayUtilities.display(image);

//
////        float[][] kernel = {{1/9,1/9,1/9},{1/9,1/9,1/9},{1/9,1/9,1/9}};//Averaging (doesnt work)
////        float[][] kernel = {{-1,0,1}, {0,0,0},{1,0,-1}};//Weak edge detection
//        float[][] kernel = {{-1,-1,-1},{-1,8,-1}, {-1,-1,-1}};//Strong edge detection
////        float[][] kernel = {{0,0,0}, {0,1,0}, {0,0,0}};//Identity
////        float[][] kernel = {{0,-1,0}, {-1,5,-1}, {0,-1,0}};//sharpening
//
//
//        /**
//         * The following was what i used while testing my convolution with the above kernels from wikipedia.
//         */
//        MyConvolution mycon = new MyConvolution( kernel);
//
//
//        try{
//
//            FImage image = ImageUtilities.readF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
//            DisplayUtilities.display(image);
//            //            DisplayUtilities.display(image);
//            image.processInplace(mycon);
//
//            DisplayUtilities.display(image);
//
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }


        /**
         * Hybrid image practice space
         */
        try {
            MBFImage lowImage = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\bird.bmp"));
            MBFImage highImage = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\fish.bmp"));

            MyHybridImages mh = new MyHybridImages();
            mh.makeHybrid(lowImage, 1f, highImage, 1f);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
