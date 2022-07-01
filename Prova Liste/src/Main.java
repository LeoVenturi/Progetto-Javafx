import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	Medico medico = new Medico();
	Paziente paziente = new Paziente();
	FattoreRischio fattorerischio = new FattoreRischio();
	Segnalazioni segnalazioni = new Segnalazioni();
	
	String u, p;
	int c = 0;
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Username: ");
	u = keyboard.nextLine();
	System.out.print("Password: ");
	p = keyboard.nextLine();
	
	while (u.equals(medico.getMed_Username(c)) != true) {
		c++;
	}
	
	if (p.equals(medico.getMed_Password(c)))
		System.out.println("Accesso");
	}
}
