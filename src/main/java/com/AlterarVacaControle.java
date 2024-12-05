/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.controlefazenda.modelo.Vaca;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Ozeias
 */
public class AlterarVacaControle {
    @FXML
    private TextField campoNome;
    
    @FXML
    private TextField campoBrinco;
    
    @FXML
    private TextField campoRaca;
    
    @FXML
    private ComboBox<String> listar;
    
    private void initialize(){
        Dao<Vaca> dao = new Dao(Vaca.class);
        ArrayList<String> listaT = new ArrayList<>();
        for (Vaca v : dao.listarTodos()){
            listaT.add(v.getBrinco());
        }
        
        listar.getItems().setAll(listaT);
    }
    
        public void alterar(){
        if(campoBrinco.getText().isEmpty() || campoRaca.getText().isEmpty() || listar.getValue() == null){
            mostrarErro("Preencha os campos obrigatórios");
            return;
        } 
        
        Dao<Vaca> dao = new Dao(Vaca.class);
        Vaca v = new Vaca(campoNome.getText(),campoBrinco.getText(), campoRaca.getText());
        dao.alterar("campoBrinco", listar.getValue(),v);
        limparCampos();
        mostrarSucesso("Vaca alterada com sucesso!");
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
        this.campoNome.setText("");
        this.campoBrinco.setText("");
        this.campoRaca.setText("");
       
    }
}
