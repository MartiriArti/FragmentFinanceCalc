package com.example.tonydarko.fragmentfinancecalc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tonydarko.fragmentfinancecalc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class CreditFragment extends Fragment {

    public static CreditFragment newInstance() {
        return new CreditFragment();
    }

    @BindView(R.id.edit_text_sum_credit)
    EditText editTextSumOfCredit;
    @BindView(R.id.edit_text_stavka)
    EditText editTextStavka;
    @BindView(R.id.edit_text_duration)
    EditText editTextDuration;
    @BindView(R.id.edit_text_strahovka)
    EditText editTextStrahovka;
    @BindView(R.id.edit_text_avans)
    EditText editTextAvan;
    @BindView(R.id.edit_text_komissiya)
    EditText editTextKomissiya;

    @BindView(R.id.tv_vznos)
    TextView textViewVznos;
    @BindView(R.id.tv_mes_platej)
    TextView textViewMesPlatej;
    @BindView(R.id.tv_pereplata)
    TextView textViewPereplata;
    @BindView(R.id.tv_itogovaya_summa)
    TextView textViewItogovaya;

    float sumOfCredit = 0f, stavka = 0f, duration = 0f, strahovka = 0f, avans = 0f, komissiya = 0f,
            vznos, mesPlatej, pereplata, itogovaya;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_credit, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Credit Calc");
        ButterKnife.bind(this, root);
        return root;
    }

    @OnTextChanged({R.id.edit_text_sum_credit, R.id.edit_text_stavka, R.id.edit_text_duration,
            R.id.edit_text_strahovka, R.id.edit_text_avans, R.id.edit_text_komissiya})
    public void onTextChange(Editable e) {

        if (!editTextSumOfCredit.getText().toString().equals("")) {
            sumOfCredit = Float.parseFloat(editTextSumOfCredit.getText().toString());
        }
        if (!editTextAvan.getText().toString().equals("")) {
            avans = Float.parseFloat(editTextAvan.getText().toString());
        }
        if (!editTextStavka.getText().toString().equals("")) {
            stavka = Float.parseFloat(editTextStavka.getText().toString());
        }
        if (!editTextDuration.getText().toString().equals("")) {
            duration = Float.parseFloat(editTextDuration.getText().toString());
        }
        if (!editTextStrahovka.getText().toString().equals("")) {
            strahovka = Float.parseFloat(editTextStrahovka.getText().toString());
        }
        if (!editTextKomissiya.getText().toString().equals("")) {
            komissiya = Float.parseFloat(editTextKomissiya.getText().toString());
        }

        vznos = vznos(sumOfCredit, avans);
        textViewVznos.setText(vznos + "");

        mesPlatej = mesPlatej(vznos, sumOfCredit, duration, stavka, strahovka, komissiya);
        textViewMesPlatej.setText(mesPlatej + "");

        textViewPereplata.setText(pereplata + "");

        itogovaya = (sumOfCredit) + (mesPlatej * duration);
        textViewItogovaya.setText(itogovaya + "");


    }

    public float vznos(float sumOfCredit, float avans) {
        return sumOfCredit * 0.01f * avans;
    }

    public float mesPlatej(float vznos, float sumOfCredit, float duration,
                           float stavka, float strahovka, float komissiya) {
        sumOfCredit = sumOfCredit - vznos;
        float mesyachniy = sumOfCredit / duration;
        float mesyachniyWithPercents = mesyachniy * 0.01f * stavka * strahovka * komissiya;
        pereplata = (mesyachniyWithPercents) * duration;
        return mesyachniyWithPercents;
    }


}
