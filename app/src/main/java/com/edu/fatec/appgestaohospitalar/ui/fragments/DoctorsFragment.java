package com.edu.fatec.appgestaohospitalar.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// --> Adicionamos essas duas importações para o RecyclerView funcionar
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.fatec.appgestaohospitalar.model.HospitalData;
import com.edu.fatec.appgestaohospitalar.ui.adapters.DoctorAdapter;
import com.edu.fatec.appgestaohospitalar.ui.dialogs.CadastroMedicoBottomSheet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.edu.fatec.appgestaohospitalar.R;

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

        // Buscamos a lista direto do HospitalData
        DoctorAdapter adapter = new DoctorAdapter(HospitalData.getMedicos());
        recyclerView.setAdapter(adapter); // Agora o Android sabe quem é o recyclerView!

        fabAddDoctor.setOnClickListener(v -> {
            // Abrimos o novo modal passando o "listener". Quando o modal salvar, ele executa o código abaixo:
            CadastroMedicoBottomSheet modal = new CadastroMedicoBottomSheet(() -> {
                // Alerta o Adapter de que a lista aumentou e ele precisa redesenhar a tela
                adapter.notifyDataSetChanged();
            });
            modal.show(getParentFragmentManager(), "ModalCadastroMedico");
        });

        return view;
    }
}