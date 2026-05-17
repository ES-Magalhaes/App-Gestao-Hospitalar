package com.edu.fatec.appgestaohospitalar.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.edu.fatec.appgestaohospitalar.R;
import com.edu.fatec.appgestaohospitalar.model.Paciente;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private List<Paciente> listaPacientes;

    public PatientAdapter(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Paciente paciente = listaPacientes.get(position);

        holder.tvNome.setText(paciente.getNome());
        holder.tvDetalhes.setText(paciente.getIdade() + " anos • ID: " + paciente.getPacienteId());
        holder.tvData.setText(paciente.getUltimaVisita());

        String status = paciente.getStatus().toUpperCase();
        holder.tvStatus.setText(status);

        // Lógica de Cores Dinâmicas
        if (status.equals("ESTÁVEL")) {
            holder.viewIndicator.setBackgroundColor(Color.parseColor("#008A5E")); // Verde escuro
            holder.tvStatus.setTextColor(Color.parseColor("#065F46"));
            holder.tvStatus.setBackgroundColor(Color.parseColor("#A7F3D0")); // Fundo verde claro
        } else if (status.equals("CRÍTICO")) {
            holder.viewIndicator.setBackgroundColor(Color.parseColor("#D32F2F")); // Vermelho
            holder.tvStatus.setTextColor(Color.parseColor("#991B1B"));
            holder.tvStatus.setBackgroundColor(Color.parseColor("#FECACA")); // Fundo vermelho claro
        } else {
            holder.viewIndicator.setBackgroundColor(Color.parseColor("#0D47A1")); // Azul
            holder.tvStatus.setTextColor(Color.parseColor("#374151"));
            holder.tvStatus.setBackgroundColor(Color.parseColor("#E5E7EB")); // Fundo cinza claro
        }
    }

    @Override
    public int getItemCount() {
        return listaPacientes.size();
    }

    public static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvDetalhes, tvData, tvStatus;
        View viewIndicator;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tv_patient_name);
            tvDetalhes = itemView.findViewById(R.id.tv_patient_details);
            tvData = itemView.findViewById(R.id.tv_patient_last_visit);
            tvStatus = itemView.findViewById(R.id.tv_patient_status);
            viewIndicator = itemView.findViewById(R.id.view_patient_indicator);
        }
    }
}