package model;

public class Dentista{
    private int id;
    private String numeroDeMatricula;
    private String nome;
    private String sobreNome;

    public Dentista(int id, String numeroDeMatricula, String nome
            , String sobreNome){
        this.id = id;
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDeMatricula(){
        return numeroDeMatricula;
    }
    public void setNumeroDeMatricula(String numeroDeMatricula){
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobreNome(){
        return sobreNome;
    }
    public void setSobreNome(String sobreNome){
        this.sobreNome = sobreNome;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "numeroDeMatricula='" + numeroDeMatricula + '\'' +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                '}';
    }
}