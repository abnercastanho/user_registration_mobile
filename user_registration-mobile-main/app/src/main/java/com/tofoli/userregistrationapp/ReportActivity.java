package com.tofoli.userregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

//Importações de componentes de UI, Intenções e bibliotecas room
public class ReportActivity extends AppCompatActivity {
    //Campo de texto onde os dados do banco serao exibidos
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Define o layout XML dessa tela de relatorio
        setContentView(R.layout.activity_report);
        //Mapeamento do TextView do XML para o java
        textViewReport = findViewById(R.id.textViewReport);
        //Encontra o botao e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        //O botão de retorno utilizando expressao lambda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        /*
        Conexão com o banco de dados
        1 - cria uma instancia do Banco "User-database"
        2 - .allowMainThreadQueries(): serve para liberar operacoes de consulta feitas em threads da UI.
        Por padrao, ROOM poribe isso. O correto seria fazer consultas em threads separadas;
         */

        UserDatabase db = Room.databaseBuilder(getApplication() UserDatabase.class, "user-database"). allowMainThreadQueries().build();

        //Obtem o objeto DAO (Data Access Object) que contem as queries SQL
        UserDao userDao = db.UserDao();
        //Recupera todos os usuarios salvos no DB e armazena em uma lista
        List<User> userList = userDao.getAllUsers();
        //StringBuilder: forma eficiente de construir uma String longa dentro de um laço (loop)
        StringBuilder report = new StringBuilder();

        //loop "for-each" para percorrer cada objeto User dentro da lista reparada
        for (User user: userList){
            report.append("Nome: ").append(user.getName()).append("CPF: ").append(user.getCpf()).append("\n\n");
        }
        //Exibe o relatorio final montado na TextView da tela
        textViewReport.setText(report.toString());
    }

    //Metodo responsavel pela navegacao entre as telas do app
    private void voltarParaCadastro() {
        //Intencao para abrir a tela do cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        //Fecha a tela do relatorio para nao acumular na pilha de tarefas
        finish();
    }
}
