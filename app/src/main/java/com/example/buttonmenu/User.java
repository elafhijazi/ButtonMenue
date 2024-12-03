package com.example.buttonmenu;

import com.google.android.material.textfield.TextInputEditText;

public class User {
    private TextInputEditText name;
    private TextInputEditText userName;
    private TextInputEditText phone;
    private  TextInputEditText email;

    public User(TextInputEditText name,TextInputEditText userName,TextInputEditText phone,TextInputEditText email){
        this.name=name;
        this.userName=userName;
        this.phone=phone;
        this.email=email;

    }
    public TextInputEditText getName(){ return this.name;}
    public TextInputEditText getUserName(){return  this.userName;}
    public TextInputEditText getEmail(){return  this.email;}
    public TextInputEditText getPhone(){return this.phone;}

    public void setName(TextInputEditText name) {
        this.name = name;
    }

    public void setUserName(TextInputEditText userName) {
        this.userName = userName;
    }

    public void setPhone(TextInputEditText phone) {
        this.phone = phone;
    }

    public void setEmail(TextInputEditText email) {
        this.email = email;
    }
}
