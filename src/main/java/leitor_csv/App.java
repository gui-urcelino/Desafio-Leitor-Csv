package leitor_csv;

import java.io.IOException;
import java.text.NumberFormat;

import controller.CsvController;
import controller.Program;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException {
    	
    	long start = System.currentTimeMillis();
    	
    	Program leitorCvs = new Program();
    	leitorCvs.start();
    	
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Tempo de execução: "+ NumberFormat.getInstance().format(elapsed)+"s");
	
    	
    	
        
    }
}
