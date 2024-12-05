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
public class AlterarUserControle {
    
    @FXML
    TextField campoLogin;
    
    @FXML
    TextField campoNome;
    
    @FXML
    PasswordField campoSenha;
    
    @FXML
    private ComboBox<String> listar;
    
    @FXML
    private void initialize(){
        Dao<Usuario> dao = new Dao<Usuario>(Usuario.class);
        ArrayList<String> listaT = new ArrayList<>();
        for(Usuario user : dao.listarTodos()){
            listaT.add(user.getNome());
        }
        
        listar.getItems().setAll(listaT);
    }
    
    public void alterar(){
        if(campoLogin.getText().isEmpty() || campoSenha.getText().isEmpty() || listar.getValue() == null){
            mostrarErro("Preencha os campos obrigatórios");
            return;
        } 
        
        Dao<Usuario> dao = new Dao(Usuario.class);
        Usuario user = new Usuario(campoLogin.getText(),campoNome.getText(), campoSenha.getText());
        dao.alterar("login", listar.getValue(),user);
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
