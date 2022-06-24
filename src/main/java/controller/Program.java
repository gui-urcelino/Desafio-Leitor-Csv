
package controller;

public class Program {
	
	public void start() {
		
		String pathFileCsvTeste = "/home/guilhermeurcelino/Área de Trabalho/workspaceTeste/desafio.leitor_csv/src/main/java/CSVFiles/teste.csv";     

		String pathFileCsv = "/home/guilhermeurcelino/Área de Trabalho/workspaceTeste/desafio.leitor_csv/src/main/java/CSVFiles/products_shuffled.csv";     
		
		CsvController csvController = new CsvController();
		
    	csvController.loadCSV(pathFileCsv);    
    	
    	csvController.getTotalProducts();	
    	
    	String textFile = csvController.LoadTextFile();
		
    	csvController.generateCsvFile(textFile);

    		
	}
	
}
