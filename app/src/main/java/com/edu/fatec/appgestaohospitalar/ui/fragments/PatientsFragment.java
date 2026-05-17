package com.edu.fatec.appgestaohospitalar.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.fatec.appgestaohospitalar.R;
import com.edu.fatec.appgestaohospitalar.model.HospitalData;
import com.edu.fatec.appgestaohospitalar.ui.adapters.PatientAdapter;
import com.edu.fatec.appgestaohospitalar.ui.dialogs.CadastroPacienteBottomSheet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PatientsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Carrega o layout fragment_patients.xml
        View view = inflater.inflate(R.layout.fragment_patients, container, false);

        // 1. Encontra o RecyclerView na tela e diz que é uma lista vertical
        RecyclerView recyclerView = view.findViewById(R.id.recycler_patients);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 2. Encontra o botão flutuante (+)
        FloatingActionButton fabAddPatient = view.findViewById(R.id.fab_add_patient);

        // 3. Busca a lista direto do banco de dados temporário e conecta ao Adapter
        PatientAdapter adapter = new PatientAdapter(HospitalData.getPacientes());
        recyclerView.setAdapter(adapter);

        // 4. Configura o clique do botão para abrir o modal de pacientes
        fabAddPatient.setOnClickListener(v -> {
            CadastroPacienteBottomSheet modal = new CadastroPacienteBottomSheet(() -> {
                // Alerta o Adapter de que a lista aumentou e ele precisa redesenhar a tela
                adapter.notifyDataSetChanged();
            });
            modal.show(getParentFragmentManager(), "ModalCadastroPaciente");
        });

        return view;
    }
}