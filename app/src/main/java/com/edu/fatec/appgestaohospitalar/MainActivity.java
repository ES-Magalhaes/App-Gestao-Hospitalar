package com.edu.fatec.appgestaohospitalar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

// Importação necessária para a barra de navegação
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.edu.fatec.appgestaohospitalar.ui.fragments.DashboardFragment;
import com.edu.fatec.appgestaohospitalar.ui.fragments.DoctorsFragment;

// Quando criar as outras telas, você importará elas aqui:
import com.edu.fatec.appgestaohospitalar.ui.fragments.PatientsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ela força o app a NÃO usar o modo noturno (Night Mode NO)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        // ---------------------------------
        // 1. Vinculamos a variável à barra que está no seu activity_main.xml
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Assim que a tela principal criar, carregamos o Fragment do Dashboard
        if (savedInstanceState == null) {
            carregarFragment(new DashboardFragment());
            // 2. Força o botão do Dashboard a ficar com a cor de "selecionado" ao abrir
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }

        // 3. A mágica acontece aqui: configuramos o que fazer ao clicar em cada item
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragmentSelecionado = null;
            int itemId = item.getItemId();

            // Verificamos qual botão foi clicado através do ID que definimos no menu
            if (itemId == R.id.nav_home) {
                fragmentSelecionado = new DashboardFragment();
            } else if (itemId == R.id.nav_doctors) {
                fragmentSelecionado = new DoctorsFragment(); // Descomente quando criar a tela
            } else if (itemId == R.id.nav_agendamento) {
                // fragmentSelecionado = new CalendarFragment(); // Descomente quando criar a tela
            } else if (itemId == R.id.nav_paciente) {
                fragmentSelecionado = new PatientsFragment(); // Descomente quando criar a tela
            }

            // Se um fragmento válido foi escolhido, nós o carregamos no contêiner
            if (fragmentSelecionado != null) {
                carregarFragment(fragmentSelecionado);
                return true; // Retorna true para a barra saber que o clique foi um sucesso e pintar o botão
            }

            return false;
        });
    }

    // Método auxiliar para trocar os Fragments dentro do contêiner
    private void carregarFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}