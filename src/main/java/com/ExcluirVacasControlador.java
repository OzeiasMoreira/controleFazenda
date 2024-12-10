/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.controlefazenda.modelo.Usuario;
import com.controlefazenda.modelo.Vaca;
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
public class ExcluirVacasControlador {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoBrinco;

    @FXML
    private TextField campoRaca;

    @FXML
    private ComboBox<Vaca> listar;

    @FXML
    private void initialize() {
        Dao<Vaca> dao = new Dao<Vaca>(Vaca.class);
        List<Vaca> listaT = new ArrayList<>();
        listaT = dao.listarTodos();
        listar.setItems(FXCollections.observableArrayList(listaT));
    }

    @FXML
    public void excluir() {
        if (listar.getValue() == null) {
            mostrarErro("preencha os campos obrigatórios!");
            return;
        }

        Dao<Usuario> dao = new Dao(Vaca.class);
        dao.excluir("campoBrinco", listar.getValue().getBrinco());
        mostrarSucesso("Vaca excluída com sucesso!");
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
        this.campoRaca.setText("");
        this.campoNome.setText("");
        this.campoBrinco.setText("");

    }
}
