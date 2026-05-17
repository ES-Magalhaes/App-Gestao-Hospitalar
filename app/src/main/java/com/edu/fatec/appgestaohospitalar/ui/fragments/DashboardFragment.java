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

public class DashboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        RecyclerView recyclerAtendimentos = view.findViewById(R.id.recycler_proximos_atendimentos);
        recyclerAtendimentos.setLayoutManager(new LinearLayoutManager(getContext()));

        // Aqui você instanciará o Adapter e passará a lista mockada (e futuramente do ViewModel/MySQL)
        // ConsultaAdapter adapter = new ConsultaAdapter(listaDeConsultas);
        // recyclerAtendimentos.setAdapter(adapter);

        return view;
    }
}