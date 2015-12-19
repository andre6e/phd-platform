/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.Curriculum;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tommaso
 */
public class CurriculumManagerTest {
    
    public CurriculumManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
         try {
            CurriculumManager.getInstance().delete("Curriculmtest");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(CurriculumManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Test
    public void testgetInstance() {
         System.out.println("getInstance");
         CurriculumManager result = CurriculumManager.getInstance();
         assertNotNull(result);
         
    }

    /**
     * Test of insert method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsertok() throws Exception {
        
        System.out.println("insert");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum cur=new Curriculum();
        cur.setName("Curriculmtest");
        cur.setDescription("il Curriculum è di prova");  
        instance.insert(cur);
    }
    
    /**
     * Test of insert method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsertEmptyName() throws Exception {
        
        System.out.println("insert");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum c=new Curriculum();
        c.setName("");        
        c.setDescription("il Curriculum è di prova");  
        instance.insert(c);
    }
    
    /**
     * Test of insert method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsertMaxName() throws Exception {
        
        System.out.println("insert");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum c=new Curriculum();
        c.setName("ciaosonomario,ho sbagliato ad inserire il nome del curriculum"
                + "ciaosofdffrio,ho sbagliato ad inserire il nome del curriculum");
        c.setDescription("il Curriculum è di prova");  
        instance.insert(c);
    }
    
    /**
     * Test of insert method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testInserPresent() throws Exception {
        
        System.out.println("insert");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum c=new Curriculum();
        c.setName("Marketing e Comunicazione");
        c.setDescription("il Curriculum è di prova"); 
        instance.insert(c);
        
    }
    
     /**
     * Test of insert method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsertMaxDecription() throws Exception {
        
        System.out.println("insert");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum c=new Curriculum();
        c.setName("Marketing e Comunicazione");
        c.setDescription(testsup65536());
        instance.insert(c);
        
    }
   
    
    /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateok() throws Exception {
        System.out.println("update");
        String oldNameCurriculum = "Marketing e Comunicazione";
        Curriculum pCurriculum = new Curriculum();
        pCurriculum.setName("curriculum prova update");
        pCurriculum.setDescription("descrizione prova update");
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.update(oldNameCurriculum, pCurriculum);
    }

    /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateoldnotexist() throws Exception {
        System.out.println("update");
        String oldNameCurriculum = "ciao";
        Curriculum pCurriculum = new Curriculum();
        pCurriculum.setName("curriculum prova update");
        pCurriculum.setDescription("descrizione prova update");
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.update(oldNameCurriculum, pCurriculum);
    }
    /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateoldnull() throws Exception {
        System.out.println("update");
        String oldNameCurriculum = "";
        Curriculum pCurriculum = new Curriculum();
        pCurriculum.setName("curriculum prova update");
        pCurriculum.setDescription("descrizione prova update");
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.update(oldNameCurriculum, pCurriculum);
    }
    
    /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateoldmax() throws Exception {
        System.out.println("update");
        String oldNameCurriculum = "ciaosonomario,ho sbagliato ad inserire il nome del curriculum" 
                                   + "ciaosofdffrio,ho sbagliato ad inserire il nome del curriculum";
        Curriculum pCurriculum = new Curriculum();
        pCurriculum.setName("curriculum prova update");
        pCurriculum.setDescription("descrizione prova update");
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.update(oldNameCurriculum, pCurriculum);
    }
    
    /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateEmptyName() throws Exception {
        System.out.println("update");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum pCurriculum = new Curriculum();
        String oldNameCurriculum = "Marketing e Comunicazione";
        pCurriculum.setName("");
        pCurriculum.setDescription("descrizione prova update");
        instance.update(oldNameCurriculum, pCurriculum);
    }
    
     /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateNamemax() throws Exception {
        System.out.println("update");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum pCurriculum = new Curriculum();
        String oldNameCurriculum = "Marketing e Comunicazione";
        pCurriculum.setName("ciaosonomario,ho sbagliato ad inserire il nome del curriculum"
                + "ciaosofdffrio,ho sbagliato ad inserire il nome del curriculum");
        pCurriculum.setDescription("descrizione prova update");
        instance.update(oldNameCurriculum, pCurriculum);
    }
    
     /**
     * Test of update method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateDescriptionmax() throws Exception {
        System.out.println("update");
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum pCurriculum = new Curriculum();
        String oldNameCurriculum = "Marketing e Comunicazione";
        pCurriculum.setName("curriculum prova update");
        pCurriculum.setDescription(testsup65536());
        instance.update(oldNameCurriculum, pCurriculum);
    }
    
    /**
     * Test of delete method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteEmptyName() throws Exception {
        System.out.println("delete");
        String CurriculumName = "";
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.delete(CurriculumName);
        
    }
    
    /**
     * Test of delete method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteNameMax() throws Exception {
        System.out.println("delete");
        String CurriculumName = "ciaosonomario,ho sbagliato ad inserire il nome del curriculum"
                              + "ciaosofdffrio,ho sbagliato ad inserire il nome del curriculum";
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.delete(CurriculumName);
    }

    /**
     * Test of delete method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeletenotExist() throws Exception {
        System.out.println("delete");
        String CurriculumName = "ciaooooooooo";
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.delete(CurriculumName);
    }
    
    /**
     * Test of delete method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteok() throws Exception {
        System.out.println("delete");
        String CurriculumName = "Curriculmtest";
        CurriculumManager instance = CurriculumManager.getInstance();
        instance.delete(CurriculumName);
    }
    
    /**
     * Test of getCurriculumList method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurriculumList() throws Exception {
        System.out.println("getCurriculumList");
        CurriculumManager instance = CurriculumManager.getInstance();
        ArrayList<Curriculum> result = instance.getCurriculumList();
        for(Curriculum c: result){
            System.out.println("Nome: "+c.getName());
            System.out.println("Descrizione: "+c.getDescription());
            System.out.println("");
        }
    }

    /**
     * Test of getCurriculumByName method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurriculumByNameEmptyName() throws Exception {
        System.out.println("getCurriculumByName");
        String CurriculumName = "";
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum result = instance.getCurriculumByName(CurriculumName);
        System.out.println("Nome: "+result.getName());
        System.out.println("Descrizione: "+result.getDescription());
    }

    /**
     * Test of getCurriculumByName method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurriculumByNameMaxName() throws Exception {
        System.out.println("getCurriculumByName");
        String CurriculumName =  "ciaosofdffrio,ho sbagliato ad inserire il nome del curriculum"
                              + "ciaosonomario,ho sbagliato ad inserire il nome del curriculum";
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum result = instance.getCurriculumByName(CurriculumName);
        System.out.println("Nome: "+result.getName());
        System.out.println("Descrizione: "+result.getDescription());
    }

    /**
     * Test of getCurriculumByName method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurriculumByNameNamenotExist() throws Exception {
        System.out.println("getCurriculumByName");
        String CurriculumName = "ciaooooooooo";
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum result = instance.getCurriculumByName(CurriculumName);
        System.out.println("Nome: "+result.getName());
        System.out.println("Descrizione: "+result.getDescription());
    }

     /**
     * Test of getCurriculumByName method, of class CurriculumManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurriculumByNameok() throws Exception {
        System.out.println("getCurriculumByName");
        String CurriculumName = "Marketing e Comunicazione";
        CurriculumManager instance = CurriculumManager.getInstance();
        Curriculum result = instance.getCurriculumByName(CurriculumName);
        System.out.println("Nome: "+result.getName());
        System.out.println("Descrizione: "+result.getDescription());
    }
    private String testsup65536() {
        String c="dsdffdffdf";
        for(int e=0; e<6600; e++)
            c=c.concat(c);
        return c;
    }


}