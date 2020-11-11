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
//            MBFImage dave = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\smolDav2.jpg"));
//            MBFImage sam = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\smolSam2.jpg"));
            MBFImage dave = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\smolDav2.jpg"));
            MBFImage sam = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\smolSam2.jpg"));
            MBFImage davClone = dave.clone();
            MBFImage samClone = sam.clone();


//            DisplayUtilities.display(highImage);
//            DisplayUtilities.display(lowImage);

            MyHybridImages mh = new MyHybridImages();
            DisplayUtilities.display(
//                    mh.makeHybrid(lowImage, 3f, highImage, 5f)//smol 3
                    mh.makeHybrid(dave, 5f, sam, 5f)//smol 2
//                    mh.makeHybrid(lowImage, 5f, highImage, 3f)//smol 1
            );

            /**
             * including the reverse version cause I cant decide which is better.
             */

            DisplayUtilities.display(
                    mh.makeHybrid(samClone, 4f, davClone, 3f)//reverse)
            );

            /**
             * best so far below for testing
             */
//            DisplayUtilities.display(
////                    mh.makeHybrid(lowImage, 3f, highImage, 5f)//smol 3
//                    mh.makeHybrid(dave, 3f, sam, 5f)//smol 2
////                    mh.makeHybrid(lowImage, 5f, highImage, 3f)//smol 1
//            );
//
//            DisplayUtilities.display(
//                    mh.makeHybrid(samClone, 5f, davClone, 3f)//reverse)
//            );



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
