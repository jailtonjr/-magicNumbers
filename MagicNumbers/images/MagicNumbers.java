package com.epam.numbers;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MagicNumbers {
	
	
	public static void main(String[] args) throws IOException {

		String fileName;
		
		do {

			System.out.println("Insert the file URL to check or 'Exit' to finish the application: \n");
			Scanner input = new Scanner(System.in);
			fileName = input.nextLine();
			input.close();
			
			
			if (!fileName.equalsIgnoreCase("Exit")) {
				
				//call method to validate the file
				isFileValid(new File(fileName));	
			}
			

		} while (!fileName.equalsIgnoreCase("Exit"));

		

	}

	static boolean isFileValid(File file) throws IOException {
		
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		byte [] arrayByte = new byte[12];
		int fileSignature = 0;
		
		
		input.read(arrayByte, 0, 12);
		System.out.println("byte: "+Arrays.toString(arrayByte));
		
		
        byte[] magicNumberBytes = new byte[4];

        for (byte b : magicNumberBytes) {
            System.out.print(Integer.toHexString(b) + " ");
        }
		
		
		input.close();
		
		System.out.println("Assinatura do Arquivo: "+fileSignature);

		if (fileSignature == 0xffd8) {
			System.out.println("File eh jpeg");
			return true;
		} else if (fileSignature == 0x89504E47) {
			System.out.println("file is in PNG");
			return true;
		} else {
			
			System.out.println("Nao eh arquivo valido");
			return false;
		}
	}
	
	
	String validateAllowedExtensions(File fileNamePath) {
		
		//Get the file name from the whole path
		String fileName = fileNamePath.getName();
		
		//Get the index based on the extension into the string
		int lastIndex = fileName.lastIndexOf(".");
		
		//Get substring/extension from the string
		String extension = fileName.substring(lastIndex).toUpperCase();
		
		if (extension.equalsIgnoreCase("GIF")) {
			return extension;
		}
		
		if (extension.equalsIgnoreCase("JPG")) {
			return extension;
		}
		
		if (extension.equalsIgnoreCase("TXT")) {
			return extension;
		}
		
		// There is no extension for the file
		if (lastIndex == -1) {
			return "";
		}
		
		// No valid extension
		return "";
		
	}
	
	boolean validateMagicNumber(File fileName, String extension) {
		
		
		
		return false;
		
	}
	

}
