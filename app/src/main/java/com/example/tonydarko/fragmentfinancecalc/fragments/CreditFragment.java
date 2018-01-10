package com.example.tonydarko.fragmentfinancecalc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_credit, container, false);
        ButterKnife.bind(this,root);
        return root;
    }

    @OnTextChanged({R.id.edit_text_sum_credit, R.id.edit_text_stavka, R.id.edit_text_duration,
            R.id.edit_text_strahovka, R.id.edit_text_avans, R.id.edit_text_komissiya})
    public void onTextChange(Editable e){
        Toast.makeText(getContext(), e, Toast.LENGTH_SHORT).show();
    }

}
