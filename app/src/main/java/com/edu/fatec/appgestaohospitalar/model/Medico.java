package com.edu.fatec.appgestaohospitalar.model;

public class Medico {
    private Long id;
    private String nome;
    private String cpf;
    private String crm;
    private String especialidade;

    // 2. Construtor Vazio
    // Extremamente necessário! Bibliotecas que convertem Java para JSON (como Gson) precisam de um construtor vazio para funcionar.
    public Medico() {
    }

    // 3. Construtor Completo
    // Facilita a criação de um objeto Medico de uma vez só.
    public Medico(Long id, String nome, String cpf, String crm, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    // 4. Construtor sem ID
    // Útil para quando você vai CADASTRAR um médico novo (pois quem gera o ID é o banco de dados MySQL depois do salvamento).
    public Medico(String nome, String cpf, String crm, String especialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    // 5. Getters e Setters
    // Métodos para acessar e modificar os atributos de forma segura (Encapsulamento).

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
