package org.example;

import java.util.Observable;
import java.util.Observer;

public class Pedido extends Observable {
    private String item;
    private PedidoEstado estado;

    public Pedido(String item) {
        this.item = item;
        this.estado = PedidoEstadoAnalise.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado.getEstado();
    }

    public boolean analisar(){
        setChanged();
        notifyObservers();
        return estado.analisar(this);
    }
    public boolean perparar(){
        setChanged();
        notifyObservers();
        return estado.perparar(this);
    }
    public boolean entregar(){
        setChanged();
        notifyObservers();
        return estado.entregar(this);
    }

}