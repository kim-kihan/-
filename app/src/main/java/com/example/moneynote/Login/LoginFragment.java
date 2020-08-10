package com.example.moneynote.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.moneynote.MainActivity;
import com.example.moneynote.R;

public class LoginFragment extends Fragment {
    private EditText user_id, user_pw;
    private Button btn_login, btn_kakaologin, btn_join;
    private boolean login;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btn_join= view.findViewById(R.id.join);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                join();
            }
        });
        btn_login= view.findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day();
            }
        });

        return view;
    }

    public void join(){
        ((MainActivity)getActivity()).join();
    }

    public void day(){
        ((MainActivity)getActivity()).day();
    }

}


