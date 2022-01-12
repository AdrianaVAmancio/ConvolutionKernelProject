package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Kernel {
 
	public static final double[][] IDENTITY = {
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
	};
	
	
	
	public static final double[][] EDGE_DETECTION_1 = {
			{-1, -1, -1},
			{-1, 8, -1},
			{-1, -1, -1}
	};
	
	
	public static final double[][] EDGE_DETECTION_2 = {
			{1, 0, -1},
			{0, 0, 0},
			{-1, 0, 1}
	};
	
	
	public static final double[][] LAPLACIAN = {
			{0, -1, 0},
			{-1, 4, -1},
			{0, -1, 0}
	};


	public static final double[][] SHARPEN = {
			{0, -1, 0},
			{-1, 5, -1},
			{0, -1, 0}
	};


	public static final double[][] VERTICAL_LINES = {
			{-1, 2, -1},
			{-1, 2, -1},
			{-1, 2, -1}
	};
	
	
	public static final double[][] HORIZONTAL_LINES = {
			{-1, -1, -1},
			{2, 2, 2},
			{-1, -1, -1}
	};
	
	
	public static final double[][] DIAGONAL_45_LINES = {
			{-1, -1, 2},
			{-1, 2, -1},
			{2, -1, -1}
	};

	
	public static final double[][] BOX_BLUR = {
			{0.111, 0.111, 0.111},
			{0.111, 0.111, 0.111},
			{0.111, 0.111, 0.111}
	};
	
	public static final double[][] SOBEL_HORIZONTAL = {
			{-1, -2, -1},
			{0, 0, 0},
			{1, 2, 1}
	};
	
	
	public static final double[][] SOBEL_VERTICAL = {
			{-1, 0, 1},
			{-2, 0, 2},
			{-1, 0, 1}
	};


public BufferedImage apply(double[][] filter, BufferedImage image){
		
		int WIDTH = image.getWidth();
		int HEIGHT = image.getHeight();
		
		BufferedImage output = new BufferedImage(WIDTH, HEIGHT, image.getType());
		 
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
		 
				int pixel = image.getRGB(x, y);
				
				double pixelConvoluted = singlePixelConvolution(image, x, y, filter, 3,3);
				
				int R = ((int)pixelConvoluted >> 16) & 0xff; // Red Value
				int G = ((int)pixelConvoluted >> 8) & 0xff;	// Green Value
				int B = ((int)pixelConvoluted) & 0xff;		// Blue Value
			
				output.setRGB(x, y, new Color(R,G,B).getRGB());
		 
			}
		}
		
		return output;
	}
	
	private double singlePixelConvolution(BufferedImage image, int x, int y, double[][] k, int kernelWidth, int kernelHeight) {
		double output = 0;
		for (int i = 0; i < kernelWidth; ++i) {
			for (int j = 0; j < kernelHeight; ++j) {
				try {
					output = output + (image.getRGB(x + i,y + j) * k[i][j]);
				}catch (Exception e) {
					output = image.getRGB(x,y);
				}
				
			}
		}
		return output;
	}
	
}	

