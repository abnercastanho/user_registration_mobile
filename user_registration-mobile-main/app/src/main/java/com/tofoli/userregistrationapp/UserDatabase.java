package com.tofoli.userregistrationapp;
//Importa as anotações e classes da biblioteca room e do android
import androidx.room.Database; //Anotação para marcar a classe como um banco de dados Room
import androidx.room.RoomDatabase; //Classe base que representa o BD

/*
Anotação @Database define que a classe representa o banco de dados Room
Ela especifica as entidades (tabela) que o banco ira conter  e a versa do BD
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    // Instancia unica (singleton) do BD
    public abstract UserDatabase Instance;

    //Metodo abstrato que sera implementado pela Room
    //Serve para acessar as operacoes do BD na UserDao
    public abstract UserDao userDao();
}
