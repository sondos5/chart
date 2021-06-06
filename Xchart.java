import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sondos
 */
public class Xchart {

    //private static graphPassengerAges x;
    //public  static final PassengersFromJsonFile p = new PassengersFromJsonFile();


    
    public static void main (String args[]) throws IOException{
    
        Xchart ps = new Xchart();
        List<TitanicPassenger> Passengers = new ArrayList<> ();
        Passengers = ps.getPassengersFromJsonFile();
        System.out.println(Passengers );
          ps.graphPassengerSurvivedGender(Passengers);
          ps.graphPassengerSurvived(Passengers);
          //ps.graphPassengerAges (Passengers);
        
    }
    
    public List<TitanicPassenger> getPassengersFromJsonFile() throws IOException {
        List<TitanicPassenger> allPassengers = new ArrayList<> ();
        ObjectMapper objectMapper = new ObjectMapper ();
        //JsonFactory objectMapper = objectMapper.getFactory();
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream ("titanic_csv.json")) {
            //Read JSON file
            allPassengers = objectMapper.readValue (input, new TypeReference<List<TitanicPassenger>> () {
            });
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        
       return allPassengers; 
    
}

    
    public void graphPassengerAges(List<TitanicPassenger> passengerList) {
        List<Float> pAges= passengerList.stream().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList());
        List<String> pNames= passengerList.stream().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList());
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build ();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);chart.getStyler().setHasAnnotations(true);chart.getStyler().setStacked(true);
        chart.addSeries("Passenger's Ages", pNames, pAges);
        new SwingWrapper(chart).displayChart();
        
    }
    
    public void graphPassengerSurvived(List<TitanicPassenger> passengerList) {
    //filter to get a map of passenger class and total number of passengers in each class
    Map<String, Long> result =passengerList.stream().collect (Collectors.groupingBy(TitanicPassenger::getSurvived,
        Collectors.counting() ) );  
    // Create Chart
    PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
    // Customize 
    Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120),new Color (80, 143, 160)};
    chart.getStyler().setSeriesColors(sliceColors);
    // Series
    chart.addSeries("Survived", result.get("1"));
    chart.addSeries("Unsurvived", result.get("0"));
    //chart.addSeries("Third Class", result.get("3"));
    // Show it
    new SwingWrapper(chart).displayChart();
    
    
   } 
    public void graphPassengerSurvivedGender(List<TitanicPassenger> passengerList) {

        Map<String, Long> result =passengerList.stream().filter(p -> p.getSurvived().equals("1")).collect (Collectors.groupingBy(TitanicPassenger::getSex, Collectors.counting() ) );
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
        Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("Male", result.get("male"));
        chart.addSeries("Female", result.get("female"));
        new SwingWrapper(chart).displayChart();
}
    
}
