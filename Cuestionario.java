import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;


public class Cuestionario {
	Scanner sc = new Scanner(System.in);
	int horafija, minfijos, segfijos, i = 0, rank=0, respuesta[] = new int[5];
	float Punt = 0;
	String maestro;
	public void realizarTest() {
	
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		int segundos = calendario.get(Calendar.SECOND);
		
		 try{
			 
	            BufferedWriter bw = new BufferedWriter(
	            new FileWriter("Cuestionario" + horafija + "." + minfijos + "." + segfijos + ".txt"));
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
	        } catch(Exception ex){
	            System.out.println(ex);
	        }
		 
		 
		 try{
		        BufferedReader br = new BufferedReader(
		                new FileReader("Cuestionario" + horafija + "." + minfijos + "." + segfijos + ".txt")
		            );
		        String s;
		            while((s = br.readLine()) != null){
		            	if( s.equals("R"))
		            	{
		            		do {
		            			respuesta[i] = sc.nextInt();
		            			if((respuesta[i] < 1 || respuesta[i] > 3)){
		            			System.out.println("Ha ingresado un numero invalido, repita la respuesta");
		            			}
		            		}while(respuesta[i] < 1 || respuesta[i] > 3);
		            		i++;
		            	}
		            	else {
		            		System.out.println(s);
		            	}
		                
		            }
		            System.out.println("\n\nHa terminado de contestar el cuestionario de "+ maestro+".");
		            br.close();
		        } catch(Exception ex){
		            System.out.println(ex);
		        }
		 System.out.println("\nSus respuestas del cuestionario de "+ maestro + " son:\n");
		 i = 0;
		 try{
	            BufferedWriter bw = new BufferedWriter(
	            new FileWriter("Cuestionario_Contestado"+ hora + "." + minutos + "." + segundos + ".txt")
	            );
	            BufferedReader br = new BufferedReader(
	                new FileReader("Cuestionario" + horafija + "." + minfijos + "." + segfijos + ".txt")
	            );
	            String s;
	            bw.write("Cuestionario De "+ maestro + "\n\n");
	            while((s = br.readLine()) != null){
	            	if( s.equals("R"))
	            	{
	            		switch(respuesta[i]) {
	            		case 1: bw.write("\nMalo"+ "\n");
	            		System.out.println("Malo");
	            		Punt = Punt + 1;
	            		break;
	            		case 2:  bw.write("\nMedio"+ "\n");
	            		System.out.println("Medio");
	            		Punt = Punt + 2;
	            		break;
	            		case 3:  bw.write("\nExcelente"+ "\n");
	            		System.out.println("Excelente");
	            		Punt = Punt + 3;
	            		break;
	            		}
	            		i++;
	            	}
	            	else {
	            		System.out.println(s);
	            		bw.write(s);
	            	}
	            }
	            br.close();
	            bw.close();
	            System.out.println("===================\nSe iniciara encuesta del siguiente maestro:\n");
	        } catch(Exception ex){
	            System.out.println(ex);
	        }
		 
		 }
}
