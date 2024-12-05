/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.App;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Ozeias
 */
public class MenuControle {
    
    @FXML
    private void vacas() throws IOException{
        App.setRoot("telaVaca");
    }
    
    @FXML
    private void usuario() throws IOException{
        App.setRoot("telaUsuario");
    }
    
    @FXML
    private void sair(){
        
    }
    
    @FXML
    private void producao() throws IOException{
        App.setRoot("telaProducao");
    }
    
    @FXML
    private void alterar() throws IOException{
        App.setRoot("alterarUsuario");  
    }
    
}
