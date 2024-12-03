package com.example.buttonmenu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class SignUpFrag extends Fragment {

    private TextInputEditText et_userName, et_name, et_phone, etEmail, etPassword, et_confirmPassword;
    private Button signUpBtn;
    private FirebaseAuth mAuth;

    public SignUpFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        et_userName = view.findViewById(R.id.et_userName);
        et_name = view.findViewById(R.id.et_name);
        et_phone = view.findViewById(R.id.et_phone);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        et_confirmPassword = view.findViewById(R.id.et_confirmPassword);
        signUpBtn = view.findViewById(R.id.btnSignUp);
        if (!checkName()){
            Toast.makeText(getActivity(),"Name is short",Toast.LENGTH_SHORT).show();
        }
         else if (!checkPone()){
                Toast.makeText(getActivity(),"phone number is wrong",Toast.LENGTH_SHORT).show();
            }
            else if (!checkEmail()){
                    Toast.makeText(getActivity(),"email has to be from letters and symbols",Toast.LENGTH_SHORT).show();
                }
                else if (!checkPassword()) {
                        Toast.makeText(getActivity(),"password has to be from capital and small letters",Toast.LENGTH_SHORT).show();
                    }
                else {
                     
        }
        return view;
    }
    private void addUserToFireBase(){
        User user=new User(et_name,et_userName,et_phone,etEmail);
        Map<String,Object> map1;
        map1=new HashMap<>();
        map1.put("Name",user.getName());
        map1.put("Email",user.getEmail());
        map1.put("userName",user.getUserName());
        map1.put("phone",user.getPhone());
    }



    private boolean checkName() {
        boolean flag = true;
        String name = et_name.getText().toString();
        name = et_name.getText().toString();
        name.toCharArray();
        if (name.length() < 4) {
            flag = false;
        }
        return flag;
    }

    private boolean checkPone() {
        String phone = et_phone.getText().toString();
        int x = phone.length();
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < x; i++) {
                if (Character.isDigit(phone.charAt(i))) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    private boolean checkEmail() {
        boolean flag = true;
        String email = etEmail.getText().toString();
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean checkPassword() {
        String pass = etPassword.getText().toString();
        boolean flag = true;
        int x = pass.length(), countNum = 0, countLetters = 0,sum=0,countCapital=0,countSmall=0;
        for (int i = 0; i < x; i++) {
            if (Character.isDigit(pass.charAt(i))) {
                countLetters++;
            } else {
                countNum++;
            }
            if(Character.isUpperCase(pass.charAt(i))){
                countCapital++;
            }
            else {
                countSmall++;
            }

        }
        sum=countLetters+countNum;
        if (sum<6||countSmall==0||countCapital==0){
            flag=false;
        }
        return flag;
        }

    }
