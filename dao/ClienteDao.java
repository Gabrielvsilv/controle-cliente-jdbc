package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;

import model.Cliente;

public class ClienteDao {

    public void cadastrar(Cliente cliente) {

    String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";

    try (
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setString(3, cliente.getTelefone());

        stmt.executeUpdate();

        System.out.println("Cliente cadastrado com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar cliente.");
        e.printStackTrace();
    }
}


public void atualizar(Cliente cliente){

    String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id = ?";

    try(
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ){
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setString(3, cliente.getTelefone());
        stmt.setInt(4, cliente.getId());

        stmt.executeUpdate();

        System.out.println("Cliente atualizado com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar cliente.");
        e.printStackTrace();
    }
}

public void excluir(int id){

    String sql = "DELETE FROM clientes WHERE id = ?";
    try(
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ){
        stmt.setInt(1, id);

        stmt.executeUpdate();

        System.out.println("Cliente excluído com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao excluir cliente.");
        e.printStackTrace();




    }
        
    
}

public Cliente buscar(int id) {

    String sql = "SELECT * FROM clientes WHERE id = ?";

    try (
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            return new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar cliente.");
        e.printStackTrace();
    }

    return null;
}


public List<Cliente> listar() {

    List<Cliente> clientes = new ArrayList<>();

    String sql = "SELECT * FROM clientes";

    try (
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()
    ) {

        while (rs.next()) {

            Cliente cliente = new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone")
            );

            clientes.add(cliente);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar clientes.");
        e.printStackTrace();
    }

    return clientes;
}
    
}
