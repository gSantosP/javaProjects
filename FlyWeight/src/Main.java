public class Main {
    public static void main(String[] args){

        MusicFactory musicf = new MusicFactory();
        musicf.getMusica("test");

        Music musica = musicf.getMusica("abcd");
        System.out.println(musica.toString());

    }
}
