public class ElementoDaTabelaDeSimbolos {
	String token, tipo_token, linha_token;
	
	public ElementoDaTabelaDeSimbolos(String token, String tipo_token, String linha_token) {
		this.token = token;
		this.tipo_token = tipo_token;
		this.linha_token = linha_token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo_token() {
		return tipo_token;
	}

	public void setTipo_token(String tipo_token) {
		this.tipo_token = tipo_token;
	}

	public String getLinha_token() {
		return linha_token;
	}

	public void setLinha_token(String linha_token) {
		this.linha_token = linha_token;
	}
	
}
