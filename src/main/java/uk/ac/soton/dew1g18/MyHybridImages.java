package uk.ac.soton.dew1g18;

import org.openimaj.image.DisplayUtilities;
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
        //implement your hybrid images functionality here.
        //Your submitted code must contain this method, but you can add
        //additional static methods or implement the functionality through
        //instance methods on the `MyHybridImages` class of which you can create
        //an instance of here if you so wish.
        //Note that the input images are expected to have the same size, and the output
        //image will also have the same height & width as the inputs.
        DisplayUtilities.display(lowImage);

        /**
         * convolve low then high filter passes.
         */
        convolve(getKernel(lowSigma),lowImage );
//        convolve(getKernel(highSigma), highImage);

        DisplayUtilities.display(lowImage);



        return lowImage;
    }


    protected static float[][] getKernel(float sigma){
        int size = (int) (8.0f*sigma+ 1.0f );
        if (size%2==0){size++;} //Size must be odd for kernel apparently...
        return Gaussian2D.createKernelImage(size, sigma).pixels;
    }

    protected static MBFImage convolve(float[][] kernel, MBFImage image){
        MyConvolution myCon = new MyConvolution(kernel);
        image.processInplace(myCon);
        return image;
    }

    protected static float getLowPassSigma(MBFImage image){
        return 1f;
    }

    private float getHighPassSigma(MBFImage image){
        return 1f;
    }
}
