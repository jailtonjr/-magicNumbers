package com.epam.numbers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Paths;

public class Test2 {

	public static void main(String[] args) throws IOException {

		convertToHex(System.out, new File(".//images//globe.gif"));
		
		
//		File file = new File(".//images//Teste.class");
//
//		// Using java.io.FileInputStream
//		byte[] bArray = readFileToByteArray(file);
//		//displaying content of byte array
//		for (int i = 0; i < bArray.length; i++){
//			System.out.print((char)bArray[i]);
//		}  

	}
	
	 /**
     * This method uses java.io.FileInputStream to read
     * file content into a byte array
     * @param file
     * @return
     */
    private static byte[] readFileToByteArray(File file){
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();        
            
        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
        return bArray;
    }
    
    
    public static void convertToHex(PrintStream out, File file) throws IOException {
	InputStream is = new FileInputStream(file);
	 
	int bytesCounter =0;		
	int value = 0;
	StringBuilder sbHex = new StringBuilder();
	StringBuilder sbText = new StringBuilder();
	StringBuilder sbResult = new StringBuilder();
			
	while ((value = is.read()) != -1) {    
	    //convert to hex value with "X" formatter
            sbHex.append(String.format("%02X ", value));
	             
	    //If the chracater is not convertable, just print a dot symbol "." 
	    if (!Character.isISOControl(value)) {
	      	sbText.append((char)value);
	    }else {
	        sbText.append(".");
	    }
	            
	    //if 16 bytes are read, reset the counter, 
            //clear the StringBuilder for formatting purpose only.
	    if(bytesCounter==15){
	      	sbResult.append(sbHex).append("      ").append(sbText).append("\n");
	       	sbHex.setLength(0);
	        sbText.setLength(0);
	       	bytesCounter=0;
	    }else{
	        bytesCounter++;
	    }
       }
			
	//if still got content
	if(bytesCounter!=0){			
	     //add spaces more formatting purpose only
	    for(; bytesCounter<16; bytesCounter++){
		//1 character 3 spaces
		sbHex.append("   ");
	    }
	    sbResult.append(sbHex).append("      ").append(sbText).append("\n");
        }

        out.print(sbResult);
        is.close();
  }
	

}
