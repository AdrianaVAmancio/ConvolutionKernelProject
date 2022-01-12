package ie.gmit.dip;

import java.io.Serializable;

public class Image implements Serializable {
	private static final long serialVersionUID = 777L;

	private String Image;
	private String ImageName;

	public Image(String newImage) {
		this.Image = newImage;
	}

	public Image(String image, String imageName, String kernelFilter, String parameters, String colour) {
		this(image);
		this.ImageName = imageName;

	}

	public String getImage() {
		return Image;
	}
	
	public String getImageName() {
		return ImageName;
	}
}
