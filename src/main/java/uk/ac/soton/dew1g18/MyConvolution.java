package uk.ac.soton.dew1g18;

import org.openimaj.image.FImage;
import org.openimaj.image.pixel.Pixel;
import org.openimaj.image.processor.SinglebandImageProcessor;

public class MyConvolution implements SinglebandImageProcessor<Float, FImage> {
    private float[][] kernel;

    public MyConvolution(float[][] kernel) {
        //note that like the image pixels kernel is indexed by [row][column]
        this.kernel = kernel;
    }

    @Override
    public void processImage(FImage image) {
        // convolve image with kernel and store result back in image
        //
        // hint: use FImage#internalAssign(FImage) to set the contents
        // of your temporary buffer image to the image.

        /**
         * Loop through the FImage's pixels, use the kernel (Flipped XY) to mutate pixels (and zero pad the
         * outer edges) and print to the new Image
         */

        FImage output = image.clone();
        //Start with dimensions like the example
        int imRows = image.getRows();
        int imCols = image.getCols();
        int kerRows= this.kernel.length;
        int kerCol = this.kernel[0].length;

        float trFl = (float) Math.floor(kerRows/2);
        float tcFl = (float) Math.floor(kerCol/2);
        int tr = Integer.parseInt(Double.toString(trFl).replaceAll(".0", ""));
        int tc = Integer.parseInt(Double.toString(tcFl).replaceAll(".0", ""));


        System.out.println(kerCol);
        System.out.println(kerRows);

        for (int x = tc+1; x<imCols-tc-1; x++ ){
            for (int y=tr+1; y<imRows-tr-1; y++){
                /**
                 * Cutting off the borders of the image in the loops
                 */
//                System.out.println(x+"  "+y);
                float sum = 0;
//                for (int iwin=1; iwin<kerCol; iwin++){
//                    for (int jwin=1; jwin<kerCol; jwin++){
//                        sum= sum+image.pixels[y+iwin-tr-1][x+jwin-tc-1]*kernel[kerRows-jwin+1][kerCol-iwin+1];


                for(int iwin=kerCol-1;iwin>-1; iwin-- ){
//                    System.out.println(iwin);
                    for (int jwin=kerRows-1; jwin>-1; jwin--){

//                        System.out.println(x+":"+y);
//                        System.out.println(iwin+" : "+jwin);
//                        System.out.println(tc+" : "+tr);
//                        System.out.println(imCols+" : "+imRows);
//                        sum= sum+image.pixels[y+iwin-tr-1][x+jwin-tc-1]*kernel[kerRows-jwin+1][kerCol-iwin+1];

                        sum= sum+image.pixels[y+jwin-tr-1][x+iwin-tc-1]*kernel[jwin][iwin];
//                        System.out.println("pixel done");

                    }
                }
//                System.out.println(imRows);
                image.setPixel(x,y, sum);
            }
        }

    }
}