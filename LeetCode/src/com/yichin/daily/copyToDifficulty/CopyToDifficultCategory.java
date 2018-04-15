package com.yichin.daily.copyToDifficulty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CopyToDifficultCategory {

	// TODO: 以difficulty 為source, java file第二行寫明屬於哪些類別, 再copy到各個類別去
	// 現在是
	
	private static final String HARD_FOLDER = ".\\src\\com\\yichin\\leetcode\\D_hard";
	private static final String MID_FOLDER = ".\\src\\com\\yichin\\leetcode\\D_medium";
	private static final String EASY_FOLDER = ".\\src\\com\\yichin\\leetcode\\D_easy";
	private static final boolean IS_DEBUG = false;

	private static Map<String, List<String>> map;
	private static int numDirSkipped;
	private static int numDirAdded;
	private static int numFilesSkipped;


	public static void main(String[] args) throws IOException {
		cleanOldData();
		numDirSkipped = 0;
		numDirAdded = 0;
		numFilesSkipped = 0;
		
		map = new HashMap<String, List<String>>();

		String rootDir = ".\\src\\com\\yichin\\leetcode";
		File folder = new File(rootDir);
		File[] typeCategoryDirs = folder.listFiles();

		// typeCategoryDir is like ".\src\com\yichin\leetcode\C_array"
		for (File typeCategoryDir : typeCategoryDirs) { 
			// lastDirName is like "C_array"
			String dirName = getLastPart(typeCategoryDir,1); 
			String[] lastDirSplit = dirName.split("_");
			if (lastDirSplit[0].equals("C")) {
				processOneCategory(typeCategoryDir);
			}
		}

		if(IS_DEBUG) {
			for (Entry<String, List<String>> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		
		
			System.out.println(numDirAdded + " directories are added");
			System.out.println(numDirSkipped + " directories are skipped");
			System.out.println(numFilesSkipped + " files are skipped");
		}
	}

	private static void processOneCategory(File typeCategoryDir)
			throws IOException {
		File[] questionDirs = typeCategoryDir.listFiles();
		// questionDir is like ".\src\com\yichin\leetcode\C_array\E001_TwoSum"
		for (File questionDir : questionDirs) { 
			copyToDifficultyCategory(questionDir);
		}
	}

	private static void copyToDifficultyCategory(File questionDir)
			throws IOException {
		File[] javaFiles = questionDir.listFiles();

		// dirName is like "E001_TwoSum"
		String dirName = getLastPart(questionDir, 1); 

		String dstDirPath = null;
		if (dirName.charAt(0) == 'H')
			dstDirPath = HARD_FOLDER;
		else if (dirName.charAt(0) == 'M')
			dstDirPath = MID_FOLDER;
		else
			dstDirPath = EASY_FOLDER;

		// 檢查有無資料夾, 沒有的話則創建
		File dstFolder = new File(dstDirPath + "\\P" + dirName.substring(1));

		if (!dstFolder.exists()) {
			dstFolder.mkdirs();
			List<String> typeCategories = new ArrayList<String>();
			map.put(dirName, typeCategories);
			numDirAdded++;
		} else {
			numDirSkipped++;
		}
		
		// 統計這個問題在哪些類別出現過
		String categoryName = getLastPart(questionDir, 2);
		map.get(dirName).add(categoryName);

		// write into file
		for (File file : javaFiles) {
			File checkFileIsThere = new File(dstFolder.getPath() + "\\"
					+ getLastPart(file, 1));
			if (checkFileIsThere.exists() && IS_DEBUG) {
				System.out.println("File existed: "
						+ checkFileIsThere.getAbsolutePath());
				System.out.println("\tduplicate source: "
						+ categoryName);
				numFilesSkipped++;
			}

			// 讀取整個檔案, 改寫package name...
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			FileWriter fw = new FileWriter(dstFolder.getPath() + "\\"
					+ getLastPart(file, 1));

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] strs = line.split(" ");
				if (strs.length >= 1 && strs[0].equals("package")) {
					String pkgLine = String.format(
							"package com.yichin.leetcode.%s.%s;",
							getLastPart(dstDirPath, 1), getLastPart(dstFolder, 1));
					fw.write(pkgLine + "\n");
				} else {
					fw.write(line + "\n");
				}
			}
			fr.close();
			fw.close();
		}
	}

	private static String getLastPart(File file, int offset) {
		return getLastPart(file.getPath(), offset);
	}

	private static String getLastPart(String str, int offset) {
		String[] strs = str.split("\\\\");
		if(strs.length - offset >=0){
			return strs[strs.length - offset];
		}
		return null;
	}

	private static void cleanOldData() {
		deleteDirectory(new File(HARD_FOLDER));
		deleteDirectory(new File(MID_FOLDER));
		deleteDirectory(new File(EASY_FOLDER));
	}

	private static boolean deleteDirectory(File directoryToBeDeleted) {
		File[] allContents = directoryToBeDeleted.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteDirectory(file);
			}
		}
		return directoryToBeDeleted.delete();
	}
}
