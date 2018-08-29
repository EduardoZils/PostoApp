package postoapp.model;

/**
 *
 * @author Paulo
 */
public class Bico extends Record{
    private int codigo;
    private String descricao;
    private Tanque tanque;

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

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    @Override
    public String toString() {
        return "";
    }
    
}
