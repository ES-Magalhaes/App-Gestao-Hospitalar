package com.edu.fatec.appgestaohospitalar.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.edu.fatec.appgestaohospitalar.R;
import com.edu.fatec.appgestaohospitalar.model.HospitalData;
import com.edu.fatec.appgestaohospitalar.model.Medico;

public class CadastroMedicoBottomSheet extends BottomSheetDialogFragment {

    // Criamos uma interface (Callback) para avisar a tela de Médicos que um novo foi salvo
    public interface OnMedicoSalvoListener {
        void onMedicoSalvo();
    }

    private OnMedicoSalvoListener listener;

    public CadastroMedicoBottomSheet(OnMedicoSalvoListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_base_cadastro, container, false);

        // Configura o título do modal base
        view.findViewById(R.id.tv_modal_title);
        // Injeta o formulário do médico dentro do container
        ViewGroup containerForm = view.findViewById(R.id.frame_form_container);
        View formView = inflater.inflate(R.layout.form_medico, containerForm, true);

        // Mapeia os inputs do form_medico
        EditText edtNome = formView.findViewById(R.id.edt_nome_medico);
        EditText edtCpf = formView.findViewById(R.id.edt_cpf_medico);
        EditText edtCrm = formView.findViewById(R.id.edt_crm_medico);
        EditText edtEspecialidade = formView.findViewById(R.id.edt_especialidade_medico);

        // Configura o botão salvar do modal base
        view.findViewById(R.id.btn_salvar).setOnClickListener(v -> {
            String nome = edtNome.getText().toString();
            String cpf = edtCpf.getText().toString();
            String crm = edtCrm.getText().toString();
            String especialidade = edtEspecialidade.getText().toString();

            if (nome.isEmpty() || crm.isEmpty() || especialidade.isEmpty()) {
                Toast.makeText(getContext(), "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Cria o objeto e salva no nosso banco temporário
            Medico novoMedico = new Medico(nome, cpf, crm, especialidade);
            HospitalData.addMedico(novoMedico);

            // Avisa a tela principal para atualizar a lista
            if (listener != null) listener.onMedicoSalvo();

            dismiss(); // Fecha o modal
        });

        return view;
    }
}