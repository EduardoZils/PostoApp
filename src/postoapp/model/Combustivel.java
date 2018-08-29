package postoapp.model;

/**
 *
 * @author Paulo
 */
public class Combustivel extends Record {
    private int codigo;
    private String descricao;
    private String tipoCombustivel;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public String toString() {
        return codigo +" - "+ descricao +" - "+ super.getUsuario() +" - ";//+ super.getDataCadastro();
    }
        
}
