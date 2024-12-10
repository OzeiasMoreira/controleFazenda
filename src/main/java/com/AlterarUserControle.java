/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.controlefazenda.modelo.Usuario;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Ozeias
 */
public class AlterarUserControle {
    
    @FXML
    TextField campoLogin;
    
    @FXML
    TextField campoNome;
    
    @FXML
    PasswordField campoSenha;
    
    @FXML
    private ComboBox<Usuario> listar;
    
    @FXML
    private void initialize(){
        Dao<Usuario> dao = new Dao<>(Usuario.class);
        List<Usuario> listaT = new ArrayList<>();
        listaT = dao.listarTodos();
        listar.setItems(FXCollections.observableArrayList(listaT));
        
    }
    
    public void alterar(){
        if(campoSenha.getText().isEmpty() || listar.getValue() == null){
            mostrarErro("Preencha os campos obrigatórios");
            return;
        } 
        
        Dao<Usuario> dao = new Dao(Usuario.class);
        Usuario user = new Usuario(campoLogin.getText(),campoNome.getText(), campoSenha.getText());
        dao.alterar("login", listar.getValue().getLogin(),user);
        limparCampos();
        mostrarSucesso("Usuario alterado com sucesso!");
    }
    
    public void voltar() throws IOException{
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
