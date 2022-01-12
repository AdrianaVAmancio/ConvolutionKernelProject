package ie.gmit.dip;

public class ImageFilter {// add and delete methods

	private static final int INITIAL_CAPACITY = 20;// capacity of the array
	private Image[] images = null;// array of images that will be created

	public ImageFilter() {
		images = new Image[INITIAL_CAPACITY];
	}

	public boolean add(Image img) {
		for (int i = 0; i < images.length; i++)
			;
		{
			int i = 0;
			if (images[i] == null) {
				images[i] = img;
				return true;
			}
		}
		return false;

	}

	public boolean delete(String fileName) {
		for (int i = 0; i < images.length; i++)
			;
		{
			int i = 0;
			if (images[i] != null && images[i].getImageName().equals(fileName)) {
				images[i] = null;
				return true;

			}
		}

		return false;
	}

	public int size() {
		int total = 0;
		for (int i = 0; i < images.length; i++) {
			if (images[i] != null)
				total++;
		}
		return total;
	}

}
