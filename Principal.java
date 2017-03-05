import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		LeitorArquivo l = new LeitorArquivo();
		ArrayList<String> linhas_lidas = l.lerArquivo();
		
		for (String s : linhas_lidas) {
			System.out.println(s);
		}
	}

}
