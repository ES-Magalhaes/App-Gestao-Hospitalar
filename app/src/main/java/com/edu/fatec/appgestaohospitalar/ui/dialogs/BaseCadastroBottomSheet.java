package com.edu.fatec.appgestaohospitalar.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.edu.fatec.appgestaohospitalar.R;

public class BaseCadastroBottomSheet extends BottomSheetDialogFragment {

    private String titulo;
    private int formLayoutResId;

    // Construtor para passar o título e qual formulário carregar
    public BaseCadastroBottomSheet(String titulo, int formLayoutResId) {
        this.titulo = titulo;
        this.formLayoutResId = formLayoutResId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_base_cadastro, container, false);

        TextView tvTitle = view.findViewById(R.id.tv_modal_title);
        FrameLayout frameContainer = view.findViewById(R.id.frame_form_container);
        View btnSalvar = view.findViewById(R.id.btn_salvar);

        tvTitle.setText(titulo);

        // Injeta o formulário específico (ex: form_medico.xml, form_paciente.xml) dentro do modal base
        View formView = inflater.inflate(formLayoutResId, frameContainer, false);
        frameContainer.addView(formView);

        btnSalvar.setOnClickListener(v -> {
            // Lógica para capturar os dados do formView e salvar via ViewModel
            dismiss();
        });

        return view;
    }
}