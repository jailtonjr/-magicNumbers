package com.epam.numbers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Test3 {

	// parametros para a funcao
	// arquivo, off-set, tamanho em bytes do magic number
	public static void main(String[] args) throws IOException {

		// Get file's path
		Path path = Paths.get(".//images//Teste.class");
		try {
			byte[] bArray = Files.readAllBytes(path);
			// reading magic number from byte array
			byte[] magicNumber = new byte [1];
			magicNumber = Arrays.copyOfRange(bArray, 0, 4);
			//off-set dinamico e tamanho em bytes do magic number
			String MagicNumber = "";
			for (int i = 0; i < magicNumber.length; i++){
//				System.out.print(Integer.toHexString(magicNumber[i] & 0xFF).toUpperCase());
				MagicNumber += Integer.toHexString(magicNumber[i] & 0xFF).toUpperCase();

			}
			
			System.out.println("Magic number: "+MagicNumber);

		} catch (IOException e) {
			e.printStackTrace();
		}       
	}

}
