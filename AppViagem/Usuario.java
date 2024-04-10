/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppViagem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author leandro.coutinho
 */
public class Usuario {
    private String nome;
    private int id;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private List<Viagem> viagens;

    public Usuario(String nome, int id, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.viagens = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void requisitarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public String mostrarViagens() {
        if (this.viagens == null || this.viagens.isEmpty()) {
            return "O usuário não possui viagens cadastradas.";
        } else {
            StringBuilder listaViagens = new StringBuilder();
            for (Viagem viagem : this.viagens) {
                listaViagens.append("Origem: ").append(viagem.getDestinoViagem().getCidadeOrigem())
                        .append(" - Destino: ").append(viagem.getDestinoViagem().getCidadeDestino())
                        .append(" - Data: ").append(viagem.getDataViagem())
                        .append(" - Horário: ").append(viagem.getHorario())
                        .append("\n");
            }
            return listaViagens.toString();
        }
    }
}

