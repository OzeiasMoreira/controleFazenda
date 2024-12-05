/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author Ozeias
 */

import com.controlefazenda.util.Dao;
import com.controlefazenda.modelo.Usuario;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioControle {
    @FXML
    private TextField campoLogin;

    @FXML
    private TextField campoNome;

    @FXML
    private PasswordField campoSenha;

    private Dao<Usuario> dao;

    @FXML
    private void initialize(){
        dao = new Dao(Usuario.class);
    }
    
    @FXML
    private void gravar(){
        if(campoLogin.getText().isBlank() || campoSenha.getText().isBlank()){
            mostrarErro("Preencha os campos obrigatorios.");
            return;
        }

        Usuario user = new Usuario(campoLogin.getText(),campoNome.getText(), campoSenha.getText());
        dao.inserir(user);
        limparCampos();
        mostrarSucesso("Usuario cadastrado com sucesso!");

    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("menu");
    }

      private void mostrarErro(String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.show();
    }

    private void mostrarSucesso(String mensagem){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.show();
    }

    private void limparCampos(){
        this.campoLogin.setText("");
        this.campoNome.setText("");
        this.campoSenha.setText("");
    }
}

