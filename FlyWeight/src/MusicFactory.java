import java.util.HashMap ;

public class MusicFactory {
        private static final  HashMap<String , Music> musicaMap = new HashMap();


        public static Music getMusica(String nome) {
            Music musica = (Music)  musicaMap.get(nome) ;

            if(!musicaMap.containsKey(nome)) {
                musica =  new Music(nome);

                musicaMap.put(musica.getNome(), musica);
                System.out.println("Criando objeto musica de nome: "
                        + musica.getNome());
            }
            return musica;
        }

}
