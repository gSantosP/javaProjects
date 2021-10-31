public class Download implements ServicoDownload{
    @Override
    public void baixar(String musica, Usuario usuario)
    {
        System.out.println("Baixando: " + musica);
    }
}
