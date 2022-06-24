package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TesteFile {
	public static void main(String[] args) throws IOException {
		



		FileWriter arq = new FileWriter("/home/guilhermeurcelino/Área de Trabalho/ArquivosDesafio"+"/tabuadaTeste.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		gravarArq.append("a");

		gravarArq.printf("+--Resultado--+%n");
	
		gravarArq.printf("+-------------+%n");

		arq.close();

		System.out.println("/home/guilhermeurcelino/Área de Trabalho/ArquivosDesafio\"+\"/tabuadaTeste.txt");
		

	}

}
