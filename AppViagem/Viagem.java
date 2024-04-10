/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppViagem;

import java.util.Date;

/**
 *
 * @author leandro.coutinho
 */
public class Viagem {
    private DestinoViagem destinoViagem;
    private Date dataViagem;
    private String horario;

    public Viagem(DestinoViagem destinoViagem, Date dataViagem, String horario) {
        this.destinoViagem = destinoViagem;
        this.dataViagem = dataViagem;
        this.horario = horario;
    }

    public DestinoViagem getDestinoViagem() {
        return destinoViagem;
    }

    public Date getDataViagem() {
        return dataViagem;
    }

    public String getHorario() {
        return horario;
    }
}