package agh.cs.lab6;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        HashMap<Integer,String> mapa = new HashMap<>();
        mapa.put(0,"koło");
        mapa.put(7,"promień");
        mapa.put(79,"polak");
        mapa.put(121,"rzutnik");
        mapa.put(34,"ekran");
        mapa.put(18,"kujak");

        Collection<String> collection = mapa.values();
        List<String> lista = new ArrayList<>();
        lista.addAll(collection);

        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
        System.out.println(lista.get(4));
        System.out.println(lista.get(5));
        //System.out.println(lista.get(19));
        //System.out.println(lista.get(3910));
    }
}
