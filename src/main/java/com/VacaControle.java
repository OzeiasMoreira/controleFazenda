/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author Ozeias
 */
import com.controlefazenda.modelo.Vaca;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class VacaControle {
    
    @FXML
    private TextField campoBrinco;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoRaca;

    private Dao<Vaca> dao;

    @FXML
    private void initialize(){
        dao = new Dao(Vaca.class);
    }

    @FXML
    private void gravar(){
        if(campoBrinco.getText().isBlank() || campoRaca.getText().isBlank()){
            mostrarErro("Preencha os campos obrigatórios.");
            return;
        }

        String brinco = campoBrinco.getText().toUpperCase();
        Vaca temp = dao.buscarPorChave("brinco", brinco);
        if(temp != null){
            mostrarErro("Esse brinco já está cadastrado em outra vaca");
            return;
        }

        Vaca vaca = new Vaca(brinco,campoNome.getText(), campoRaca.getText());
        dao.inserir(vaca);
        limparCampos();
        mostrarSucesso("Vaca cadastrada com sucesso!");

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
        this.campoBrinco.setText("");
        this.campoNome.setText("");
        this.campoRaca.setText("");
    }
}

