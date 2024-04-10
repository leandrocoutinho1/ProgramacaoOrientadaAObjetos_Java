/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppViagem;

import java.util.Date;
import java.util.List;

/**
 *
 * @author leandro.coutinho
 */
public class DestinoViagem {
    private String cidadeOrigem;
    private String paisOrigem;
    private String cidadeDestino;
    private String paisDestino;
    private Date dataViagem;
    private String horario;
    private List<String> atracoesRecomendadas;

    public DestinoViagem(String cidadeOrigem, String paisOrigem, String cidadeDestino, String paisDestino,
                         Date dataViagem, String horario, List<String> atracoesRecomendadas) {
        this.cidadeOrigem = cidadeOrigem;
        this.paisOrigem = paisOrigem;
        this.cidadeDestino = cidadeDestino;
        this.paisDestino = paisDestino;
        this.dataViagem = dataViagem;
        this.horario = horario;
        this.atracoesRecomendadas = atracoesRecomendadas;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public Date getDataViagem() {
        return dataViagem;
    }

    public String getHorario() {
        return horario;
    }

    public List<String> getAtracoesRecomendadas() {
        return atracoesRecomendadas;
    }
}