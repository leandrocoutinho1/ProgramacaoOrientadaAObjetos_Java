/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppViagem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author leandro.coutinho
 */

public class ViagensDisponiveis {
    private List<String> cidadesOrigem;

    public ViagensDisponiveis() {
        // Inicialize a lista de cidades de origem
        this.cidadesOrigem = Arrays.asList("Buenos Aires, Argentina", "Córdoba, Argentina", "Lisboa, Portugal",
                "Los Angeles, Estados Unidos", "Marseille, França", "Montreal, Canadá", "Nova York, Estados Unidos",
                "Paris, França", "Porto, Portugal", "Rio de Janeiro, Brasil", "São Paulo, Brasil",
                "Toronto, Canadá");
    }

    public List<String> getCidadesOrigem() {
        return cidadesOrigem;
    }

    public List<String> getCidadesDestino(String cidadeOrigem) {
        // Remove a cidade de origem da lista de cidades de destino
        List<String> cidadesDestino = new ArrayList<>(cidadesOrigem);
        cidadesDestino.remove(cidadeOrigem);
        return cidadesDestino;
    }
}