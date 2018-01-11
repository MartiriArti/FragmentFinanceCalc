package com.example.tonydarko.fragmentfinancecalc.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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

    float sumVklada = 0f, stavka = 0f, duration = 0f, popolnenie = 0f, nalog = 0f,
            mesDohod, obshiyDohod, sumPopolneniy, itogovaya;
    Boolean kapitalization = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_deposit, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Deposit Calc");
        ButterKnife.bind(this, root);
        return root;
    }

    @OnTextChanged({R.id.edit_text_nalog, R.id.edit_text_popolnenie, R.id.edit_text_duration,
            R.id.edit_text_stavka, R.id.edit_text_summa_vklada})
    public void onTextChange(Editable s) {
        if (!editTextSummaVklada.getText().toString().equals(""))
            sumVklada = Float.parseFloat(editTextSummaVklada.getText().toString());
        if (!editTextStavka.getText().toString().equals(""))
            stavka = Float.parseFloat(editTextStavka.getText().toString());
        if (!editTextDuration.getText().toString().equals(""))
            duration = Float.parseFloat(editTextDuration.getText().toString());
        if (!editTextPopolnenie.getText().toString().equals(""))
            popolnenie = Float.parseFloat(editTextPopolnenie.getText().toString());
        if (!editTextNalog.getText().toString().equals(""))
            nalog = Float.parseFloat(editTextNalog.getText().toString());

        mesDohod = mesDohod(sumVklada, stavka, nalog);
        textViewMesDohod.setText(mesDohod + "");

        obshiyDohod = obshiyDohod(sumVklada, stavka, nalog, duration);
        textViewObshiyDohod.setText(obshiyDohod + "");

        sumPopolneniy = popolnenie * duration;
        textViewObshayaSummaPopolneniy.setText(sumPopolneniy + "");

        itogovaya = sumVklada + obshiyDohod + sumPopolneniy;
        textViewItogovayaSumma.setText(itogovaya + "");

    }

    public float mesDohod(float sumVklada, float stavka, float nalog) {
        float dohod = sumVklada * 0.01f * stavka;
        float dohodWithoutNalog = dohod * 0.01f * nalog;
        return dohod - dohodWithoutNalog;
    }

    public float obshiyDohod(float sumVklada, float stavka, float nalog, float duration) {
        float dohodChistiy = 0f;

        for (int i = 0; i <= duration; i++) {
            float dohod = sumVklada * 0.01f * stavka;
            float dohodWithoutNalog = dohod * 0.01f * nalog;
            if (kapitalization) {
                sumVklada += dohodWithoutNalog;
            }
            dohodChistiy += dohodWithoutNalog;
        }

        return dohodChistiy;
    }

    @OnCheckedChanged(R.id.checkbox_kap)
    public void onChecked() {
        if (checkBox.isChecked()) {
            kapitalization = true;
        } else if (!checkBox.isChecked()) {
            kapitalization = false;
        }
    }
}
