
public class Maestro {
	private String Nombre;
	private String Matricula;
	private String Ranking;
	
	public Maestro(String nombre, String matricula) {
		this.Nombre = nombre;
		this.Matricula = matricula;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
}
