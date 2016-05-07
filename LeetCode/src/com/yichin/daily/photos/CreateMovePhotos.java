package com.yichin.daily.photos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreateMovePhotos {

	// This is to put iphone pictures into corresponding directory
	public static void main(String[] args) {

		List<String> fns = new ArrayList<>();
		// fns.add("D:\\iphone 照片\\2016_01");
		for(String fn : fns){
			processOneFolder(fn);
		}
		
	}

	static void processOneFolder(String fn) {
		File folder = new File(fn);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String fileName = listOfFiles[i].getName();
				String[] strs = fileName.split("-");
				String month = strs[1];
				String day = strs[2].substring(0, 2);
				String folderName = fn + "\\" + month + day;
				
				File f = new File(folderName);

				if (!f.exists()) {
					f.mkdir();
				}

				// copy
				if (listOfFiles[i].renameTo(new File(folderName + "\\" + fileName))) {
					System.out.println(fileName+ " is moved successful!");
				} else {
					System.out.println(fileName+ " is failed to move!");
				}
			}
		}
	}

}
