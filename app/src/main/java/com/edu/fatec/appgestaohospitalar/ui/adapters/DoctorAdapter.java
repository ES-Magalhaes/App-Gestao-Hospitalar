package com.edu.fatec.appgestaohospitalar.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.edu.fatec.appgestaohospitalar.R;
import com.edu.fatec.appgestaohospitalar.model.Medico;
import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private List<Medico> listaMedicos = new ArrayList<>();

    // Construtor padrão
    public DoctorAdapter() {}

    // Construtor que recebe a lista inicial
    public DoctorAdapter(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos != null ? listaMedicos : new ArrayList<>();
    }

    // Método para atualizar a lista de médicos (chamado após a resposta da API)
    public void setListaMedicos(List<Medico> novaLista) {
        this.listaMedicos = novaLista != null ? novaLista : new ArrayList<>();
        notifyDataSetChanged(); // Notifica o RecyclerView que os dados mudaram
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Medico medico = listaMedicos.get(position);

        holder.tvNome.setText("Dr(a). " + medico.getNome());
        holder.tvEspecialidade.setText(medico.getEspecialidade());
        holder.tvCrm.setText("CRM " + medico.getCrm());
    }

    @Override
    public int getItemCount() {
        return listaMedicos.size();
    }

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
