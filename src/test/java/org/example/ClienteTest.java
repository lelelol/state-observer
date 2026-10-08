package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Pedido pedido;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("Pizza");
        cliente = new Cliente(pedido);
    }

    @Test
    void clienteSeRegistraComoObservador() {
        assertEquals(1, pedido.countObservers());
    }

    @Test
    void clienteNaoRecebeNotificacaoAoCriarPedido() {
        assertNull(cliente.getUltimaNotificacao());
        assertEquals(0, cliente.getTotalNotificacoes());
    }

    @Test
    void clienteRecebeNovoEstadoAoAnalisar() {
        pedido.analisar();
        assertEquals("Em preparo", cliente.getUltimaNotificacao());
    }

    @Test
    void clienteRecebeNovoEstadoAoEntregar() {
        pedido.analisar();
        pedido.entregar();
        assertEquals("Entregue", cliente.getUltimaNotificacao());
    }

    @Test
    void clienteEhNotificadoUmaVezPorTransicao() {
        pedido.analisar();
        pedido.entregar();
        assertEquals(2, cliente.getTotalNotificacoes());
    }

    @Test
    void clienteNaoEhNotificadoEmTransicaoInvalida() {
        pedido.entregar();
        pedido.perparar();
        assertEquals(0, cliente.getTotalNotificacoes());
    }

    @Test
    void clienteNaoEhNotificadoAposPedidoEntregue() {
        pedido.analisar();
        pedido.entregar();
        pedido.analisar();
        pedido.entregar();
        assertEquals(2, cliente.getTotalNotificacoes());
    }

    @Test
    void todosOsClientesSaoNotificados() {
        Cliente outroCliente = new Cliente(pedido);
        pedido.analisar();
        assertEquals("Em preparo", cliente.getUltimaNotificacao());
        assertEquals("Em preparo", outroCliente.getUltimaNotificacao());
    }

    @Test
    void clienteRemovidoNaoEhMaisNotificado() {
        pedido.deleteObserver(cliente);
        pedido.analisar();
        assertNull(cliente.getUltimaNotificacao());
        assertEquals(0, cliente.getTotalNotificacoes());
    }

    @Test
    void clienteSoRecebeNotificacaoDoProprioPedido() {
        Pedido outroPedido = new Pedido("Hamburguer");
        outroPedido.analisar();
        assertEquals(0, cliente.getTotalNotificacoes());
    }
}