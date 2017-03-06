/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Germano
 */
public class Automato {
    
    private int estado;
    public final int[] aceitacao = {2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};    
    private boolean estado_final;
    
    public Automato(){
        estado = 0;
        estado_final = false;
    }        
    
    public void Transicao(Automato a, char simbolo){
        int estado = a.getEstado();
        switch(estado){
            case 0:
                if(Character.isLetter(simbolo)){
                    estado = 2;
                }
                else if(Character.isDigit(simbolo)){
                    estado = 3;
                }
                else if(simbolo == ';'){
                    estado = 6;
                }
                else if(simbolo == '.'){
                    estado = 7;
                }
                else if(simbolo == ':'){
                    estado = 8;
                }
                else if(simbolo == ','){
                    estado = 9;
                }             
                else if(simbolo == '('){
                    estado = 10;
                }
                else if(simbolo == ')'){
                    estado = 11;
                }
                else if(simbolo == '='){
                    estado = 12;
                }
                else if(simbolo == '<'){
                    estado = 13;
                }
                else if(simbolo == '>'){
                    estado = 14;
                }
                else if(simbolo == '+'){
                    estado = 18;
                }
                else if(simbolo == '-'){
                    estado = 19;
                }
                else if(simbolo == '*'){
                    estado = 20;
                }
                else if(simbolo == '/'){
                    estado = 21;
                }
                break;
            case 1:
                if(simbolo == '}')
                    estado = 0;
                break;
                
                
            //estado de rejeição
            default:
                //...
        }
        
        a.setEstado(estado);
        for(int i=0; i<aceitacao.length; i++){
            if(estado==aceitacao[i]){
                a.setEstado_final(true);
                break;
            }
        }
    }

    public boolean isEstado_final() {
        return estado_final;
    }

    public void setEstado_final(boolean estado_final) {
        this.estado_final = estado_final;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
