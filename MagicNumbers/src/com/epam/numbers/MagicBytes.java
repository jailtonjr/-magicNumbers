package com.epam.numbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBytes {


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String fileName = "";

		do {
			// read the file from terminal input Ex.: /MagicNumbers/MagicNumbers/images/cat.jpg
			System.out.println("Insert the file URL to check or 'Exit' to finish the application: \n");
			Scanner input = new Scanner(System.in);
			fileName = input.nextLine();
			input.close();

			//Extract extension file and check Magic Number
			switch (validateAllowedExtensions(fileName)) {

			case ".GIF":
				// validate if the GIF file is a real GIF file by its magic number
				String MagicNumberGIF = validateMagicNumber(fileName, 0 , 6);
				if(MagicNumberGIF.equalsIgnoreCase("474946383761")||MagicNumberGIF.equalsIgnoreCase("474946383961")) {
					System.out.println("The GIF file"+fileName+" has a valid Magic Number: "+MagicNumberGIF);
				}else {
					System.out.println("The GIF file"+fileName+" is NOT a valid file. [Magic Number: "+MagicNumberGIF+"]");
				}

				break;

			case ".TXT":
				// validate if the TXT file is a real TXT file by its magic number
				String MagicNumberTXT = validateMagicNumber(fileName, 0 , 4);
				if(MagicNumberTXT.equalsIgnoreCase("3C69")) {
					System.out.println("The TXT file"+fileName+" has a valid Magic Number: "+MagicNumberTXT);
				}else {
					System.out.println("The TXT file"+fileName+" is NOT a valid file. [Magic Number: "+MagicNumberTXT+"]");
				}

				break;

			case ".JPG":	
				// validate if the JPG file is a real JPG file by its magic number
				String MagicNumberJPG = validateMagicNumber(fileName, 0 , 2);
				if(MagicNumberJPG.equalsIgnoreCase("FFD8")) {
					System.out.println("The JPG file"+fileName+" has a valid Magic Number: "+MagicNumberJPG);
				}else {
					System.out.println("The JPG file"+fileName+" is NOT a valid file. [Magic Number: "+MagicNumberJPG+"]");

				}

				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + validateAllowedExtensions(fileName));
			}


		} while (!fileName.equalsIgnoreCase("Exit"));

	}


	static String validateAllowedExtensions(String fileURI) {

		//Get the file name from the whole path
		Path path = Paths.get(fileURI);
		String fileName = path.getFileName().toString();

		//Get the index based on the extension into the string
		int lastIndex = fileName.lastIndexOf(".");

		//Get substring/extension from the string
		String extension = fileName.substring(lastIndex).toUpperCase();

		if (extension.equalsIgnoreCase(".GIF")) {
			return extension;
		}

		if (extension.equalsIgnoreCase(".JPG")) {
			return extension;
		}

		if (extension.equalsIgnoreCase(".TXT")) {
			return extension;
		}

		// There is no extension for the file
		if (lastIndex == -1) {
			return "";
		}

		// No valid extension
		return "";

	}

	static String validateMagicNumber(String fileName, int offset, int tamBytes) {

		Path path = Paths.get(fileName);
		String MagicNumber = "";
		try {
			byte[] bArray = Files.readAllBytes(path);
			// reading magic number from byte array
			byte[] magicNumber = new byte [1];
			magicNumber = Arrays.copyOfRange(bArray, offset, tamBytes);
			//off-set dinamico e tamanho em bytes do magic number

			for (int i = 0; i < magicNumber.length; i++){
				//				System.out.print(Integer.toHexString(magicNumber[i] & 0xFF).toUpperCase());
				MagicNumber += Integer.toHexString(magicNumber[i] & 0xFF).toUpperCase();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return MagicNumber;

	}

}
