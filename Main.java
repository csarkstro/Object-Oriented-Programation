import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cuestionario cue = new Cuestionario();
		
		
	    boolean sesion=true,salida2=true;
		int band=0,matricula[]= {1895206,1947805,1946491},comprob[]= {0,0,0},op2,op3,i;
		String op;
		
		Scanner scan = new Scanner(System.in);
		
		Maestro m[] = new Maestro[8];
		
		m[0] = new Maestro("Pedro", "1");
		m[1] = new Maestro("Luis","2");
		m[2] = new Maestro("Marta","3");
		m[3] = new Maestro("Alfonso","4");
		m[4] = new Maestro("Pegonia","5");
		m[5] = new Maestro("Miguel","6");
		m[6] = new Maestro("Jose Luis","7");
		m[7] = new Maestro("Cristina","8");
		
	    
		do {
			System.out.println("\nInicio de sesion\nIngresa tu matricula");
			op3 = scan.nextInt();
			for(i=0; i < matricula.length;i++) {
				if(matricula[i]== op3) {
					sesion=false;
					band = i;
					i=matricula.length-1;
					}
				else if(sesion){
						System.out.println("\nNo ha ingresado ningna matricula correcta");
				}
			}
			}while(sesion);
		
		
		
			do {
				System.out.println("Ingresa la opcion deseada \n1.-Contestar cuestionario \n2.- Ver Ranking profesores \n3.- Salir \n\nResuesta: ");
				op=scan.next();
				
				switch(op) {
					case "1":
						for(i=0;i<matricula.length;i++);{
							if(comprob[band]==0) {
								do {
									System.out.println("\n\nPara que maestro quiere contestar el cuestionario?");
									for(i=0; i < m.length; i++) {
										System.out.println("  " + (i+1) + ".- " + m[i].getNombre());
										}
									System.out.println("Respuesta: ");	
									op2=scan.nextInt();

									
									if(op2>0 && op2<9) {
										System.out.println("Encuesta sobre el docente: " + m[op2-1].getNombre());
										cue.realizarTest();
										salida2=false;
									}
								}while(salida2);
								comprob[band] = 1;
							}
						}
						
						break;
					case "2":
						System.out.println("\n\tRanking de mejores maestros");
					for(i=0;i < m.length;i++) {
						System.out.println("\n " + i+1 +".- " +/*AQUI INGRESAR EL MAESTRO CON MAS RANK por ejemplo m[mejor].getNombre + */"\n");
					}
					salida2=false;
					break;
					
					case "3":
						salida2=true;
					break;
					default:
						System.out.println("\n\t\tError. Opcion invalida");
				}
				
		}while(salida2);
	}
}
