package org.example;

public class PedidoEstadoAnalise extends PedidoEstado {
    private PedidoEstadoAnalise (){}
    private static PedidoEstadoAnalise instance = new PedidoEstadoAnalise();

    public static PedidoEstadoAnalise getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em analise";
    }

    public boolean analisar(Pedido pedido ){
        pedido.setEstado(PedidoEstadoPreparo.getInstance());
        return true;
    }
}
