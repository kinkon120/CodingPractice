package com.yichin.daily.copyToDifficulty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyToDifficultCategory {

	private static final String hardFolder = ".\\src\\com\\yichin\\leetcode\\D_hard";
	private static final String midFolder = ".\\src\\com\\yichin\\leetcode\\D_medium";
	private static final String easyFolder = ".\\src\\com\\yichin\\leetcode\\D_easy";

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String rootDir = ".\\src\\com\\yichin\\leetcode";
		File folder = new File(rootDir);
		File[] listOfFiles = folder.listFiles();
		
		for(File file : listOfFiles){
			String [] dirs = file.getName().split("\\\\");		
			String lastDir = dirs[dirs.length-1];
			String [] lastDirSplit = lastDir.split("_");
			if(lastDirSplit[0].equals("C")) {
				processOneCategory(file);
			}
		}
	}
	
	private static void processOneCategory(File dir) throws IOException{
		File[] listOfFiles = dir.listFiles();
		for(File questionDir : listOfFiles) {
			copyToDiffCategory(questionDir);
		}
	}
	
	private static void copyToDiffCategory(File dir) throws IOException{
		File[] listOfFiles = dir.listFiles();
		
		String lastDir = getLastPart(dir);
		
		String dstDir = null;
		if (lastDir.charAt(0) == 'H')	dstDir=hardFolder;
		else if (lastDir.charAt(0) == 'M') dstDir=midFolder;
		else dstDir = easyFolder;
		
		// 檢查有無資料夾, 沒有的話則創建
		File dstFolder = new File(dstDir+ "\\P" +lastDir.substring(1));
		if(!dstFolder.exists()){
			dstFolder.mkdirs();	
		}
		
		for(File file : listOfFiles) {
			// 讀取整個檔案, 改寫package name...
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);	        
	        FileWriter fw = new FileWriter(dstFolder.getPath()+"\\"+getLastPart(file));
	        
	        String line = null;
            while ((line = br.readLine()) != null) {
            	String [] strs = line.split(" ");
            	if(strs.length >= 1 &&  strs[0].equals("package")){
            		String pkgLine = String.format("package com.yichin.leetcode.%s.%s;", getLastPart(dstDir), getLastPart(dstFolder));
            		fw.write(pkgLine+"\n");
            	} else {
            		fw.write(line+"\n");
            	}
            }

	        
	        fr.close();
			fw.close();
		}
	}
	
	private static String getLastPart(File file) {	
		return getLastPart(file.getName());
	}
	
	private static String getLastPart(String str) {
		String [] strs = str.split("\\\\");	
		return strs[strs.length-1];
	}

}
