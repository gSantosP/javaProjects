import java.util.List;

public class ProxyInternet implements IConexaoInternet{
    private InternetService internetService;
    private List<String> sitesBloqueados;
    public ProxyInternet(List<String> sitesBloqueados,
                         InternetService internetService) {
        this.sitesBloqueados = sitesBloqueados;
        this.internetService = internetService;


}

    @Override
    public void conectarCom(String url) {
        if(!this.sitesBloqueados.contains(url))
            this.internetService.conectarCom(url);
        else
            System.out.println("Acesso negado");
    }
}
