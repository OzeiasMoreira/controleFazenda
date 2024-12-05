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
    
    @BsonProperty(value="brinco")
    private String brinco;

    @BsonProperty(value="data")
    private String data;

    @BsonProperty(value="quantidade")
    private Double quantidade;
    
    public Producao(){}

    public Producao(String brinco, String data, Double quantidade) {
        this.brinco = brinco;
        this.data = data;
        this.quantidade = quantidade;
    }

    public String getBrinco() {
        return brinco;
    }

    public void setBrinco(String brinco) {
        this.brinco = brinco;
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
