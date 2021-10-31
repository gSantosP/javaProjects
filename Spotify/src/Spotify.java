public class Spotify {
    public static void main(String[] args){

        Usuario usuario = new Usuario("123", "Premium");

        ServicoDownload download;
        download = new ProxyDownload(new Download());

        download.baixar("Elvis", usuario);
    }
}
