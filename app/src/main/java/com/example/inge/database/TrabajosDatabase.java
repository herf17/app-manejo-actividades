package com.example.inge.database;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.inge.database.model.Actividades;
import com.example.inge.database.model.Proyectos;
import com.example.inge.database.model.Usuarios;

@Database(entities = {Usuarios.class, Proyectos.class, Actividades.class}, version = 3)
public abstract class TrabajosDatabase extends RoomDatabase {
    private static volatile TrabajosDatabase instancia;
    public abstract TrabajosDAO trabajosDAO();
    public static TrabajosDatabase getInstance(Context context){
        if (instancia == null){
            synchronized (TrabajosDatabase.class){
                if (instancia == null){
                    instancia = Room.databaseBuilder(context.getApplicationContext(),
                            TrabajosDatabase.class, "trabajos_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
                }
            }

        }
        return instancia;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new LlenadoUsuario(instancia).execute();
            new LlenadoProyecto(instancia).execute();
            new LlenadoActividad(instancia).execute();

        }
    };
    //Valores de pruebas que se insertan en la base de datos
    //La primera vez que se instala
    private  static  class LlenadoUsuario extends AsyncTask<Void, Void, Void>{
        private TrabajosDAO trabajosDAO;
        private  LlenadoUsuario(TrabajosDatabase db){
            trabajosDAO = db.trabajosDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            trabajosDAO.insertar(new Usuarios("Benjamin", "Quintero", "2020"));
            trabajosDAO.insertar(new Usuarios("Lineth", "Martinez", "2021"));
            trabajosDAO.insertar(new Usuarios("Fermín", "Quintero", "9180"));
            trabajosDAO.insertar(new Usuarios("Alexander", "Batista", "4529"));
            trabajosDAO.insertar(new Usuarios("Manuel", "Batista", "1736"));
            trabajosDAO.insertar(new Usuarios("Israel", "Valdéz", "3172"));
            trabajosDAO.insertar(new Usuarios("Toni", "Pérez", "6684"));
            trabajosDAO.insertar(new Usuarios("Ricardo", "Gomez", "5910"));
            return null;
        }
    }
    private  static  class LlenadoProyecto extends AsyncTask<Void, Void, Void>{
        private TrabajosDAO trabajosDAO;
        private  LlenadoProyecto(TrabajosDatabase db){
            trabajosDAO = db.trabajosDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            trabajosDAO.insertarProyecto(new Proyectos("Cambio techo gypsum","4/06/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Cambio Baldosas","8/05/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Trabajo de Carpinteria", "9/03/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Trabajo de plomeria por fuga", "10/03/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Cambio de canal del techo", "14/02/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Plomeria basica", "15/04/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Elictricidad basica", "8/05/2020"));
            trabajosDAO.insertarProyecto(new Proyectos("Albañileria", "24/03/2020"));
            return null;
        }
    }
    private  static  class LlenadoActividad extends AsyncTask<Void, Void, Void>{
        private TrabajosDAO trabajosDAO;
        private  LlenadoActividad(TrabajosDatabase db){
            trabajosDAO = db.trabajosDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            trabajosDAO.insertarActividades(new Actividades("Comprar gypsum","9/05/2020","Vacamonte",5,1));
            trabajosDAO.insertarActividades(new Actividades("Batir mezcla", "10/05/2020","Vista Alegre",7,8));
            trabajosDAO.insertarActividades(new Actividades("Comprar arena", "10/05/2020","Bella Vista",5,8));
            trabajosDAO.insertarActividades(new Actividades("Medir techo", "10/05/2020","La Chorrera",7,1));
            trabajosDAO.insertarActividades(new Actividades("Cortar gypsum", "10/05/2020","Vacamonte",4,1));
            trabajosDAO.insertarActividades(new Actividades("Comprar lechada", "10/05/2020","Cinta Costera",3,2));
            trabajosDAO.insertarActividades(new Actividades("medir piso", "10/05/2020","Vista Alegre",7,2));
            trabajosDAO.insertarActividades(new Actividades("Comprar roble", "10/05/2020","Vista Alegre",3,3));
            trabajosDAO.insertarActividades(new Actividades("Comprar tubos", "10/05/2020","Vista Alegre",7,4));
            trabajosDAO.insertarActividades(new Actividades("Comprar parches", "10/05/2020","Vista Alegre",4,5));
            trabajosDAO.insertarActividades(new Actividades("Comprar medidor", "10/05/2020","Vista Alegre",1,6));
            trabajosDAO.insertarActividades(new Actividades("Comprar interruptores", "10/05/2020","Vista Alegre",4,7));
            trabajosDAO.insertarActividades(new Actividades("Mantenimiento tablero", "10/05/2020","Vista Alegre",6,7));
            trabajosDAO.insertarActividades(new Actividades("Instalar linea electrica", "10/05/2020","Vista Alegre",5,7));
            trabajosDAO.insertarActividades(new Actividades("Comprar interruptores", "10/05/2020","Vista Alegre",3,4));
            trabajosDAO.insertarActividades(new Actividades("Comprar interruptores", "10/05/2020","Vista Alegre",4,5));
            trabajosDAO.insertarActividades(new Actividades("Calibrar medidor", "10/05/2020","Vista Alegre",5,7));
            trabajosDAO.insertarActividades(new Actividades("Repellar pared", "10/05/2020","Vista Alegre",1,8));
            return null;
        }
    }
}