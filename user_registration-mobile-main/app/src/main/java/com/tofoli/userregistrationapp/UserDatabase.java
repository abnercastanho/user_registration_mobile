package com.tofoli.userregistrationapp;
//Importa as anotações e classes da biblioteca room e do android
import android.content.Context; // Classe que representa o contexto da aplicacao (necessario para acessar recurso)
import androidx.room.Database; //Anotação para marcar a classe como um banco de dados Room
import androidx.room.Room;
import androidx.room.RoomDatabase; //Classe base que representa o BD

/*
Anotação @Database define que a classe representa o banco de dados Room
Ela especifica as entidades (tabela) que o banco ira conter  e a versa do BD
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    // Instancia unica (singleton) do BD
    public static UserDatabase instance;

    //Metodo abstrato que sera implementado pela Room
    //Serve para acessar as operacoes do BD na UserDao
    public abstract UserDao userDao();

    //Metodo que retorna a instancia do BD
    //O uso do 'syncronized' garante que apenas uma thread possa acessar este método por vez, evitando que duas instancias do BD sejam criados acidentalmente
    public static synchronized UserDatabase getInstance(Context context){
        // Verificar se ja existe uma instancia de BD
        if(instance == null){
            //Cria a instancia do BD usando Room
            //Usa o contexto de aplicalção para evitar vazamento
            //fallbackToDestructiveMigration = se houver mudança de versao e nao houver migracao, o BD sera recriado do zero
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class, "User-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        //retorna a instancia criada
        return instance;
    }
}
