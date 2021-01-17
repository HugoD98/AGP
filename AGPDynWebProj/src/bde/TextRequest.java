package bde;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

public class TextRequest {
	
	private String indexLocation ="tmp/index";
	private String fileLocation ="R";
	private ArrayList<String>  results;
	private String current;
	private int index = -1;
	
	public void createIndex() throws IOException {
		
		Analyzer analyseur = new StandardAnalyzer();
		
		Directory index = FSDirectory.open(Paths.get(indexLocation));
		
		//System.out.println(index);
		IndexWriterConfig config = new IndexWriterConfig(analyseur);
		
	    IndexWriter w = new IndexWriter(index, config);
	    
	    // Pour indexer les fichiers
	    
	    File repertoire = new File(fileLocation+"/");
	    
	    System.out.println(repertoire);
	    
        String list[] = repertoire.list();      
 
        if (list != null) {         
            for(String s : list) {
            	//System.out.println(s);
            	File f = new File(fileLocation+"/"+s);
           		Document doc = new Document();
           		doc.add(new Field("name", f.getName(), TextField.TYPE_STORED));
           		doc.add(new Field("content", new FileReader(f), TextField.TYPE_NOT_STORED));
           		w.addDocument(doc);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
        w.close();
	}
	
	public void searchText(String toSearch) throws Exception {
		
		int MAX_RESULTS = 100;
		
		Directory index = FSDirectory.open(Paths.get(indexLocation));
		
		//System.out.println(index);
		
		DirectoryReader ireader = DirectoryReader.open(index);
	    IndexSearcher searcher = new IndexSearcher(ireader); 
	    
	    Analyzer analyseur = new StandardAnalyzer();
	    
	    QueryParser qp = new QueryParser("content", analyseur); 
	    Query req = qp.parse(toSearch);

	    TopDocs results = searcher.search(req, MAX_RESULTS);
	    
	    //System.out.println(results.totalHits + " documents correspondent");
	    for(int i=0; i<results.scoreDocs.length; i++) {
	    	int docId = results.scoreDocs[i].doc;
	    	Document d = searcher.doc(docId);
	    	if(!this.results.contains(d.get("name")))
	    		this.results.add(d.get("name").split(".")[0]);
	    	
	    	//System.out.println(d.get("name") + ": score " + resultats.scoreDocs[i].score);
	    }
	        
	    ireader.close();
	}
	
	public void init(String toSearch) throws Exception {
		
		this.results = new ArrayList<String>();
		createIndex();
		searchText(toSearch);
	}
	
	public String get() {
		
		return current;
	}
	
	public Boolean next(){
		
		if(results.size()==0)
			return false;
		else if(index < 0) {
			index = 0;
			current = results.get(index);
			return true;
		} else if(index >= results.size()) {
			index = -1;
			return false;
		} else {
			current = results.get(index);
			index = index+1;
		}
			
		return true;
	}
	
}
	

