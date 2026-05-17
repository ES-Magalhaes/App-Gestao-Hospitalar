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
import com.edu.fatec.appgestaohospitalar.model.Paciente;

public class CadastroPacienteBottomSheet extends BottomSheetDialogFragment {

    public interface OnPacienteSalvoListener {
        void onPacienteSalvo();
    }

    private OnPacienteSalvoListener listener;

    public CadastroPacienteBottomSheet(OnPacienteSalvoListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_base_cadastro, container, false);

        ViewGroup containerForm = view.findViewById(R.id.frame_form_container);
        View formView = inflater.inflate(R.layout.form_paciente, containerForm, true);

        EditText edtNome = formView.findViewById(R.id.edt_nome_paciente);
        EditText edtIdade = formView.findViewById(R.id.edt_idade_paciente);
        EditText edtStatus = formView.findViewById(R.id.edt_status_paciente);

        view.findViewById(R.id.btn_salvar).setOnClickListener(v -> {
            String nome = edtNome.getText().toString();
            String idadeStr = edtIdade.getText().toString();
            String status = edtStatus.getText().toString();

            if (nome.isEmpty() || idadeStr.isEmpty() || status.isEmpty()) {
                Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            int idade = Integer.parseInt(idadeStr);

            // Salva no banco temporário (o ID e data são gerados automaticamente na classe HospitalData)
            Paciente novoPaciente = new Paciente(nome, idade, "", "", status);
            HospitalData.addPaciente(novoPaciente);

            if (listener != null) listener.onPacienteSalvo();

            dismiss();
        });

        return view;
    }
}