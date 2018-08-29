package postoapp.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class NotaFiscal extends Record {
    private int codigo;
    private int numeracao;
    private String serie;
    private Cliente cliente;
    private Date dataEmissao;
    private Double valorTotal;
    private List<ItemNF> itemList;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemNF> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemNF> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "";
    }
    
}
