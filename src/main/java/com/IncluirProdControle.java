/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.controlefazenda.modelo.Producao;
import com.controlefazenda.modelo.Vaca;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Ozeias
 */
public class IncluirProdControle {

    private final ObservableList<Producao> dados = FXCollections.observableArrayList();

    @FXML
    private TextField data;

    @FXML
    private ComboBox<Vaca> listar;

    @FXML
    private TextField litros;

    @FXML
    private void initialize() {
        Dao<Vaca> dao = new Dao(Vaca.class);
        List<Vaca> listaT = new ArrayList<>();
        listaT = dao.listarTodos();
        listar.setItems(FXCollections.observableArrayList(listaT));
    }

    @FXML
    public void registrar() {
        if (litros.getText().isEmpty() || listar.getValue() == null) {
            mostrarErro("Erro,preencha os campos!");
            return;
        }
        
        Dao<Vaca> dao = new Dao(Vaca.class);
        Vaca v = dao.buscarPorChave("brinco", listar.getValue().getBrinco());
        
        Producao producao = new Producao(v.getBrinco(), data.getText(),  Double.valueOf(litros.getText()));
        Dao<Producao> daop = new Dao(Producao.class);
        daop.inserir(producao);
        mostrarSucesso("Produção registrada!");
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
}
