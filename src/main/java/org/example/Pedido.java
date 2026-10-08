package org.example;

import java.util.Observable;

public class Pedido extends Observable {
    private String item;
    private PedidoEstado estado;

    public Pedido(String item) {
        this.item = item;
        this.estado = PedidoEstadoAnalise.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers(estado.getEstado());
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public boolean analisar() {
        return estado.analisar(this);
    }

    public boolean perparar() {
        return estado.perparar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }
}