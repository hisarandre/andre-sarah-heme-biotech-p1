package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

  private ISymptomReader reader;
  private ISymptomWriter writer;

  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }

  /**
   * Counts the occurrences of each symptom.
   *  
   * @param symptoms is a list of all symptoms
   * @return a map list of counted symptoms
   */
  public Map<String, Integer> countSymptoms(List<String> symptoms) { 
    Map<String, Integer> countedSymptoms = new HashMap<String, Integer>();

    for (String symptom : symptoms) {
      Integer count = countedSymptoms.get(symptom);
      countedSymptoms.put(symptom, (count == null) ? 1 : count + 1);
    }

    return countedSymptoms;
  }

  /**
   * Sort the symptoms by alphabetical order.
   *
   * @param symptoms is a list of all counted symptoms
   * @return a map list of counted and sorted symptoms
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);
    return sortedSymptoms;
  }

  /**
   * Write counted and sorted symptoms in a new file.
   *
   * @param symptoms is a list of all counted and sorted symptoms
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    this.writer.writeSymptoms(symptoms);
  }

}