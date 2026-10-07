package org.example;

public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean analisar(Pedido pedido) {
        return false;
    }

    public boolean perparar(Pedido pedido) {
        return false;
    }

    public boolean entregar(Pedido pedido) {
        return false;
    }
}
