package uk.ac.soton.dew1g18;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.convolution.FGaussianConvolve;
import org.openimaj.image.typography.hershey.HersheyFont;

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


//        float[][] kernel = {{1/9,1/9,1/9},{1/9,1/9,1/9},{1/9,1/9,1/9}};
//        float[][] kernel = {{-1,0,1}, {0,0,0},{1,0,-1}};
        float[][] kernel = {{-1,-1,-1},{-1,8,-1}, {-1,-1,-1}};
        MyConvolution mycon = new MyConvolution( kernel);


        try{


            FImage image = ImageUtilities.readF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
            image.processInplace(mycon);

            DisplayUtilities.display(image);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
