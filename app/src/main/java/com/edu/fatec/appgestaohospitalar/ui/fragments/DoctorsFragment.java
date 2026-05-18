package com.edu.fatec.appgestaohospitalar.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// --> Adicionamos essas duas importações para o RecyclerView funcionar
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.fatec.appgestaohospitalar.model.Medico;
import com.edu.fatec.appgestaohospitalar.model.HospitalData;
import com.edu.fatec.appgestaohospitalar.ui.adapters.DoctorAdapter;
import com.edu.fatec.appgestaohospitalar.ui.dialogs.CadastroMedicoBottomSheet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.edu.fatec.appgestaohospitalar.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Carrega o layout fragment_doctors.xml
        View view = inflater.inflate(R.layout.fragment_doctors, container, false);

        // --> AS DUAS LINHAS QUE FALTAVAM: Encontra o RecyclerView na tela e diz que é uma lista vertical
        RecyclerView recyclerView = view.findViewById(R.id.recycler_doctors);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Encontra o botão flutuante (+)
        FloatingActionButton fabAddDoctor = view.findViewById(R.id.fab_add_doctor);

        // 1. Inicialize o adapter e o RecyclerView
        DoctorAdapter adapter = new DoctorAdapter(HospitalData.getMedicos());
        recyclerView.setAdapter(adapter);

        // 2. Chame a API para buscar os dados
        HospitalData.carregarMedicosRemotos(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // 3. Atualize o adapter com os dados vindos do banco via Spring Boot
                    adapter.setListaMedicos(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
                Log.e("API_ERROR", "Erro ao carregar médicos: " + t.getMessage());
            }
        });

        fabAddDoctor.setOnClickListener(v -> {
            // Abrimos o novo modal passando o "listener". Quando o modal salvar, ele executa o código abaixo:
            CadastroMedicoBottomSheet modal = new CadastroMedicoBottomSheet(() -> {
                // Ao salvar novo médico, poderíamos recarregar da API ou apenas atualizar localmente
                adapter.notifyDataSetChanged();
            });
            modal.show(getParentFragmentManager(), "ModalCadastroMedico");
        });

        return view;
    }
}