/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.controlefazenda.modelo.Producao;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author Ozeias
 */
public class ProducaoControle {

    @FXML
    private TextField campoBrinco;

    @FXML
    private TextField campoData;

    @FXML
    private TextField campoQuantidade;

    private Dao<Producao> dao;

    @FXML
    private void initialize() {
        dao = new Dao(Producao.class);
    }

    @FXML
    private void gravar() {
        if (campoBrinco.getText().isBlank()) {
            mostrarErro("Preencha os campos obrigatorios.");
        }

        Producao p = new Producao(campoBrinco.getText(), campoData.getText(), campoQuantidade.getHeight());
        dao.inserir(p);
        limparCampos();
        mostrarSucesso("Produção registrada!");

    }

    @FXML
    private void cancelar() throws IOException {
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
        this.campoBrinco.setText("");
        this.campoData.setText("");
        this.campoQuantidade.setText("");
    }
}
