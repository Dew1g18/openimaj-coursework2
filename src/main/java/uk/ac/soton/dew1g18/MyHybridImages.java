package uk.ac.soton.dew1g18;

import org.apache.tools.ant.taskdefs.EchoXML;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.MBFImage;
import org.openimaj.image.processing.convolution.Gaussian2D;

public class MyHybridImages {

    /**
     * Compute a hybrid image combining low-pass and high-pass filtered images
     *
     * @param lowImage
     *            the image to which apply the low pass filter
     * @param lowSigma
     *            the standard deviation of the low-pass filter
     * @param highImage
     *            the image to which apply the high pass filter
     * @param highSigma
     *            the standard deviation of the low-pass component of computing the
     *            high-pass filtered image
     * @return the computed hybrid image
     */
    public static MBFImage makeHybrid(MBFImage lowImage, float lowSigma, MBFImage highImage, float highSigma) {


        /**
         * convolve low then high filter passes.
         */
        lowPass(getKernel(lowSigma),lowImage );
        highPass(getKernel(highSigma) , highImage);

//        DisplayUtilities.display(lowImage);
//        DisplayUtilities.display(highImage);

        return combine(lowImage, highImage);
    }

    protected static MBFImage combine(MBFImage low, MBFImage high){
        /**
         * Really simply loops through the pixels and adds all the pixel values to combine the images
         */
        int rows = low.getRows();
        int cols = low.getCols();
        for(int col=0; col<cols; col++){
            for(int row = 0; row<rows; row++){
                Float[] newPixel = low.getPixel(col, row);
                for(int colour = 0; colour<newPixel.length; colour++){
                    newPixel[colour] += high.getPixel(col, row)[colour];

                }
                low.setPixel(col, row, newPixel);
            }
        }
        return low;
    }


    protected static float[][] getKernel(float sigma){
        /**
         * uses given sigma to get the suggested size of the kernel from the spec.
         * then runs Gaussian2D to get a kernel.
         */
        int size = (int) (8.0f*sigma+ 1.0f );
        if (size%2==0){size++;} //Size must be odd for kernel apparently...
        return Gaussian2D.createKernelImage(size, sigma).pixels;
    }

    protected static MBFImage lowPass(float[][] kernel, MBFImage image){
        /**
         * just runs the low pass (actually just runs the convolution templarte process with a given kernel)
         *  the kernel comes from the gauseian and sigma in in getKernel
         */
        MyConvolution myCon = new MyConvolution(kernel);
//        Conv0 myCon = new Conv0(kernel);
        image.processInplace(myCon);
        return image;
    }


    protected static MBFImage highPass(float[][] kernel, MBFImage image){
        /**
         * Loops through and takes the values of a low pass version of the image from the original.
         */
        int cols = image.getCols();
        int rows = image.getRows();
        MBFImage clone = image.clone();
        lowPass(kernel, clone);
        for (int x =0; x<cols; x++){
            for(int y = 0; y<rows; y++){
                Float[] newPixVal = image.getPixel(x,y);
                for (int n = 0; n<newPixVal.length; n++){
                    newPixVal[n]-=clone.getPixel(x,y)[n];
                }
                image.setPixel(x,y, newPixVal);
            }
        }

        return image;
    }


    /**
     * Want to write something to get the standard dev of an imaves pixels and work out what sigma
     * for low and high band filters would be to automate that step, however my peers are finding
     * sigmas and hardcoding them, and I have many other courseworks to get on with so I'm not going
     * to worry about this yet
     */
//
//    public float getLowPassSigma(MBFImage image){
//        return 1f;
//    }
//
//    public float getHighPassSigma(MBFImage image){
//        return 1f;
//    }
//
//    public float sigma(FImage image){
//
//    }
}
