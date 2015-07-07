package me.Bedwars.WorldReset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class WorldReset
{
  public static void startDeleting(String path)
  {
    List<String> filesList = new ArrayList();
    List<String> folderList = new ArrayList();
    fetchCompleteList(filesList, folderList, path);
    for (String filePath : filesList)
    {
      File tempFile = new File(filePath);
      tempFile.delete();
    }
    for (String filePath : folderList)
    {
      File tempFile = new File(filePath);
      tempFile.delete();
    }
  }
  
  private static void fetchCompleteList(List<String> filesList, List<String> folderList, String path)
  {
    File file = new File(path);
    File[] listOfFile = file.listFiles();
    for (File tempFile : listOfFile) {
      if (tempFile.isDirectory())
      {
        folderList.add(tempFile.getAbsolutePath());
        fetchCompleteList(filesList, 
          folderList, tempFile.getAbsolutePath());
      }
      else
      {
        filesList.add(tempFile.getAbsolutePath());
      }
    }
  }
  
  public static void copyFolder(File src, File dest)
    throws IOException
  {
    if (src.isDirectory())
    {
      if (!dest.exists())
      {
        dest.mkdir();
        System.out.println("Directory copied from " + src + "  to " + dest);
      }
      String[] files = src.list();
      for (String file : files)
      {
        File srcFile = new File(src, file);
        File destFile = new File(dest, file);
        copyFolder(srcFile, destFile);
      }
    }
    else
    {
      InputStream in = new FileInputStream(src);
      OutputStream out = new FileOutputStream(dest);
      
      byte[] buffer = new byte[1024];
      int length;
      while ((length = in.read(buffer)) > 0)
      {
        int length;
        out.write(buffer, 0, length);
      }
      in.close();
      out.close();
      System.out.println("File copied from " + src + " to " + dest);
    }
  }
}
