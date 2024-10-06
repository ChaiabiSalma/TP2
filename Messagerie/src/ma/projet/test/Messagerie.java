
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

public class Messagerie {
    public static void main(String[] arg){
    /*EmployeService es=new EmployeService();
    es.create(new Employe("LACHGAR","Mohamed"));
    es.create(new Employe("RAMI","ALI"));
    es.create(new Employe("SAFI","Fatima"));
    
    Employe e=es.findById(3);
    if(e!=null){
        e.setNom("ALAOUI");
        e.setPrenom("Manale");
        es.update(e);
    }
    es.delete(es.findById(8));
    for(Employe emp : es.findAll()){
         System.out.println(""+emp.getNom());
    }*/
    EmployeService es=new EmployeService();
    MessageService ms=new MessageService();
    ms.create(new Message("Réunion","Réunion de fin d'année", new Date(),es.findById(6),es.findById(7)));
    ms.create(new Message("Réunion","Réunion de fin d'année", new Date(),es.findById(6),es.findById(7)));
    ms.create(new Message("Stage","Stage à Marrakech", new Date(),es.findById(7),es.findById(6)));
    ms.create(new Message("Stage","Stage à Marrakech", new Date(),es.findById(7),es.findById(9)));
    
    for(Message m : ms.findAll()){
        if(m.getEmpRecepteur().getId()==9)
         System.out.println(""+m.getSujet());
    }
    }
}
