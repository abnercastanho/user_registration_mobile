package com.tofoli.userregistrationapp;

// Importa anotações do Room necessários para mapear esta classe como uma entidade no banco de dados//
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Locale;

public class User {

    //Define o campo 'id' como chave primária da tabela e conifugra pra ser gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Campos que representam as colunas da tabela para armazenar os dados do usuário//
    private String name; //Nome do Usuário
    private String cpf; //CPF do Usuário
    private String email; //Email do Usuário
    private String phone; //Fone do Usuário

    //Construtor da classe que será usado para criar novo objeto

    public User(String name, String cpf,String email,String phone)
    {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    //Métodos getter e setter para acessar e modificar os dados do objeto User

    //Retorna o ID do usuário
    public int getId(){return id;}

    //Define o ID do usuário (usado pelo Room para preencher automaticamente)
    public void setid(int id) {this.id = id;}

    //Retorna o nome do usuário
    public String getName(){return name;}

    //Retorna CPF do usuário
    public String getCpf(){return cpf;}

    //Retorna o email do usuário
    public String getEmail(){return email;}

    //Retorna o phone do usuário
    public String getPhone(){return phone;}
}
