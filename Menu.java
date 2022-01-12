package ie.gmit.dip;
//    /Users/adrianavieira/eclipse-workspace/ConvolutionKernelProject/src/imags/image2.png

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

public class Menu {// display options to the user

	Map<Integer, double[][]> filter; // using map/hashMap to display filter options to the user chose
	Map<Integer, String> description;

	private Scanner sc;
	private boolean keepRunning = true;

	private Database database;
	private Kernel kernel;

	public Menu() {
		sc = new Scanner(System.in);
		database = new Database();

		filter = new HashMap<>();
		description = new HashMap<>();

		filter.put(1, Kernel.IDENTITY);
		filter.put(2, Kernel.EDGE_DETECTION_1);
		filter.put(3, Kernel.EDGE_DETECTION_2);
		filter.put(4, Kernel.LAPLACIAN);
		filter.put(5, Kernel.SHARPEN);
		filter.put(6, Kernel.VERTICAL_LINES);
		filter.put(7, Kernel.HORIZONTAL_LINES);
		filter.put(8, Kernel.DIAGONAL_45_LINES);
		filter.put(9, Kernel.BOX_BLUR);
		filter.put(10, Kernel.SOBEL_HORIZONTAL);
		filter.put(11, Kernel.SOBEL_VERTICAL);

		description.put(1, "1 - IDENTITY");
		description.put(2, "2 - EDGE_DETECTION_1");
		description.put(3, "3 - EDGE_DETECTION_2");
		description.put(4, "4 - LAPLACIAN");
		description.put(5, "5 - SHARPEN");
		description.put(6, "6 - VERTICAL_LINES");
		description.put(7, "7 - HORIZONTAL_LINES");
		description.put(8, "8 - DIAGONAL_45_LINES");
		description.put(9, "9 - BOX_BLUR");
		description.put(10, "10 - SOBEL_HORIZONTAL");
		description.put(11, "11 - SOBEL_VERTICAL");

		kernel = new Kernel();

	}

	public void start() throws IOException {

		while (keepRunning) {
			showOptions();

			int choice = Integer.parseInt(sc.next());

			switch (choice) {
			case 1 -> add();
			case 2 -> delete();
			case 4 -> searchByImageName();
			case 5 -> applyFilter();
			case 6 -> total();
			case 7 -> {
				System.out.println("[INFO] Shutting down... please wait...");
				keepRunning = false;
			}
			default -> System.out.println("[ERROR] Option not available");
			}
		}
	}

	private void add() {

		System.out.println("Add an Image>");

		System.out.println("Enter Image Name>");
		String fileName = sc.next();
		Integer idFile;

		try {
			idFile = database.save(fileName);
			System.out.println("[INFO] Image added okay Id: " + idFile + ". There are now " + database.getTotal() + " records in the database.");
		} catch (IOException e) {
			System.out.println("[INFO] Error while saving file.");
		}

	}

	private void searchByImageName() {
		System.out.println("[INFO] Search for Image by name");
		System.out.println("Enter Image name Name>");
		String fileName = sc.next();
		System.out.println("[INFO] " + fileName + " was found in the database.");

	}

	private void delete() throws IOException {// method to delete an image, use the image ID(integer) generate in the
												// add method to delete
		System.out.println("[INFO] Delete an Image");
		System.out.println("Enter Image Id: ");
		String fileName = sc.next();
		Integer idFile;
		idFile = Database.delete(fileName);
		System.out.println(
				"[INFO] Image deleted okay. There are now " + Database.getTotal() + " records in the database.");

	}

	private void applyFilter() { // apply method take an input and convert it to an integer, after shows the user
									// the HashMap options with the Kernel Filters
		System.out.println("The available filters are:");

		System.out.println("Select a filter");
		description.values().forEach(value -> System.out.println(value));

		Integer answer = sc.nextInt();

		double[][] chosenFilter = filter.get(answer);

		System.out.println("What file do you want to apply?");

		Integer fileChoosen = sc.nextInt();

		BufferedImage imageChosen = database.getById(fileChoosen);

		BufferedImage imageProcessed = kernel.apply(chosenFilter, imageChosen);

		try {
			ImageIO.write(imageProcessed, "PNG", new File("outputFileName"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void total() {
		System.out.println("[INFO] Get total number of Images");
		int total = database.getTotal();
		System.out.println("[INFO] " + total + " images found in the database.");
	}

	private void showOptions() {

		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*                                                 *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		System.out.println("1) Add Image to database");
		System.out.println("2) Delete Image");
		System.out.println("4) Search Image by name");
		System.out.println("5) Apply a Filter");
		System.out.println("6) Get total Number of Images");
		System.out.println("8) Quit");
		System.out.println("\nSelect Option [1-9]>");

	}

}
