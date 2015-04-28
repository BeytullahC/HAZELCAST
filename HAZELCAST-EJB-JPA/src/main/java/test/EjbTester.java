package test;

import dao.local.CountriesFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;

/**
 * Created by 912867 on 28.04.2015.
 */

@LocalBean
@Singleton
public class EjbTester {
    @EJB
    private CountriesFacadeLocal local;
    @Schedule(second = "00",minute = "*",hour = "*")
    public void Test(Timer t){
        System.out.println("SIZE : "+local.findAll().size());
    }
}
