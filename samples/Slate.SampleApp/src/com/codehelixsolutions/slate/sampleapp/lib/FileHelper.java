package com.codehelixsolutions.slate.sampleapp.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;

public class FileHelper {
private Context _context;
	
	
	public FileHelper(Context context)
	{
		_context = context;
	}
	
	// @summary: set content of storage file in central storage
	// @param: filename - name of the storage ( /data/data/com.company.appname/files  )
	// @param: content  - the content of the file.
	public void setStorageFileText(String fileName, String content)
	{
		FileOutputStream stream;
		try 
		{
			stream = _context.openFileOutput(fileName, Context.MODE_PRIVATE);
			stream.write(content.getBytes());
			stream.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	// @summary: Get storage file from central storage file name
	// @param: filename - name of the storage ( /data/data/com.company.appname/files  )
	public String getStorageFileText(String fileName)
	{
		FileInputStream stream;
		String content = "";
		try 
		{
			stream = _context.openFileInput(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		    StringBuilder sb = new StringBuilder();
		    String line = null;
		    while ((line = reader.readLine()) != null) 
		    {
		    	sb.append(line).append("\n");
		    }
		    reader.close();
		    content = sb.toString();		    
			stream.read();
			stream.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return content;
	}
		
	
	// @summary: Get storage file from central storage file name
	// @param: filename - name of the storage ( /data/data/com.company.appname/files  )
	public String getAssetsFileText(String fileName)
	{
		InputStream stream;
		String content = "";
		try 
		{
			AssetManager assets = _context.getAssets();
			stream = assets.open(fileName);
			int size = stream.available();
			byte[] buffer = new byte[size];
	        stream.read(buffer);
	        stream.close();
	        content = new String(buffer);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return content;
	}
	

	public void createFile(String name, String content) {
		setStorageFileText(name, content);
	}
	

	public boolean containsFile(String name) {
		File file = _context.getFileStreamPath(name);
		return file.exists();
	}
	

	public String getFileText(String name) {
		return getStorageFileText(name);	
	}
	

	public void deleteFile(String name) {
		_context.deleteFile(name);
	}
}
