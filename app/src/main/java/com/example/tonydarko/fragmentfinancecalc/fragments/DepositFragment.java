package com.example.tonydarko.fragmentfinancecalc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tonydarko.fragmentfinancecalc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnTextChanged;

public class DepositFragment extends Fragment {

    public static DepositFragment newInstance() {
        return new DepositFragment();
    }

    @BindView(R.id.checkbox_kap)
    CheckBox checkBox;

    @BindView(R.id.edit_text_summa_vklada)
    EditText editTextSummaVklada;
    @BindView(R.id.edit_text_stavka)
    EditText editTextStavka;
    @BindView(R.id.edit_text_duration)
    EditText editTextDuration;
    @BindView(R.id.edit_text_popolnenie)
    EditText editTextPopolnenie;
    @BindView(R.id.edit_text_nalog)
    EditText editTextNalog;

    @BindView(R.id.tv_mesachniy_dohod)
    TextView textViewMesDohod;
    @BindView(R.id.tv_obshiy_dohod)
    TextView textViewObshiyDohod;
    @BindView(R.id.tv_obshaya_summa_popolneniy)
    TextView textViewObshayaSummaPopolneniy;
    @BindView(R.id.tv_itogovaya_summa)
    TextView textViewItogovayaSumma;

    float sumVklada = 0f, stavka = 0f, duration = 0f, popolnenie = 0f, nalog = 0f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_deposit, container, false);
        ButterKnife.bind(this,root);
        return root;
    }

    @OnTextChanged({R.id.edit_text_nalog, R.id.edit_text_popolnenie, R.id.edit_text_duration,
            R.id.edit_text_stavka, R.id.edit_text_summa_vklada})
    public void onTextChange(Editable s){
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged(R.id.checkbox_kap)
    public void onChecked(){
        Toast.makeText(getContext(), "Check", Toast.LENGTH_SHORT).show();
    }
}
