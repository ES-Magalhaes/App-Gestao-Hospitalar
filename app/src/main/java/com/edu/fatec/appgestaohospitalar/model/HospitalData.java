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
        // ATENÇÃO: Se a sua API usa um 'int id' no banco de dados,
        // a sua classe Medico precisará ter esse campo no construtor.
        // Aqui mantive a estrutura original, mas o ideal é que eles tenham um ID
        // numérico.
        listaMedicos.add(new Medico("Roberto Silva", "11122233344", "123456", "Cardiologia"));
        listaMedicos.add(new Medico("Ana Costa", "55566677788", "789012", "Pediatria"));
        listaMedicos.add(new Medico("Carlos Mendes", "99900011122", "456123", "Neurologia"));
        listaMedicos.add(new Medico("Juliana Lima", "33344455566", "998214", "Dermatologia"));

        listaPacientes.add(new Paciente("Helena Silva", 34, "#4429", "12 Mai, 2024", "ESTÁVEL"));
        listaPacientes.add(new Paciente("Ricardo Mendes", 52, "#3910", "28 Abr, 2024", "CRÍTICO"));
        listaPacientes.add(new Paciente("Ana Beatriz", 8, "#5102", "05 Jun, 2024", "PENDENTE"));
    }

    // ==========================================
    // MÉTODOS DE CONSULTA E INSERÇÃO LOCAL
    // ==========================================

    public static List<Medico> getMedicos() {
        return listaMedicos;
    }

    public static void addMedico(Medico medico) {
        listaMedicos.add(medico);
    }

    public static List<Paciente> getPacientes() {
        return listaPacientes;
    }

    public static void addPaciente(Paciente paciente) {
        contadorIdPaciente++;
        paciente.setPacienteId("#" + contadorIdPaciente);
        paciente.setUltimaVisita("Hoje");
        listaPacientes.add(paciente);
    }

    /**
     * Atualiza um Médico na lista local buscando pelo ID numérico.
     */
    public static boolean atualizarMedicoLocal(int id, Medico medicoAtualizado) {
        for (int i = 0; i < listaMedicos.size(); i++) {
            // Assumindo que a classe Medico agora possui o método getId() retornando int
            if (listaMedicos.get(i).getId() == id) {
                listaMedicos.set(i, medicoAtualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um Médico da lista local buscando pelo ID numérico.
     */
    public static boolean deletarMedicoLocal(int id) {
        for (int i = 0; i < listaMedicos.size(); i++) {
            if (listaMedicos.get(i).getId() == id) {
                listaMedicos.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean atualizarPacienteLocal(String idPaciente, Paciente pacienteAtualizado) {
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i).getPacienteId().equals(idPaciente)) {
                listaPacientes.set(i, pacienteAtualizado);
                return true;
            }
        }
        return false;
    }

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

    /**
     * Envia os dados atualizados do Médico para a API Remota usando int id.
     */
    public static void atualizarMedicoRemoto(int id, Medico medicoAtualizado, Callback<Medico> callback) {
        ApiService api = RetrofitClient.getApiService();
        Call<Medico> call = api.updateMedico(id, medicoAtualizado);
        call.enqueue(callback);
    }

    /**
     * Envia o comando de exclusão do Médico para a API Remota usando int id.
     */
    public static void deletarMedicoRemoto(int id, Callback<Void> callback) {
        ApiService api = RetrofitClient.getApiService();
        Call<Void> call = api.deleteMedico(id);
        call.enqueue(callback);
    }
}