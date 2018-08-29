package postoapp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import postoapp.DAO.CombustivelDAO;
import postoapp.model.Combustivel;

public class PostoApp {

    public static void main(String[] args) throws SQLException {
        /*  Combustivel combustivel = new Combustivel();
        combustivel.setCodigo(1);
        combustivel.setDescricao("Gasolina Aditivada");
        combustivel.setTipoCombustivel("GA");
        combustivel.setDataAtualizacao(new Date());
        combustivel.setDataCadastro(new Date());
        combustivel.setUsuario(1);
        System.out.println(combustivel.toString());*/

        // CombustivelDAO combustivelDAO = new CombustivelDAO();
        // combustivelDAO.upgrade(combustivel);
        //CombustivelDAO combustivelDAO = new CombustivelDAO();
        //combustivelDAO.delete(1);
        Combustivel combustivel = new CombustivelDAO().getByID(4);
        System.out.println("Combustivel consulta -> " + combustivel.toString());
//----------------------------------------------------------------------------------------------------------------
       // combustivel = new CombustivelDAO().getByName("Gasolina Aditivada");
        System.out.println("Combustivel consulta -> " + combustivel.toString());
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>\n>");

        List<Combustivel> combustivelLista = new CombustivelDAO().getAll();
        for(Combustivel lista : combustivelLista){
            System.out.println(lista.toString() + "\n>");
        }
        

    }
}
