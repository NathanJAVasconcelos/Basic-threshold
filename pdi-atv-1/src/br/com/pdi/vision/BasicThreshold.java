package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicThreshold {

	BufferedImage image;
	int width, height, red, green, blue, orange;
	int threshold = 560;
		
	public void run() throws IOException {
		File input = new File("C:\\pdi\\atv1\\image1.jfif");
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));
				
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();
				
				/* Composição da cor laranja tende a ser: rgb(255,165,0), fazendo testes com o threshold 
				 * acabei chegando na formula abaixo.
				 */
				
				orange = red*3 + green/6 - blue;
				
				
				if(orange > threshold) {
					image.setRGB(j, i, Color.WHITE.getRGB());
				}else {
					image.setRGB(j, i, Color.BLACK.getRGB());
				}
				
								
			}			
		}
		
		File output = new File("C:\\pdi\\atv1\\re\\image1_orange.jpg");
		ImageIO.write(image, "jpg", output);
		
		System.out.println("Done!");
		
	}
	
	public static void main(String[] args) {
		try {
			new BasicThreshold().run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
