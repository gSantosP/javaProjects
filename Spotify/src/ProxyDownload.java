public class ProxyDownload implements ServicoDownload{
    private Download download;
    private Usuario usuario;



    public ProxyDownload(Download download) {
        this.download = download;
    }

    @Override
    public void baixar(String musica, Usuario usuario) {
        if(usuario.getTipo().equals("Premium")){
            System.out.println("========");
            System.out.println("Baixando musica: " + musica);
            System.out.println("Usuario: "+ "\n" + usuario.toString());
        }else{
            System.out.println("Para baixar musicas," +
                    " voce deve ser premium");
        }
    }
}
