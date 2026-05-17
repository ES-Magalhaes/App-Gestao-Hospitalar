package com.edu.fatec.appgestaohospitalar.model;

public class Paciente {
    private String nome;
    private int idade;
    private String pacienteId; // Ex: "#4429"
    private String ultimaVisita; // Ex: "12 Mai, 2024"
    private String status; // "ESTÁVEL", "CRÍTICO", "PENDENTE"

    public Paciente() {}

    public Paciente(String nome, int idade, String pacienteId, String ultimaVisita, String status) {
        this.nome = nome;
        this.idade = idade;
        this.pacienteId = pacienteId;
        this.ultimaVisita = ultimaVisita;
        this.status = status;
    }

    // Gerar Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getPacienteId() { return pacienteId; }
    public void setPacienteId(String pacienteId) { this.pacienteId = pacienteId; }
    public String getUltimaVisita() { return ultimaVisita; }
    public void setUltimaVisita(String ultimaVisita) { this.ultimaVisita = ultimaVisita; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}