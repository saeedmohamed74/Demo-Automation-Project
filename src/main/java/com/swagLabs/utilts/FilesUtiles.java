package com.swagLabs.utilts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtiles {

    private FilesUtiles() {
        super();
    }
    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtil.warn("No files found in directory: " + folderPath);
            return null;
        }
    File latestFile = files[0];
      for (File file : files){
          if (file.lastModified() > latestFile.lastModified()){
              latestFile = file;
          }
      }
      return latestFile;
    }

    public static void deleteFiles(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            LogsUtil.warn("Directory does not Exist " + dirPath);
            return;
        }

        File[] fileList = dirPath.listFiles();
        if (fileList == null) {
            LogsUtil.warn("Failed to list files in " + dirPath);
            return;
        }
        for (File file : fileList) {

            if (file.isDirectory()) {
                deleteFiles(file);
                LogsUtil.info("File is deleted successfully: "+ file);
            } else {
                try {
                    Files.delete(file.toPath());
                    LogsUtil.info("File is deleted successfully: "+ file);
                } catch (IOException e) {
                    LogsUtil.error("Failed to delete file: " + file);
                }
            }

        }
    }


}



