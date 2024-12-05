/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.controlefazenda.modelo.Usuario;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Ozeias
 */
public class ExcluirUserControlador {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoLogin;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private ComboBox<String> listar;

    @FXML
    private void initialize() {
        Dao<Usuario> dao = new Dao<Usuario>(Usuario.class);
        ArrayList<String> listaT = new ArrayList<>();
        for (Usuario user : dao.listarTodos()) {
            listaT.add(user.getNome());
        }

        listar.getItems().setAll(listaT);
    }

    @FXML
    public void excluir() {
        if(listar.getValue() == null){
            mostrarErro("preencha os campos obrigatórios!");
            return;
        }
        
        Dao<Usuario> dao = new Dao(Usuario.class);
        dao.excluir("campoNome", listar.getValue());
        mostrarSucesso("Usuário excluído com sucesso!");
        listar.setValue(null);
    }

    public void voltar() throws IOException {
        App.setRoot("menu");
    }

    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.show();
    }

    private void mostrarSucesso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.show();
    }

    private void limparCampos() {
        this.campoLogin.setText("");
        this.campoNome.setText("");
        this.campoSenha.setText("");

    }
}
