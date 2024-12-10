/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlefazenda.modelo;

import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 *
 * @author Ozeias
 */
public class Producao {
    
    @BsonProperty(value="vaca")
    private String vaca;

    @BsonProperty(value="data")
    private String data;

    @BsonProperty(value="quantidade")
    private Double quantidade;
    
    public Producao(){}

    public Producao(String vaca, String data, Double quantidade) {
        this.vaca = vaca;
        this.data = data;
        this.quantidade = quantidade;
    }

    public String getVaca() {
        return vaca;
    }

    public void setVaca(String vaca) {
        this.vaca = vaca;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
