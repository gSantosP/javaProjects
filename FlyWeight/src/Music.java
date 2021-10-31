public class Music {
    private String nome;
    private String artista;
    private String genero;

    //Constructor
    public Music(String nome){
        this.nome = nome;


    }
    //Getters and setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero(){
        return genero;
    }
    public void setGenero(){
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Music{" +
                "nome='" + this.getNome() + '\'' +
                ", artista='" + this.getArtista() + '\'' +
                ", genero='" + this.getGenero() + '\'' +
                '}';
    }
}
