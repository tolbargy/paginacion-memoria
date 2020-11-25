import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static ArrayList<Page> ram = new ArrayList<>();
	private static Queue<Integer> freeFrames = new LinkedList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("***PAGINACION DE MEMORIA***");
			manejarMemoria();
		}
	}

	private static void manejarMemoria() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n***Gestionar RAM***");
		System.out.println("Opciones:");
		System.out.println("1. Definir la capacidad");
		System.out.println("2. Mostrar estado");
		System.out.print("Elija la opcion: ");
		int opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			System.out.print("Ingrese la capacidad: ");
			crearRam(scanner.nextInt());
			break;
		case 2:
			mostrarEstado();
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

	private static void crearRam(int numberOfFrames) {
		for (int i = 0; i < numberOfFrames; i++) {
			ram.add(new Page());
			freeFrames.add(i);
		}
	}

	private static void mostrarEstado() {
		System.out.println("Frame\tPage #\tPID");
		for (int i = 0; i < ram.size(); i++) {
			System.out.printf("%d\t\t%d\t\t%d\n", i, ram.get(i).pageID, ram.get(i).pid);
		}
	}

}

class Page {
	protected int frame;
	protected int pid;
	protected int pageID;

	public Page() {
	}

	public Page(int pid, int pageID) {
		this.pid = pid;
		this.pageID = pageID;
	}
}