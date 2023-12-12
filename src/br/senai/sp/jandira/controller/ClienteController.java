package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Clientes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    Conexao conexao = new Conexao();

    Connection connection = conexao.getConnection();

    public void listarClientes() throws SQLException {

        Statement statement = connection.createStatement();
        String queryList = "SELECT * FROM clientes";

        ResultSet resultSet = statement.executeQuery(queryList);

        Clientes cliente = new Clientes();

        while (resultSet.next()){
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));

            System.out.println("ID Cliente: " + cliente.getIdCliente());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("/-----------------------------------------------------/");
        }

    }

    public void deletarCliente(int cpf) throws SQLException {
        Statement statement = connection.createStatement();

        String queryDelete = "DELETE FROM clientes WHERE cpf=" + cpf;

        statement.executeUpdate(queryDelete);
        System.out.println("Cliente com CPF " + cpf + " deletado com sucesso!!");
    }

    public void cadastrarCliente(Clientes cliente) throws SQLException {

        Statement statement = connection.createStatement();

        String queryCadastro = "INSERT INTO clientes (id_cliente, nome, cpf, email, telefone) values (" +
                cliente.getIdCliente() + ",'" + cliente.getNome() + "'," + cliente.getCpf() + ",'" +
                cliente.getEmail() + "'," + cliente.getTelefone() + ")";

        statement.executeUpdate(queryCadastro);
        System.out.println("Cliente cadastrado com sucesso!!");
    }

    public void consultarCliente(int cpf) throws SQLException {
        Statement statement = connection.createStatement();

        String queryConsulta = "SELECT * FROM clientes WHERE cpf=" + cpf;

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Clientes> listConsulta = new ArrayList<>();

        while (resultSet.next()){
            Clientes cliente = new Clientes();

            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getInt("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getInt("telefone"));

            listConsulta.add(cliente);
        }

        for (Clientes cliente:listConsulta) {
            System.out.println(cliente.getIdCliente());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getTelefone());
            System.out.println("/--------------------------------/");
        }
    }
}
