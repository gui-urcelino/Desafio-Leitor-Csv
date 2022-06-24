package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import model.ProductEnum;

public class CsvController {
	
	
	//Lista que recebe os dados do arquivo de entrada
	List<String[]> productList;
	
	
	//Array para contar qtd de produtos de cada tipo
	Integer[] contProd = new Integer[10];

	public void loadCSV(String pathFileCsv) {

		try {
			Reader reader = Files.newBufferedReader(Paths.get(pathFileCsv));
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

			productList = csvReader.readAll();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printCsv() {
		for (String[] product : productList) {

			if (!product[0].isEmpty()) {
				System.out.println(product[0] + " " + product[1] + " " + product[2]);
			}

		}

	}

	public void getTotalProducts() {

		//inicializando contadores para os produtos
		for (int i = 0; i < contProd.length; i++) {
			contProd[i] = 0;
		}
		
		
		//loop para contar quantos produtos de cada tipo existem
		for (String[] product : productList) {

			//verifica se produto é nulo (linha vazia no arquivo)
			if (!product[0].isEmpty()) {

				switch (product[0]) {
				case "0001":
					contProd[ProductEnum.BROWN_RICE.getId()]++;
					break;
				case "0002":
					contProd[ProductEnum.MILKY.getId()]++;
					break;
				case "0003":
					contProd[ProductEnum.EXTRA_VIRGIN_OLIVE_OIL.getId()]++;
					break;
				case "0004":
					contProd[ProductEnum.WATERMELON.getId()]++;
					break;
				case "0005":
					contProd[ProductEnum.BARBECUE_SAUCE.getId()]++;
					break;
				case "0006":
					contProd[ProductEnum.LEMON.getId()]++;
					break;
				case "0007":
					contProd[ProductEnum.CHOCOLATE.getId()]++;
					break;
				case "0008":
					contProd[ProductEnum.SODA.getId()]++;
					break;
				case "0009":
					contProd[ProductEnum.TEA.getId()]++;
					break;
				case "0010":
					contProd[ProductEnum.COFFEE.getId()]++;
					break;
				}

			}

		}

	}
	
	public String LoadTextFile() {
		//cria array com calores do enum para poder percorrer em loop
		ProductEnum[] productArrayEnum = ProductEnum.values();

		//variavel para contar todos os produtos
		int contTotalProducts = 0;

		//cria stringBuilder para preencher arquivo
		StringBuilder conteudoCSV = new StringBuilder();

		conteudoCSV.append("Code;Product Description;Total" + "\n");

		//percorre array com conteudo do enum e preenche o texto do arquivo com a qtd e dados do produto
		for (int i = 0; i < contProd.length; i++) {

			conteudoCSV.append(productArrayEnum[i].getCodigo() + ";" + productArrayEnum[i].getDescricao() + ";"
					+ contProd[i] + "\n");

			contTotalProducts += contProd[i];

		}
		conteudoCSV.append(";Total;" + contTotalProducts + "\n");
		
		return conteudoCSV.toString();

	}
	
	
	
	public void generateCsvFile(String textFile) {
		
		// cria e insere texto em arquivo
		try {
			FileWriter arq = new FileWriter("/home/guilhermeurcelino/Área de Trabalho/ArquivosDesafio" + "/report.csv");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.append(textFile);
			arq.close();
			System.out.println("Arquivo salvo em: " + "/home/guilhermeurcelino/Área de Trabalho/ArquivosDesafio" + "/report.csv");

		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
