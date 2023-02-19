package com.hemebiotech.analytics;

import com.hemebiotech.analytics.AnalyticsCounter;
import com.hemebiotech.analytics.ISymptomReader;
import com.hemebiotech.analytics.ISymptomWriter;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.WriteSymptomDataToFile;

import java.util.List;
import java.util.Map;

public class Main {

  private static final String SYMPTOMSFILE = "symptoms.txt";
  private static final String RESULTFILE = "result.out";

  /**
   Main method.
   @param args The command line arguments
   */
  public static void main(String[] args) {

    ISymptomReader reader = new ReadSymptomDataFromFile(SYMPTOMSFILE);
    ISymptomWriter writer = new WriteSymptomDataToFile(RESULTFILE);
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

    List<String> symptoms = counter.getSymptoms();
    Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);

    counter.writeSymptoms(sortedSymptoms);

  }
  
}