import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Cuestionario {
	Scanner sc = new Scanner(System.in);
	int i = 0, rank=0;
	int[] respuesta = new int[5];
	
	public void realizarTest() {
		
		 try{
	            BufferedWriter bw = new BufferedWriter(
	            new FileWriter("Cuestionario.txt")
	            );
	            bw.write("¿Como calificarias la explicacion del maestro?" + "\n");
	            bw.write("R" + "\n");
	            bw.write("¿Cual seria la regularidad de asistencia del maestro?" + "\n");
	            bw.write("R" + "\n");
	            bw.write("¿Que tan bueno es el maestro para atender las dudas?" + "\n");
	            bw.write("R" + "\n");
	            bw.write("¿Que tanto dominio y conocimiento del tema que  tiene el maestro?" + "\n");
	            bw.write("R" + "\n");
	            bw.write("¿Que tanto incentiva el maestro al alumno a hacer tarea o informarse del tema fuera de clase?" + "\n");
	            bw.write("R" + "\n");
	            bw.close();
	            System.out.println("¡Archivo creado con éxito!");
	        } catch(Exception ex){
	            System.out.println(ex);
	        }
		 
		 System.out.println("Se comenzara el cuestionario...");
		 
		 try{
		        BufferedReader br = new BufferedReader(
		                new FileReader("Cuestionario.txt")
		            );
		        String s;
		            while((s = br.readLine()) != null){
		            	if( s.equals("R"))
		            	{
		            		respuesta[i] = sc.nextInt();
		            		switch(respuesta[i]) {
		            		case 1:
		            			rank = rank + 1;
		            			break;
		            		case 2:
		            			rank = rank + 2;
		            			break;
		            		case 3:
		            			rank = rank + 3;
		            			break;	
		            		}
		            		i++;
		            	}
		            	else {
		            		System.out.println(s);
		            	}
		                
		            }
		            System.out.println("Ha terminado de contestar el cuestionario");
		            br.close();
		        } catch(Exception ex){
		            System.out.println(ex);
		        }
		 rank = rank/5;
		 System.out.println("Sus respuestas son:");
		 i = 0;
		 try{
	            BufferedWriter bw = new BufferedWriter(
	            new FileWriter("Cuestionario_Contestado.txt")
	            );
	            BufferedReader br = new BufferedReader(
	                new FileReader("Cuestionario.txt")
	            );
	            String s;
	            while((s = br.readLine()) != null){
	            	if( s.equals("R"))
	            	{
	            		switch(respuesta[i]) {
	            		case 1: bw.write("Excelente"+ "\n");
	            		System.out.println("Excelente");
	            		break;
	            		case 2:  bw.write("Medio"+ "\n");
	            		System.out.println("Medio");
	            		break;
	            		case 3:  bw.write("Malo"+ "\n");
	            		System.out.println("Malo");
	            		break;
	            		}
	            		 	
	            		i++;
	            	}
	            	else {
	            		System.out.println(s);
	            	}
	            }
	            br.close();
	            bw.close();
	            System.out.println("Ha finalizado el cuestionario");
	        } catch(Exception ex){
	            System.out.println(ex);
	        }
	}
}
