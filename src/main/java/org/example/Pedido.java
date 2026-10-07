package org.example;

public class Pedido {
    private String item;
    private PedidoEstado estado;

    public Pedido(String item) {
        this.estado = PedidoEstadoAnalise.getInstance();
    }

    public void setEstado(PedidoEstado instance) {
        this.estado = estado;
    }
    public boolean analisar(){
        return estado.analisar(this);
    }
    public boolean perparar(){
        return estado.perparar(this);
    }
    public boolean entregar(){
        return estado.entregar(this);
    }
}
