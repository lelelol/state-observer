package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String ultimaNotificacao;
    private int totalNotificacoes;

    public Cliente(Pedido pedido) {
        pedido.addObserver(this);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }

    @Override
    public void update(Observable pedido, Object estado) {
        this.ultimaNotificacao = (String) estado;
        this.totalNotificacoes++;
        System.out.println("Pedido atualizado: " + estado);
    }
}