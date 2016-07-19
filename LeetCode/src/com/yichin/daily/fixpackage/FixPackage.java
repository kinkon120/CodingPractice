package com.yichin.daily.fixpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixPackage {
	public static void main(String[] args) throws IOException {
		String rootDir = "C:\\workspace\\CodingPractice\\LeetCode\\src\\com\\yichin\\";
		
		//String rootDir = "C:\\workspace\\CodingPractice\\LeetCode\\src\\com\\yichin\\leetcode";
		
		checkDir(rootDir);
	}

	static void checkDir(String dir) throws IOException{
		File folder = new File(dir);		
		
		File[] listOfFiles = folder.listFiles();
		String [] packageNames = dir.split("\\\\");		
		String last2PackageName = packageNames[packageNames.length-2]+"."+packageNames[packageNames.length-1];
		System.out.println(last2PackageName);
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// read file and check package name
				checkPackage(dir+"\\"+listOfFiles[i].getName(), last2PackageName);
				System.out.println("File " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				// go to deeper
				checkDir(dir+"\\"+listOfFiles[i].getName());
			}
		}		
	}
	
	static void checkPackage(String fin, String rightPackageName) throws IOException{
		FileInputStream fis = new FileInputStream(fin);
		 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		line = br.readLine();
		if(line != null){
			String [] splits = line.split("\\.");
			String last2Part = splits[splits.length-2];
			String lastPart = splits[splits.length-1];
			lastPart = lastPart.substring(0, lastPart.length()-1);	// skip semicolon
			String comparedPart = last2Part+"."+lastPart;
			if(!comparedPart.equals(rightPackageName)){
				// do correction here
				//line.replace(comparedPart, rightPackageName);
				
				
				Path path = Paths.get(fin);
				Charset charset = StandardCharsets.UTF_8;

				String content = new String(Files.readAllBytes(path), charset);
				content = content.replaceAll(comparedPart, rightPackageName);
				Files.write(path, content.getBytes(charset));

			}
		}		
	}
}
