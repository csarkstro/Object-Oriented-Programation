import java.util.Calendar;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// Con esta declaracion podremos acceder a la clase de Cuestionario asi como a
		// sus metodos
		Cuestionario cue[] = new Cuestionario[8];
		// Con esta declaracion podremos acceder a la clase de Maestro ya como arreglo
		Maestro m[] = new Maestro[8];
		Maestro maux;
		// A partir de aqui declaramos diferentes tipos de variables
		boolean sesion = true, salida2 = true;
		int band = 0, matricula[] = { 1895206, 1947805, 1946491 }, comprob[] = { 0, 0, 0 }, op3, i,j;
		float auxcal;
		
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		int segundos = calendario.get(Calendar.SECOND);
		
		String op;
		Scanner scan = new Scanner(System.in);
		m[0] = new Maestro("Pedro", "1");
		m[1] = new Maestro("Luis", "2");
		m[2] = new Maestro("Marta", "3");
		m[3] = new Maestro("Alfonso", "4");
		m[4] = new Maestro("Pegonia", "5");
		m[5] = new Maestro("Miguel", "6");
		m[6] = new Maestro("Jose Luis", "7");
		m[7] = new Maestro("Cristina", "8");
		
		cue[0]= new Cuestionario();
		cue[1]= new Cuestionario();
		cue[2]= new Cuestionario();
		cue[3]= new Cuestionario();
		cue[4]= new Cuestionario();
		cue[5]= new Cuestionario();
		cue[6]= new Cuestionario();
		cue[7]= new Cuestionario();
		do {
			System.out.println("\nInicio de sesion\nIngresa tu matricula");
			op3 = scan.nextInt();
			for (i = 0; i < matricula.length; i++) {
				if (matricula[i] == op3) {
					sesion = false;
					band = i;
					//Aqui declaramos a i de esta forma para que el ciclo for termine
					i = matricula.length - 1;
				}
			}
			if (sesion) {
				System.out.println("\nNo ha ingresado ningna matricula correcta");
			}
		} while (sesion);

		do {
			System.out.println(
					"\n\n\tMenu!!\n\nIngresa la opcion deseada \n1.-Contestar cuestionarios \n2.- Ver Ranking profesores \n3.- Salir \n\nResuesta: ");
			op = scan.next();

			switch (op) {
			case "1":
				if (comprob[band] == 0) {
					System.out.println("\t¡Archivo de cuestionario creado con éxito!\nSe comenzara el cuestionario...(ingresa '1' para Malo, '2' para medio, '3' para Excelente\n\n");
						for (i = 0; i < m.length; i++) {
							System.out.println("Maestro N°" + (i + 1) + " " + m[i].getNombre());
							cue[i].horafija=hora;
							cue[i].minfijos=minutos;
							cue[i].segfijos=segundos;
							cue[i].maestro = m[i].getNombre();
							cue[i].realizarTest();
						}
						for(i=0;i<7;i++) {
							for(j=0;j<7;j++) {
								if(cue[j].Punt < cue[j+1].Punt){
									auxcal=cue[j].Punt;
									cue[j].Punt = cue[j+1].Punt;
									cue[j+1].Punt=auxcal;
									maux = m[j];
									m[j]= m[j+1];
									m[j+1]=maux;
								}
							}
						}
					comprob[band] = 1;
				} else {
					System.out.println("\nYa ha contestado el cuestionario anteriormente");
				}
				break;
				
			case "2":
				System.out.println("\n\tRanking de mejores maestros\n");
				for (i = 0; i < m.length; i++) {
					System.out.println(" " + (i + 1) + ".- " + m[i].getNombre());
				}
				break;

			case "3":
				System.out.println("\n\t¡¡¡Ha Finalizado el programa!!!\n");
				salida2 = false;
				break;
			default:
				System.out.println("\n\t\tError. Opcion invalida");
			}

		} while (salida2);
	}
}
