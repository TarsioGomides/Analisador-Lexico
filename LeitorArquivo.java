import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorArquivo {

	public ArrayList<String> lerArquivo() {
		Scanner ler = new Scanner(System.in);
		ArrayList<String> linhas = new ArrayList<String>();//Vai guardar todas as linhas lidas do arquivo
		
		
		System.out.printf("Informe o caminho do arquivo texto:\n");
	    String caminho_arquivo = ler.nextLine();//usa o Scanner para ler o caminho do arquivo 
	    
	    File arquivo = new File(caminho_arquivo);
	     
	    try {
	    	ler = new Scanner(arquivo);//muda o Scanner, que agora passa a ler o arquivo
	    	
	    	while (ler.hasNext()) {
	           	linhas.add(ler.nextLine());    
	        }
		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo não foi encontrado! Abortando execução");
			//e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e){	
			System.out.println("Erro na leitura do Arquivo! Abortando execução");
			//e.printStackTrace();
			System.exit(1);
		}
	    
	    return linhas;
	}

}