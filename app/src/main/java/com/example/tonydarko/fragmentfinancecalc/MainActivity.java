package com.example.tonydarko.fragmentfinancecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tonydarko.fragmentfinancecalc.fragments.CreditFragment;
import com.example.tonydarko.fragmentfinancecalc.fragments.DepositFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    Unbinder unbinder;
    @BindView(R.id.btn_to_deposit)
    Button buttonDeposit;
    @BindView(R.id.btn_to_credit)
    Button buttonCredit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_to_deposit, R.id.btn_to_credit})
    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.btn_to_deposit:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, DepositFragment.newInstance())
                        .commit();
                break;
            case R.id.btn_to_credit:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, CreditFragment.newInstance())
                        .commit();
                break;
        }
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

}
