


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
        

        Scanner scanner = new Scanner(System.in);
        String menuChoice = "";
        do{
            System.out.println("Choose a function");
            System.out.println("a: Part 1a");
            System.out.println("b: Part 1b");
            System.out.println("c: Part 1c");
            System.out.println("d: Part 1d");
            System.out.println("e: Part 3");
            System.out.println("f: Part 5");
            System.out.println("g: Part 6");
            menuChoice = scanner.nextLine();
            switch(menuChoice){
                case "a":
                    String queryStr1 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
                    "prefix : <http://www.xfront.com/owl/ontologies/camera/#> \n" +
                    "prefix owl: <http://www.w3.org/2002/07/owl#> \n" + 
                    "SELECT * WHERE {?Class rdfs:subClassOf ?Sub_Class .}";
                    Query query = QueryFactory.create(queryStr1);
                    QueryExecution qexec = QueryExecutionFactory.create(query, model1);
                            ResultSet result = qexec.execSelect();
                            ResultSetFormatter.out(System.out , result, query);
                    
                    break;
                
                case "b":
                    String queryStr2 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
                    "prefix : <http://www.xfront.com/owl/ontologies/camera/#> \n" +
                    "prefix owl: <http://www.w3.org/2002/07/owl#> \n" + 
                                       "SELECT ?SubClass WHERE {?SubClass rdfs:subClassOf :PurchaseableItem .}";
                                        Query query1 = QueryFactory.create(queryStr2);
                            QueryExecution qexec1 = QueryExecutionFactory.create(query1, model1);
                            ResultSet result1 = qexec1.execSelect();
                            ResultSetFormatter.out(System.out , result1, query1);
                    break;
                case "c":
                    String queryStr3 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
                    "prefix : <http://www.xfront.com/owl/ontologies/camera/#> \n" +
                    "prefix owl: <http://www.w3.org/2002/07/owl#> \n" + 
                    "select ?p ?domain ?range where {?p rdfs:domain ?domain .\n" +
                    "?p rdfs:range ?range .}";
                    Query query2 = QueryFactory.create(queryStr3);
                    QueryExecution qexec2 = QueryExecutionFactory.create(query2, model1);
                    ResultSet result2 = qexec2.execSelect();
                    ResultSetFormatter.out(System.out , result2, query2);
                    
                    break;
                case "d":
                    String queryStr4 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
                    "prefix : <http://www.xfront.com/owl/ontologies/camera/#> \n" +
                    "prefix owl: <http://www.w3.org/2002/07/owl#> \n" + 
                    "SELECT ?SubProperty WHERE {?SubProperty rdfs:subPropertyOf ?p}";
                    Query query3 = QueryFactory.create(queryStr4);
                    QueryExecution qexec3 = QueryExecutionFactory.create(query3, model1);
                    ResultSet result3 = qexec3.execSelect();
                    ResultSetFormatter.out(System.out , result3, query3);
                    
                    break;    
                case "e":
                    String queryStr5 = "prefix owl: <http://www.xfront.com/owl/ontologies/camera/#> \n" +
                    "SELECT * WHERE {?CameraType owl:type ?type .}";
                    Query query4 = QueryFactory.create(queryStr5);
                    QueryExecution qexec4 = QueryExecutionFactory.create(query4, model1);
                    ResultSet result4 = qexec4.execSelect();
                    ResultSetFormatter.out(System.out , result4, query4);
                    
                    break;
                case "f":
                    String queryStr6 = "prefix owl: <http://www.xfront.com/owl/ontologies/camera/#> \n" +
                    "PREFIX foaf:  <http://xmlns.com/foaf/0.1/>\n" +
                    "SELECT ?name ?Camera ?Type \n" +
                    "WHERE {\n" +
                    "    ?Description owl:name ?name .\n" +
                    "    ?Description owl:purchasedCamera ?Camera .\n" +
                    "    ?Description owl:cameraType ?Type .}" ;
                            
                    Query query5 = QueryFactory.create(queryStr6);
                    QueryExecution qexec5 = QueryExecutionFactory.create(query5, model1);
                    ResultSet result5 = qexec5.execSelect();
                    ResultSetFormatter.out(System.out , result5, query5);
                    
                    break;
                    
                case "g":
                    String queryStr7 = "SELECT ?Name ?Nationality ?placeOfBirth \n" +
                            "FROM NAMED http:/www.w3.org/People/Berners-Lee/card \n" +
                            "WHERE {?Description foaf:name ?Name . \n" +
                            "";
                    
                            
                    Query query6 = QueryFactory.create(queryStr7);
                    QueryExecution qexec6 = QueryExecutionFactory.create(query6, model2);
                    ResultSet result6 = qexec6.execSelect();
                    ResultSetFormatter.out(System.out , result6, query6);
                    
                    break;
                
            }
            
        

              }while(!menuChoice.equals("end")) ;
        
        
    
    }}  


//SELECT ?name ?purchasedCamera ?cameraType WHERE {?Description owl:name ?name . OPTIONAL { ?Description owl:name ?name }\n" +
//                    "  OPTIONAL { ?Description owl:purchasedCamera ?purchasedCamera }\n" +
//                    "  OPTIONAL { ?Description owl:cameraType ?cameraType }}