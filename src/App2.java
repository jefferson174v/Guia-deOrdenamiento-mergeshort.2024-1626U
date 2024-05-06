
//codigo sin comentarios

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = metodo0(scanner);
        int n = arreglo.length;

        metodo1(arreglo, 0, n - 1);
        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static int[] metodo0(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Por favor digite los datos del arreglo (separados por espacios): ");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                int[] arreglo = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arreglo[i] = Integer.parseInt(parts[i]);
                }
                return arreglo;
            } catch (NumberFormatException e) {
                System.out.println("Inserte un valor entero.");
            }
        }
    }

    public static void metodo1(int[] arreglo, int iz, int de) {
        if (iz < de) {
            int mid = (iz + de) / 2;
            metodo1(arreglo, iz, mid);
            metodo1(arreglo, mid + 1, de);
            metodo2(arreglo, iz, mid, de);
        }
    }

    public static void metodo2(int[] arreglo, int iz, int mid, int de) {
        int tamanoiz = mid - iz + 1;
        int tamanode = de - mid;
        int[] tempiz = new int[tamanoiz];
        int[] tempde = new int[tamanode];
        for (int i = 0; i < tamanoiz; i++) {
            tempiz[i] = arreglo[iz + i];
        }
        for (int j = 0; j < tamanode; j++) {
            tempde[j] = arreglo[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = iz;
        while (i < tamanoiz && j < tamanode) {
            if (tempiz[i] <= tempde[j]) {
                arreglo[k] = tempiz[i];
                i++;
            } else {
                arreglo[k] = tempde[j];
                j++;
            }
            k++;
        }
        while (i < tamanoiz) {
            arreglo[k] = tempiz[i];
            i++;
            k++;
        }
        while (j < tamanode) {
            arreglo[k] = tempde[j];
            j++;
            k++;
        }
    }
}
