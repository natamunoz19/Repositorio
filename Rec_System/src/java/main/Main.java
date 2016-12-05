/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.Usuarios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kronos16
 */
@Named(value = "main")
@SessionScoped
public class Main implements Serializable {

    public Main() {
    }
      
    private List<Usuarios> u = new ArrayList();

    public List<Usuarios> getU() {
        return u;
    }

    public void setU(List<Usuarios> u) {
        this.u = u;
    }
    
    private Integer id = 0; //Este es el id del usuario que esta conectado de forma actual
            
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer i){
        this.id=i;
    }
/*       
    public Usuarios prueba1(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rec_SystemPU");
        EntityManager em = emf.createEntityManager();
        Usuarios u = em.createNamedQuery("Usuarios.findById", Usuarios.class).setParameter("id", id).getSingleResult();
        return u;
    }
*/  
        /*Funcion principal del recomendador, retorna:
        0 => Si la recomendación es una película de acción
        1 => Si la recomendación es una película de terror
        2 => Si la recomendación es una película de comedia
        3 => Si la recomendación es una película animada
        4 => Si la recomendación es una película de ciencia ficción
        5 => Si la recomendación es una película de romance
        */
    public Integer connection(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Rec_SystemPU");
        EntityManager em = emf.createEntityManager();
        u = em.createNamedQuery("Usuarios.findAll", Usuarios.class).getResultList();
        System.out.println("Cal Accion"+Integer.parseInt(u.get(id-1).getCalAccion()));
 //-----------------------------------DETERMINAR INFORMACION RELEVANTE DE USUARIO ACTUAL-------------------------------       
        Integer[] cala = new Integer[6]; //Arreglo para acomodar los datos de calificacion
           cala[0] = Integer.parseInt(u.get(id-1).getCalAccion());
           cala[1] = Integer.parseInt(u.get(id-1).getCalTerror());
           cala[2] = Integer.parseInt(u.get(id-1).getCalComedia());  //Obtención de datos
           cala[3] = Integer.parseInt(u.get(id-1).getCalAnimada());  //de calificacion
           cala[4] = Integer.parseInt(u.get(id-1).getCalScifi());    //de el usuario a
           cala[5] = Integer.parseInt(u.get(id-1).getCalRoma());
           //NOTA: Para este prototipo se implemento de forma estática, explorar una opción dinámica más adelante
        Integer proma = (cala[0]+cala[1]+cala[2]+cala[3]+cala[4]+cala[5])/6; //Promedio de cal del usuario a
 //------------------------------------------------------------------------------------------------------------------------
 //-----------------------------------DETERMINAR INFORMACION DE CADA USUARIO EN LA LISTA-----------------------------------
            Integer[] calu = new Integer[6];
            Integer promu;  //Promedio de cal del usuario a
            Integer numeradorpeso; //Aqui se almacena el resultado de la sumatoria de la formula de peso
            Integer desviaciona;
            Integer desviacionu;
            ArrayList<Integer> peso = new ArrayList<Integer>();
            
         for(int a=0;a<u.size();a++){
           if(u.get(a).getId()!=id)
           {
            calu[0] = Integer.parseInt(u.get(a).getCalAccion());
            calu[1] = Integer.parseInt(u.get(a).getCalTerror());
            calu[2] = Integer.parseInt(u.get(a).getCalComedia());  //Obtención de datos
            calu[3] = Integer.parseInt(u.get(a).getCalAnimada());  //de calificacion
            calu[4] = Integer.parseInt(u.get(a).getCalScifi());      //de el usuario (a)
            calu[5] = Integer.parseInt(u.get(a).getCalRoma());
            promu = (calu[0]+calu[1]+calu[2]+calu[3]+calu[4]+calu[5])/6; //Promedio de cal del usuario a
            numeradorpeso=0;
            desviaciona=0;
            desviacionu=0;
            //Peso de la opinion de cada usuario con respecto al usuario actual
            for (int i=0; i<calu.length; i++)
            {
             numeradorpeso= (numeradorpeso+((cala[i]-proma)*(calu[i]-promu)));
             
             desviaciona= (desviaciona+((cala[i]-proma)*(cala[i]-proma)));
             desviacionu= (desviacionu+((calu[i]-promu)*(calu[i]-promu)));
            }
            int x;
            if(numeradorpeso!=0){
                 x= (desviaciona*desviacionu)/numeradorpeso;
            }               
            else{
                 x=100000;
            }
                 
            peso.add(x);   
            
            //-----------------------------------------------------------------
           }
           else
           {
               peso.add(666);
           }
            //CON ESTE SIMPLE CODIGO YA TENEMOS ACCESO A TODOS LOS DATOS DE LA TABLA Usuario
            //TODO EL CONTENIDO DE LA TABLA QUEDA GUARDADO EN LA LISTA u 
            //SUPONGO QUE ESO ES LO QUE ME PEDIAS
        }
         
         double numeradorrec = 0; //Aqui se almacena el resultado de la sumatoria de la formula de recomendacion
         double denominadorrec = 0;//Aqui se almacena el resultado de la sumatoria de la formula de recomendacion
         double[] valorrec = new double[6];
         double selector = 0;
         Integer recomendacion = 0;
         //Este ciclo calcula la recomendación que se le da a cada tipo de película
         for (int i=0 ; i<cala.length; i++)
         {   
             for (int t=0 ; t<u.size(); t++)
             {
                 if(u.get(t).getId()!=id)
                {
                 calu[0] = Integer.parseInt(u.get(t).getCalAccion());
                 calu[1] = Integer.parseInt(u.get(t).getCalTerror());
                 calu[2] = Integer.parseInt(u.get(t).getCalComedia());  //Obtención de datos
                 calu[3] = Integer.parseInt(u.get(t).getCalAnimada());  //de calificacion
                 calu[4] = Integer.parseInt(u.get(t).getCalScifi());      //de el usuario a
                 calu[5] = Integer.parseInt(u.get(t).getCalRoma());
                 promu = (calu[0]+calu[1]+calu[2]+calu[3]+calu[4]+calu[5])/6; //Promedio de cal del usuario a
                 numeradorrec=(numeradorrec+((calu[i]-promu)*(peso.get(t))));
                 denominadorrec=(denominadorrec+(peso.get(t)));
                }
             }
             
             valorrec[i]= (cala[i]+(numeradorrec/denominadorrec));
             if(valorrec[i]>selector)
             {
                 selector=valorrec[i];
                 recomendacion=i;
             }   
         }
         System.out.println("Valorrec:"+Arrays.toString(valorrec));
         System.out.println("Recomendador:"+recomendacion);
       return recomendacion;
//-------------------------------------------------------------------------------------------------------------
    }
    
    //Funcion encargada de solicitar los metadatos que se requieren en el recomendador
    //Retorna el String con el resultado de la busqueda 'q' requerida
    public String Metadatos(String q){
        try{
           URL url = new URL(q);
           URLConnection con = url.openConnection();
 
           BufferedReader in = new BufferedReader(
           new InputStreamReader(con.getInputStream()));
 
           String linea,resul="";
           while ((linea = in.readLine()) != null) {
               resul=resul+linea;
               System.out.println(linea);
            }
           return(resul);
        }
        catch(IOException a) {
              return(a.toString());
        } 
    }
    
    
    public String data(){
         String consul="";
         String resul="";
         Integer cat = connection();
         switch(cat){
             case 0:
                 consul="http://192.168.128.19:8983/solr/Recomendador/select?fl=id&indent=on&q=Genre:Acci%C3%B3n&wt=json";                
                 resul=Metadatos(consul);
                 break;
             case 1:
                 consul="http://192.168.128.19:8983/solr/Recomendador/select?fl=id&indent=on&q=Genre:Terror&wt=json";
                 resul=Metadatos(consul);
                 break;
             case 2:
                 consul="http://192.168.128.19:8983/solr/Recomendador/select?fl=id&indent=on&q=Genre:Comedia&wt=json";
                 resul=Metadatos(consul);
                 break;
             case 3:
                 consul="http://192.168.128.19:8983/solr/Recomendador/select?fl=id&indent=on&q=Genre:Animada&wt=json";
                 resul=Metadatos(consul);
                 break;
             case 4:
                 consul="http://192.168.128.19:8983/solr/Recomendador/select?fl=id&indent=on&q=Genre:Ciencia%20Ficci%C3%B3n&wt=json";
                 resul=Metadatos(consul);
                 break;
             case 5:
                 consul="http://192.168.128.19:8983/solr/Recomendador/select?fl=id&indent=on&q=Genre:Romance&wt=json";
                 resul=Metadatos(consul);
                 break;
         }
         return resul;
    }
    
}
