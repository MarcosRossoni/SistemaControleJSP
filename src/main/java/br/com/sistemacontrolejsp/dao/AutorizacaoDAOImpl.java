package br.com.sistemacontrolejsp.dao;

import br.com.sistemacontrolejsp.dto.AutorizacaoDTO;
import br.com.sistemacontrolejsp.model.Autorizacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorizacaoDAOImpl implements AutorizacaoDAO {

    private final Connection connection;

    public AutorizacaoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Autorizacao save(Autorizacao autorizacao){
        try {
            String sql = "INSERT INTO Autorizacao(ds_nome, idade, procedimento, fg_sexo) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, autorizacao.getDsNome());
            preparedStatement.setInt(2, autorizacao.getIdade());
            preparedStatement.setInt(3, autorizacao.getProcedimento());
            preparedStatement.setInt(4, autorizacao.getFgSexo().ordinal());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Integer generatedId = resultSet.getInt("id");
            autorizacao.setId(generatedId);

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return autorizacao;
    }

    @Override
    public List<AutorizacaoDTO> findAll(){
        String sql = "SELECT id, ds_nome, idade, procedimento, fg_sexo FROM Autorizacao";

        List<AutorizacaoDTO> listAutorizacao = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String dsNome = resultSet.getString("ds_nome");
                Integer idade = resultSet.getInt("idade");
                Integer procedimento = resultSet.getInt("procedimento");
                Integer fgSexo = resultSet.getInt("fg_sexo");

                AutorizacaoDTO autorizacaoDTO = new AutorizacaoDTO(id, dsNome, idade, procedimento, fgSexo);

                listAutorizacao.add(autorizacaoDTO);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listAutorizacao;
    }
}
