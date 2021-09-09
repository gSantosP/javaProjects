public class DadosProdutoServico {
    private int  codigoProduto;
    private String descricaoProdutoServico;
    private int ncmsh;
    private int ocst;
    private int cfop;
    private String un;
    private int quantidade;

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProdutoServico() {
        return descricaoProdutoServico;
    }

    public void setDescricaoProdutoServico(String descricaoProdutoServico) {
        this.descricaoProdutoServico = descricaoProdutoServico;
    }

    public int getNcmsh() {
        return ncmsh;
    }

    public void setNcmsh(int ncmsh) {
        this.ncmsh = ncmsh;
    }

    public int getOcst() {
        return ocst;
    }

    public void setOcst(int ocst) {
        this.ocst = ocst;
    }

    public int getCfop() {
        return cfop;
    }

    public void setCfop(int cfop) {
        this.cfop = cfop;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getbCalclcms() {
        return bCalclcms;
    }

    public void setbCalclcms(int bCalclcms) {
        this.bCalclcms = bCalclcms;
    }

    public Float getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(Float valorIcms) {
        this.valorIcms = valorIcms;
    }

    public int getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(int valorIpi) {
        this.valorIpi = valorIpi;
    }

    public Float getAliqlcms() {
        return aliqlcms;
    }

    public void setAliqlcms(Float aliqlcms) {
        this.aliqlcms = aliqlcms;
    }

    public int getAliqlpi() {
        return aliqlpi;
    }

    public void setAliqlpi(int aliqlpi) {
        this.aliqlpi = aliqlpi;
    }

    private Double valorUnitario;
    private Float valorTotal;
    private int bCalclcms;
    private Float valorIcms;
    private int valorIpi;
    private Float aliqlcms;
    private int aliqlpi;
}
