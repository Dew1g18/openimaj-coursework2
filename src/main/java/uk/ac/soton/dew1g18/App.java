package uk.ac.soton.dew1g18;

import org.openimaj.image.*;
import org.openimaj.image.colour.ColourSpace;
import org.openimaj.image.colour.RGBColour;
import org.openimaj.image.processing.convolution.FGaussianConvolve;
import org.openimaj.image.processing.convolution.Gaussian2D;
import org.openimaj.image.processing.resize.ResizeProcessor;
import org.openimaj.image.typography.hershey.HersheyFont;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

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

        /**
         * Testing the convolution. (Conv0 is another class I made to try zero padding as I reallised I was insetead
         * ignoring the edges rather than processing them with zeros.
         */
//
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
//        Conv0 con = new Conv0( kernel);
//
//
//        try{
//
//            FImage image = ImageUtilities.readF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
//            DisplayUtilities.display(image);
//            //            DisplayUtilities.display(image);
//            image.processInplace(con);
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


            MBFImage dave = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\trump.jpg"));
            MBFImage sam = ImageUtilities.readMBF(new File("C:\\Users\\davew\\openimaj-coursework2\\src\\main\\java\\uk\\ac\\soton\\dew1g18\\hybrid-images\\fire.jpg"));

/**
 * Sorry that my images have such long URLs, they're selfies from myself and a housemate and so I have them stored in google photos,
 * this generates incredibly long URLs for when you want to get just the image.
 */
//            MBFImage dave = ImageUtilities.readMBF(new URL("https://lh3.googleusercontent.com/Mgj9-NbNir0i8dLtA6u-QIg-c0ixepyt7yxYlkGO_fV-DaxDreoKUwDQjtHxJsmIuxMgOT0XV2r6D7BkA18Xr12UI0mJnR2fvrHxZDJ3_ESXp73ytYo3WgxDTOmDGGnCB-KJ7R3xR92SA2k711AFuHk4jj7N15yboS2tcPjNBgDX5vVa4W9BAr5BP1GNczNIJ1R5p93mKsDb4wwdQiB4zM-1XlP7zSoflrV0lqUVlNqo4KIfNcOdcjl_F36JWAFj0Vmw3PkHRgKLk4n-JirqPMB1fkFxbqRVZbET7AoJVRL_3jmlwk22BbmEjxARc3JO4QZ3eqaoERBzCGkvGqV2mW3RjuBWw1kmbAUXStcVOPpk0kHAD53WYuRyAPDkd-V7rwT-u19Ggua2gZaMdy2zuOyC69084AkLAJvEOC5pntsy97cI1bf9TtjSz_UevSRRyiM40OQspYoexhe4VIm_hxQ_cQRCytc3hP4okdu53iIoUwurq_tWctGl7inI76y82FmxkOeos0dAW3tHnfr5hY5coWOjsY8gVLdF4fujGLDVJvMb-TNMos631ngw6DugYCgF4hh0D_HMnPlpE9hUXy1BrD-K0lhwwwFn9WOwR12VRWwpsWTbBPdMixNs6f8uDowRRAQKSrGoVFMZEd7OIyq8jCOxz-wxRQMI8AsR25MUiGPGgNPrvRg_XI6PmQ=w300-h624-no?authuser=0"));
//            MBFImage sam = ImageUtilities.readMBF(new URL("https://lh3.googleusercontent.com/sQ-1uztKzCytPgT2E-8BEmvFNUjkdzbHD_ca9Cu9H8pHetIjnmBzHUC6SZOCo6OPYCHRbFYeoKj-hUgk2gsCbsX-MBA2-vL-XwNTHLjJnVeOiLOTzAjB-hzV5jMQV12Fvmix41foRhP4BPpWxOTmqlbcBNJrfHlp2QdRwLtg356mGo7IGQ36DA7zaJlxqz9VPqhn5mxUbbPicPdVoDRQlBoMs46UPoEkxUvB950GEnbsNWoTnbcFa5JgjZUBmNl-AM6lZW9y8_viZTDEqY3_nMa3ntJCsdxiG4cIbPDEb_yZ6jGEM-Jk5XLYtKUGxHIyMwkwRWtAMtNJGwuNF1JkQY2r8Xyol4VBLvVJGVDSd-zAEcxQH1gzNIfz9WoeW7a5-7f3Ve2Y3e_RmufDVSrz9zl_8NbOeDyGDhpIa-Pe9bZ59EiQ52Bnxv_HcB296JQDsuR8TNFnKje6d2DA52N477DYH6QWAh4NKfcZmlgllloflKTB9lrxfLvPzs00RNC1oSjzeQDI83xVv8Qz_6lCXYeeAwCinZgHG6HyialFBgZ_0Oyh3b8R-AiZqao1crgEVzfOqhhlFvtEaJkO4BgPwKaAuWZrMAuBYUCOL69x-4V_1h8gTMoSsAAxLh32njBLNMxkuD6pBm674W1TiSKjOM4NN6OizIMJM1S6Ny3KkByYe8BqSmBGWWN5_r82Cg=w300-h624-no?authuser=0"));

            MBFImage davClone = dave.clone();
            MBFImage samClone = sam.clone();



//            DisplayUtilities.display(highImage);
//            DisplayUtilities.display(lowImage);

            MyHybridImages mh = new MyHybridImages();

            MBFImage image0 = mh.makeHybrid(dave, 5f, sam, 5f);//smol 2
            downSample(image0);
//            ImageUtilities.write(downSample(image0), new File("DaveAndSam.jpg"));

//            DisplayUtilities.display(
////                    mh.makeHybrid(lowImage, 3f, highImage, 5f)//smol 3
//                     image0
////                    mh.makeHybrid(lowImage, 5f, highImage, 3f)//smol 1
//            );

            /**
             * including the reverse version cause I cant decide which is better.
             */


            MBFImage image1 = mh.makeHybrid(samClone, 2f, davClone, 3f);//reverse)
            downSample(image1);
//            ImageUtilities.write(downSample(image1), new File("SamAndDave.jpg"));
//            DisplayUtilities.display(
//                    image1
//            );

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



//            DisplayUtilities.display(image0);
//            DisplayUtilities.display(samp4);
//
//            DisplayUtilities.updateNamed("DownSample", image0, "");
//            DisplayUtilities.updateNamed("DownSample", samp4, "");
//            DisplayUtilities.positionNamed("DownSample", 100,100);
//

//            DisplayUtilities.displayLinked("DownSample", 5,samples);




        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static MBFImage downSample(MBFImage image){

        /**
         * downsampled versions
         */


        ResizeProcessor rp = new ResizeProcessor(1f);

        MBFImage canvas = new MBFImage(image.getWidth()*2,image.getHeight());

        MBFImage samp1 = image.clone();
        samp1 = rp.halfSize(samp1);


        MBFImage samp2 = samp1.clone();
        samp2 = rp.halfSize(samp2);


        MBFImage samp3 = samp2.clone();
        samp3  = rp.halfSize(samp3);


        MBFImage samp4 = samp3.clone();
        samp4 = rp.halfSize(samp4);


        int distAcrossCanvas = 0;

        canvas.drawImage(image, distAcrossCanvas,0);
        distAcrossCanvas+=image.getCols();

        canvas.drawImage(samp1, distAcrossCanvas,0);
        distAcrossCanvas+=samp1.getCols();

        canvas.drawImage(samp2, distAcrossCanvas,0);
        distAcrossCanvas+=samp2.getCols();

        canvas.drawImage(samp3, distAcrossCanvas,0);

        DisplayUtilities.display(canvas);

        return canvas;
    }
}
