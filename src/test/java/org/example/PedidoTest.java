package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("Pizza");
    }

    @Test
    void novoPedidoComecaEmAnalise() {
        assertEquals("Em analise", pedido.getEstado());
    }

    @Test
    void analisarPedidoEmAnaliseVaiParaPreparo() {
        assertTrue(pedido.analisar());
        assertEquals("Em preparo", pedido.getEstado());
    }

    @Test
    void naoEntregaPedidoEmAnalise() {
        assertFalse(pedido.entregar());
        assertEquals("Em analise", pedido.getEstado());
    }

    @Test
    void naoPreparaPedidoEmAnalise() {
        assertFalse(pedido.perparar());
        assertEquals("Em analise", pedido.getEstado());
    }

    @Test
    void entregarPedidoEmPreparoVaiParaEntregue() {
        pedido.analisar();
        assertTrue(pedido.entregar());
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void naoAnalisaPedidoEmPreparo() {
        pedido.analisar();
        assertFalse(pedido.analisar());
        assertEquals("Em preparo", pedido.getEstado());
    }

    @Test
    void naoAnalisaPedidoEntregue() {
        pedido.analisar();
        pedido.entregar();
        assertFalse(pedido.analisar());
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void naoPreparaPedidoEntregue() {
        pedido.analisar();
        pedido.entregar();
        assertFalse(pedido.perparar());
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    void naoEntregaPedidoEntregue() {
        pedido.analisar();
        pedido.entregar();
        assertFalse(pedido.entregar());
        assertEquals("Entregue", pedido.getEstado());
    }

}