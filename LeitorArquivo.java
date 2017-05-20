import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LeitorArquivo {

    final String COMENTARIOS = "\\{(.|\\n)+}";
    final String DELIMITADORES = "('.+'|\\d+\\.\\d+|\\w+|<>|:=|>=|<=|[.,:;()+\\-*/><])"; //número real foi usado como delimitador aqui para que o '.' não separasse em dois inteiros
    final String SEP = "<SEP>"; //usado temporiamente para a separação dos tokens
    /*public void SeparaTokens(String texto, String delimitadores[], String tokens[])
    {       
        String tmp = "";
        int i=0;
        for(i=0; i<delimitadores.length-1; i++){
            tmp += "((?="+delimitadores[i]+")";//|(?="+delimitadores[i]+"))|";
        }
        tmp += "((?<="+delimitadores[i]+")";//|(?="+delimitadores[i]+"))";
        tokens = texto.split(tmp);
    }*/
    
    public String[] SeparaTokens(String s){
        //s = s.replaceAll("[{\\w}]+", "");
        // Remove comments
        s = s.replaceAll(COMENTARIOS, "");
        
        // Add spaces to these words and symbols
        s = s.replaceAll(DELIMITADORES, "$1"+SEP); // Add spaces to these words and symbols        

       // Remove spaces that is not between '...'
        s = s.replaceAll("('.+')|\\s+", "$1");
        
        //System.out.println(" // Sanitizer: " + s + "\n");

        // Splitter
        String[] tokens = s.split(SEP);
        //System.out.println("Result:\n" + Arrays.toString(things));
        return tokens;
    }
    
	public void lerArquivo() {
            Scanner ler = new Scanner(System.in);
            String[] tokens = {""};
            String texto = "";
            String tmp;
            int linha = 1;
            //final String TOKENS = "[;:(),\\.:==<>{}+-/\t\n ]\\b";
		
            //System.out.printf("Informe o caminho do arquivo texto:\n");
            //String caminho_arquivo = ler.nextLine();//usa o Scanner para ler o caminho do arquivo 
	    String caminho_arquivo = "src/teste.p";
	    File arquivo = new File(caminho_arquivo);
            
	     
	    try {
	    	ler = new Scanner(arquivo);//muda o Scanner, que agora passa a ler o arquivo
	    	
	    	while (ler.hasNext()) {
                    tmp = ler.nextLine();
                    texto += tmp;
                    tokens = SeparaTokens(tmp);
                    for(int i=0; i<tokens.length; i++){ 
                        if(!tokens[i].isEmpty())
                            TabelaDeSimbolos.tabela.add(new ElementoDaTabelaDeSimbolos(tokens[i], "", linha));

                    }
                    linha++;
	        }
                
                //texto = "Um(Dois;Tres.Quatro.";
                
                //tokens = SeparaTokens(texto);
                //texto = texto.replaceAll(COMENTARIOS, "");
                //System.out.println("COMENTARIOS: " + Arrays.toString(texto.split(COMENTARIOS)));
                //http://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters                
                //tokens = texto.split(DELIMITADORES);
                /*for(int i=0; i<TabelaDeSimbolos.tabela.size(); i++){
                    System.out.println(TabelaDeSimbolos.tabela.get(i).toString());
                }*/
                
		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo n�o foi encontrado! Abortando execu��o");
			//e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e){	
			System.out.println("Erro na leitura do Arquivo! Abortando execu��o");
			//e.printStackTrace();
			System.exit(1);
		}
	    
	}
}