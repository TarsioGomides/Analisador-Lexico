import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		LeitorArquivo l = new LeitorArquivo();
		//ArrayList<String> linhas_lidas = l.lerArquivo();
                l.lerArquivo(); //Preenche a tabela de símbolos
                Automato a = new Automato();
                a.Analise(a);
                for(int i=0; i<TabelaDeSimbolos.tabela.size(); i++){
                    System.out.println(TabelaDeSimbolos.tabela.get(i).toString());
                }
	}
}
