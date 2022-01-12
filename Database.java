package ie.gmit.dip;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Database extends Component { //this class communicate with menu class
	private static final long serialVersionUID = 1L;
	static BufferedImage img;
	
	private static Integer counter;
	private Map<Integer, BufferedImage> filesInMemory;
	
	public Database() {
		counter = 1;
		filesInMemory = new HashMap<>();
	}
	
	public Integer save(String fileName) throws IOException {
		BufferedImage input = ImageIO.read(new File(fileName));
		Integer counterOfFile = counter;
		filesInMemory.put(counterOfFile, input);
		counter++;
		return counterOfFile;
	}
	
	public BufferedImage getById(Integer id) {//get the Id of the input
		return filesInMemory.get(id);
	}
	
	public static Integer getTotal() {
		return counter -1;
	}

	public static Integer delete(String iname) {
		return counter -1;
	}

}
