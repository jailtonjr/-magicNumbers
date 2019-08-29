package com.epam.numbers;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teste {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		
//		File file = new File(".//images//dog.png");
//		System.out.println(file.exists());
//		System.out.println("Nome do arquivo"+file.getName());
//		FileInputStream fis = new FileInputStream(file);
//		byte[] data = fis.readAllBytes();
//		
		byte[] content = Files.readAllBytes(Paths.get("images/eu.png"));
	    System.out.println(new String(content));
		
		
//		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
//		int fileSignature = input.readInt();
//		
		
		
//		// read fixed amount of bytes
//		int u1 = input.readUnsignedByte();
//		System.out.println("UnsignedByte"+u1);
//		
//		int u2 = input.readUnsignedShort();
//		System.out.println("UnsignedShort"+u2);
//		
//		int u4 = input.readInt();
//		System.out.println("readInt"+u4);
//		
//		// read variable amount of bytes
//		int length = 4;
//		byte[] bytes = new byte[length];
		
		
//		input.close();
		
		
		
	}
	
	
	private static void readMagic(DataInput in) throws IOException {
	    int magic = in.readInt();
	    if(magic != 0xCAFEBABE){
	        throw new IllegalArgumentException("Magic is expected to be 0xCAFEBABE. " +
	                "Argument is not a Java Class File!");
	    }
	}

}
