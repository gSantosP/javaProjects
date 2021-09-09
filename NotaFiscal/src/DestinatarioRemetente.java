import java.util.Date;

public class DestinatarioRemetente {
    private String nomeRazaoSocial;
    private int cnpjCpf;
    private Date dataEmissao;
    private String endereco;
    private String bairroDistrito;
    private int cep;
    private Date dataSaida;
    private String municipio;
    private String ufD;
    private int foneFax;
    private int inscricaoEstadual;
    private Date horaSaida;

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public int getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(int cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairroDistrito() {
        return bairroDistrito;
    }

    public void setBairroDistrito(String bairroDistrito) {
        this.bairroDistrito = bairroDistrito;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUfD() {
        return ufD;
    }

    public void setUfD(String ufD) {
        this.ufD = ufD;
    }

    public int getFoneFax() {
        return foneFax;
    }

    public void setFoneFax(int foneFax) {
        this.foneFax = foneFax;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }
}
