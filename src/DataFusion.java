
import java.io.InputStream;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory ;
// import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.apache.jena.util.FileManager;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP ;
import org.apache.jena.ontology.*;
import java.util.Scanner;


public class DataFusion {
	
	static final String inputFileName1  = "camera.owl";
	static final String inputFileName2  = "FOAFexample.txt";
	
	static public void main(String...argv)
    {
		
		Model model1 = ModelFactory.createDefaultModel();

        InputStream in1 = FileManager.get().open( inputFileName1 );
        if (in1 == null) {
            throw new IllegalArgumentException( "File: " + inputFileName1 + " not found");
        }
        
        // read the RDF/XML file
        model1.read(in1, "");
        
        Model model2 = ModelFactory.createDefaultModel();

        InputStream in2 = FileManager.get().open( inputFileName2 );
        if (in2 == null) {
            throw new IllegalArgumentException( "File: " + inputFileName2 + " not found");
        }
        
        // TO DO: Insert your code below....
        
        System.out.println("Choose a function");
        System.out.println("a: Part 1a");
        System.out.println("b: Part 1b");
        System.out.println("c: Part 1c");
        System.out.println("d: Part 1d");
        System.out.println("e: Part 2");
        System.out.println("f: Part 3");
        System.out.println("g: Part 4");
        System.out.println("h: Part 5");
        System.out.println("i: Part 6");
        Scanner scanner = new Scanner(System.in);
        String menuChoice = "";
        while(!menuChoice.equals("end")){
            menuChoice = scanner.nextLine();
            switch(menuChoice){
                case "a":
                    String queryStr = "select distinct ?Concept where {[] a ?Concept} LIMIT 10";
                    Query query = QueryFactory.create(queryStr);
                    return;
                
                case "b":
                    
                    return;
                case "c":
                    
                    return;
                case "d":
                    
                    return;    
            }
        



        }
    }
}