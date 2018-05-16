/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresorarchivostxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//import arbolesbinarios.*;
import ListasSE.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Andrés Sanabria y Erick Salazar
 */
public class CompresorArchivosTXT {
   
 
    
    public static void main(String[] args) {
        
        ListaSE lista = new ListaSE();
        String inputPath = System.getProperty("user.dir") + "\\files\\archivo.txt";
        String outputPath = System.getProperty("user.dir") + "\\files\\archivoComprimido.txt";
        
        BufferedReader br = null;
        BufferedWriter bw= null;
        
        //Lectura de archivo.txt y creación de la lista.
        try {      
            br = new BufferedReader(new FileReader(inputPath));   
            String line = br.readLine();
            
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    lista.insertar(line.charAt(i));                  
                }
                
                line = br.readLine();    
            }

            br.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");
        }
    
        
        Sort.quicksort(lista);  
        
        lista.mostrar();
        System.out.println(); 
        
        lista.fusionar();
        System.out.println(lista.obtenerCodigo(lista.cabeza, 'a'));
        System.out.println(lista.obtenerCodigo(lista.cabeza, ' '));
        System.out.println(lista.obtenerCodigo(lista.cabeza, 'l'));
        System.out.println(lista.obtenerCodigo(lista.cabeza, 'c'));
        System.out.println(lista.obtenerCodigo(lista.cabeza, 't'));
        lista.mostrar();
        
        
     
        br=null;
        bw=null;
        
        try {      
            br = new BufferedReader(new FileReader(inputPath));   
            bw = new BufferedWriter(new FileWriter(outputPath));
            String line = br.readLine();
            
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    bw.write(lista.obtenerCodigo(lista.cabeza,line.charAt(i)) );
                }
                
                line = br.readLine();  
                bw.newLine();
            }

            br.close();
            bw.close();

        } 
        catch (IOException | NumberFormatException e) {
            System.out.println("El archivo no se ha encontrado o su formato no es válido");
            
        }
        lista.mostrar();
    }
    
}
