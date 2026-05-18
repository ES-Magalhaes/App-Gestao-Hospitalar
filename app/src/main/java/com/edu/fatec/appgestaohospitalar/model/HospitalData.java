package com.edu.fatec.appgestaohospitalar.model;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

public class HospitalData {

    private static List<Medico> listaMedicos = new ArrayList<>();
    private static List<Paciente> listaPacientes = new ArrayList<>();
    private static int contadorIdPaciente = 5000;

    static {
        listaMedicos.add(new Medico("Roberto Silva", "11122233344", "123456", "Cardiologia"));
        listaMedicos.add(new Medico("Ana Costa", "55566677788", "789012", "Pediatria"));
        listaMedicos.add(new Medico("Carlos Mendes", "99900011122", "456123", "Neurologia"));
        listaMedicos.add(new Medico("Juliana Lima", "33344455566", "998214", "Dermatologia"));

        listaPacientes.add(new Paciente("Helena Silva", 34, "#4429", "12 Mai, 2024", "ESTÁVEL"));
        listaPacientes.add(new Paciente("Ricardo Mendes", 52, "#3910", "28 Abr, 2024", "CRÍTICO"));
        listaPacientes.add(new Paciente("Ana Beatriz", 8, "#5102", "05 Jun, 2024", "PENDENTE"));
    }

    public static List<Medico> getMedicos() {
        return listaMedicos;
    }

    public static void addMedico(Medico medico) {
        listaMedicos.add(medico);
    }

    public static List<Paciente> getPacientes() {
        return listaPacientes;
    }

    // Métodos para API Remota
    public static void carregarMedicosRemotos(Callback<List<Medico>> callback) {
        ApiService api = RetrofitClient.getApiService();
        Call<List<Medico>> call = api.getMedicos();
        call.enqueue(callback);
    }

    public static void salvarMedicoRemoto(Medico medico, Callback<Medico> callback) {
        ApiService api = RetrofitClient.getApiService();
        Call<Medico> call = api.addMedico(medico);
        call.enqueue(callback);
    }

    public static void addPaciente(Paciente paciente) {
        contadorIdPaciente++;
        paciente.setPacienteId("#" + contadorIdPaciente);
        paciente.setUltimaVisita("Hoje");
        listaPacientes.add(paciente);
    }
}
