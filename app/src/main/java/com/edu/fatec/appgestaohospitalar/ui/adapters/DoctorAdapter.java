package com.edu.fatec.appgestaohospitalar.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.edu.fatec.appgestaohospitalar.R;
import com.edu.fatec.appgestaohospitalar.model.Medico;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private List<Medico> listaMedicos;

    // Construtor que recebe a lista de médicos
    public DoctorAdapter(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Conecta o layout do card (item_doctor.xml) com o código
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        // Pega o médico atual da lista e preenche os campos de texto na tela
        Medico medico = listaMedicos.get(position);

        holder.tvNome.setText("Dr(a). " + medico.getNome());
        holder.tvEspecialidade.setText(medico.getEspecialidade());
        holder.tvCrm.setText("CRM " + medico.getCrm());
    }

    @Override
    public int getItemCount() {
        return listaMedicos.size(); // Diz ao RecyclerView quantos itens existem na lista
    }

    // Classe interna que "segura" as visualizações para não ter que buscar (findViewById) toda hora
    public static class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvEspecialidade, tvCrm;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tv_doctor_name);
            tvEspecialidade = itemView.findViewById(R.id.tv_doctor_specialty);
            tvCrm = itemView.findViewById(R.id.tv_doctor_crm);
        }
    }
}