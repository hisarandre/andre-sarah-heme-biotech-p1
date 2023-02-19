package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
  
    try {

      FileWriter fileWriter = new FileWriter("result.out", false);
      BufferedWriter writer = new BufferedWriter (fileWriter);

      for (Map.Entry<String, Integer> entry : symptoms.entrySet()){
        writer.write(entry.getKey() + " : " + entry.getValue());
        writer.newLine();
        System.out.println("Successfully wrote to the file.");
      }

      writer.close();
    }

    catch (IOException e) {
      e.printStackTrace();
      System.out.println("An error occurred.");
    }
  }
}