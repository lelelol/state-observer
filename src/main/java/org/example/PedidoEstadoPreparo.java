package org.example;

public class PedidoEstadoPreparo extends PedidoEstado {
    private PedidoEstadoPreparo (){}
    private static PedidoEstadoPreparo instance = new PedidoEstadoPreparo();

    public static PedidoEstadoPreparo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em preparo";
    }

    public boolean entregar(Pedido pedido ){
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}