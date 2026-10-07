package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer  {
    public Pedido pedido;

    public String getEstado(){
        return pedido.getEstado();
    }

    @Override
    public void update(Observable pedido, Object arg) {
        System.out.println(this.getEstado());
    }
}