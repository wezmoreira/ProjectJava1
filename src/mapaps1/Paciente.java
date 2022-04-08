package mapaps1;

/*
Wesley Rodrigo Moreira - RA: 1948068-5
*/


public class Paciente {
   
   private String cpf;
   private String nome;  
   private String idade;   
   private String sexo;
   private int resultado;

   
   public Paciente(){
   }
   
   public String getCpf(){
    return cpf;
   }
   
   public void setCpf(String c){
    cpf = c;
   }  


   public String getNome(){
    return nome;
   }
   
   public void setNome(String name){
    nome = name;
   }


   
   public String getIdade(){
    return idade;
   }
   
   public void setIdade(String log ){
    idade = log;
   }
   
   public String getSexo(){
    return sexo;
   }
   
   public void setSexo(String sex){
    sexo = sex;
   }  
   
   public int getResultado(){
       return resultado;
   }
   public void setResultado(int resul){
       resultado = resul;
   }
}