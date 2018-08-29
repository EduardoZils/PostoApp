package postoapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import postoapp.jdbc.ConnectionFactory;
import postoapp.model.Combustivel;

public class CombustivelDAO implements GenericDAO<Combustivel> {

    private Connection connection;

    @Override
    public void save(Combustivel entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();

            //Mais performatico que utilizar '+' na String
            StringBuilder sql = new StringBuilder();
            sql.append("insert into combustivel(cd_combustivel, ds_combustivel, ")
                    .append("tp_combustivel, unidademedida_combustivel, dt_record)")
                    .append("values (?,?,?,?,?) ");

            PreparedStatement pstm;

            pstm = connection.prepareStatement(sql.toString()); //Preparar a execução do comando

            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDescricao());
            pstm.setString(3, entity.getTipoCombustivel());
            pstm.setInt(4, 1);
            pstm.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

            pstm.execute(); //Executa o comando no banco

            pstm.close(); //Fecha a conexão
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir combustivel.");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void upgrade(Combustivel entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("update combustivel set ds_combustivel = ?, tp_combustivel = ?, ")
                    .append("unidademedida_combustivel = ?, dt_update = ?, usuario = ? ")
                    .append("where cd_combustivel = ?");
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDescricao());
            pstm.setString(2, entity.getTipoCombustivel());
            pstm.setInt(3, 1);
            pstm.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            pstm.setInt(5, entity.getUsuario());
            pstm.setInt(6, entity.getCodigo());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar Combustivel");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public void delete(int id) {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "delete from combustivel where cd_combustivel = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();
        } catch (Exception ex) {
            System.out.println("Erro ao Atualizar Combustivel");
            ex.printStackTrace();
        }
    }

    @Override
    public Combustivel getByID(int id) throws SQLException {
        Combustivel combustivel = null;
        try {
            this.connection = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM combustivel WHERE cd_combustivel = " + id;

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            combustivel = new Combustivel();
            while (rs.next()) {
                combustivel.setCodigo(rs.getInt("cd_combustivel"));
                combustivel.setDescricao(rs.getString("ds_combustivel"));
                combustivel.setTipoCombustivel(rs.getString("tp_combustivel"));
                combustivel.setUsuario(rs.getInt("usuario"));

            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar pelo ID");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return combustivel;
    }

    @Override
    public List<Combustivel> getByName(String name) throws SQLException {
        Combustivel combustivel = null;
        List<Combustivel> combustivelList  = null;
        try {
            this.connection = new ConnectionFactory().getConnection();

            String sql = "select * from combustivel where upper(ds_combustivel) like upper('%" + name + "%')";

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            combustivelList = new ArrayList<Combustivel>();
            while (rs.next()) {
                combustivel = new Combustivel();
                combustivel.setCodigo(rs.getInt("cd_combustivel"));
                combustivel.setDescricao(rs.getString("ds_combustivel"));
                combustivel.setTipoCombustivel(rs.getString("tp_combustivel"));
                combustivel.setUsuario(rs.getInt("usuario"));
                combustivelList.add(combustivel);
            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar pelo nome");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return combustivelList;
    }

    @Override
    public List<Combustivel> getAll() throws SQLException {
        List<Combustivel> combustivelList = null;
        Combustivel combustivel = null;
        try {
            this.connection = new ConnectionFactory().getConnection();

            String sql = "select * from combustivel";

            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            combustivel = new Combustivel();
            combustivelList = new ArrayList<Combustivel>();
            while (rs.next()) {
                combustivel = new Combustivel();
                combustivel.setCodigo(rs.getInt("cd_combustivel"));
                combustivel.setDescricao(rs.getString("ds_combustivel"));
                combustivel.setTipoCombustivel(rs.getString("tp_combustivel"));
                combustivel.setUsuario(rs.getInt("usuario"));
                combustivelList.add(combustivel);

            }
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao exibir lista");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return combustivelList;
    }

    public int getLastID() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();

            String sql = "select coalesce(max(cd_combustivel),0)+1 AS MAIOR from combustivel";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }

            this.connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao pegar ultimo ID");
            ex.printStackTrace();
        } finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    }

   
}
