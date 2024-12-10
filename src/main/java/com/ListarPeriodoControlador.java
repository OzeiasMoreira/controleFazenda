package com;

import com.controlefazenda.modelo.Producao;
import com.controlefazenda.modelo.Vaca;
import com.controlefazenda.util.Dao;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarPeriodoControlador {

    private final ObservableList<Producao> dados = FXCollections.observableArrayList();

    @FXML
    private ComboBox<Vaca> listar;

    @FXML
    private TableView<Producao> prod;

    @FXML
    private TableColumn<Producao, String> colunaBrinco;

    @FXML
    private TableColumn<Producao, Double> colunaProd;

    private String listagem;

    @FXML
    public void initialize() {
        Dao<Vaca> daoV = new Dao<>(Vaca.class);
        List<Vaca> v = daoV.listarTodos();
        listar.setItems(FXCollections.observableArrayList(v));

        colunaBrinco.setCellValueFactory(new PropertyValueFactory<>("brinco"));
        colunaProd.setCellValueFactory(new PropertyValueFactory<>("producao"));
    }

    @FXML
    public void listarDia() {
        listagem = "dia";
        mostrarDados();
    }

    @FXML
    public void listarMes() {
        listagem = "mes";
        mostrarDados();
    }

    private void mostrarDados() {
        if (listar.getValue() == null) {
            mostrarErro("Selecione uma vaca antes de listar os dados!");
            return;
        }

        Dao<Producao> daoProducao = new Dao<>(Producao.class);
        List<Producao> producoes = daoProducao.listarTodos();

        String brincoSelecionado = listar.getValue().getBrinco();
        dados.clear();

        if ("dia".equals(listagem)) {
            LocalDate hoje = LocalDate.now();
            String dataAtual = hoje.format(DateTimeFormatter.ISO_DATE);

            dados.addAll(
                producoes.stream()
                    .filter(p -> p.getVaca().equals(brincoSelecionado) && p.getData().equals(dataAtual))
                    .collect(Collectors.toList())
            );
        } else if ("mes".equals(listagem)) {
            LocalDate hoje = LocalDate.now();
            String mesAtual = hoje.format(DateTimeFormatter.ofPattern("yyyy-MM"));

            dados.addAll(
                producoes.stream()
                    .filter(p -> p.getVaca().equals(brincoSelecionado) && p.getData().startsWith(mesAtual))
                    .collect(Collectors.toList())
            );
        }

        prod.setItems(dados);
        if (dados.isEmpty()) {
            mostrarErro("Nenhuma produção encontrada para o período selecionado.");
        }
    }

    @FXML
    public void voltar() throws IOException {
        App.setRoot("menu");
    }

    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.show();
    }
}
