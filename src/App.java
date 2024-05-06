import java.util.Scanner;
// Clase app
class App {
    public static void main(String[] args) { //El main
        Scanner scanner = new Scanner(System.in); // Se llama al Scanner
        int [] arreglo= metodo0(scanner); //Se llama al metodo0 con parametro de scnnaer para que le dentre un Scanner
        int n = arreglo.length;

        metodo1(arreglo, 0, n - 1);
        System.out.println("Arreglo ordenado:"); // Arreglo ordenado
        for (int num : arreglo) { //se imprime cada valor del arreglo, esta vez ya ordenado, usando un for each
            System.out.print(num + " ");
        }

        scanner.close();
    }
    public static int[] metodo0(Scanner scanner){
        //En este caso la funcion input.split permite obtener los datos sin necesidad de presionar enter para dijitarlos uno por uno.
        // Split  permite dividir la cadena en las partes que el usuario aplico el enter, para pasarlas y almacenar sus datos en el arreglo llamado parts.
        while (true) { // se inicia un bloque infinito el cual termina solo con el retorno del arreglo.
            try{
                System.out.println("Por favor digite los datos del arreglo (separados por espacios): ");
                String input = scanner.nextLine(); //  Aca se usa el formato String ya que al pedirse usando espacios, es necesario.
                String[] parts = input.split(" "); // Se hace la division y se almacena.
                int[] arreglo = new int[parts.length]; //se crea un arreglo con tamano de el arreglo parts
                for (int i = 0; i < parts.length; i++) {// Para luego 
                arreglo[i] = Integer.parseInt(parts[i]);//Hacer una conversion de string a int que almacena los datos en el arreglo arrreglo.
                }
                return arreglo;
            }catch(NumberFormatException e){// se usa numberformatexception porque es una conversion, por lo cual se lanzara cuando de dijite un dato que no pueda convertirse a entero
                System.out.println("Inserte un valor entero.");
            }
        }
    }

    public static void metodo1(int[] arreglo, int iz, int de) { // este metodo es el que ordena los arreglos
        if (iz < de) { // si el tamano del arrelgo es manyor que 1
            int mid = (iz + de) / 2; // Si eso se cumple se calcula el indice medio el subarreglo
            metodo1(arreglo, iz, mid); // para el subarreglo que va de izquiera a l indice medio
            metodo1(arreglo, mid + 1, de); // y para el que va de indice medio + 1 a derecha
            metodo2(arreglo, iz, mid, de); //se llama a los 2 subarreglos y se combianan
        }
    }

    public static void metodo2(int[] arreglo, int iz, int mid, int de) { //toma de parametros el arreglo proporcionado, izquierda del sub arreglo, derecha del sub arreglo y el indice medio
        int tamanoiz = mid - iz + 1; //Resta el índice izquierdo (iz) del índice medio (mid) y le suma 1 esto se hace porque mid - iz da la cantidad de elementos entre iz y mid, pero se agrega 1 para incluir el elemento en la posición mid en el subarreglo izquierdo.
        int tamanode = de - mid;//Resta el índice medio (mid) del índice derecho (de). Esto da la cantidad de elementos entre mid + 1 y de, que es precisamente el subarreglo derecho.
        int[] tempiz = new int[tamanoiz];
        int[] tempde = new int[tamanode];
        //almacena temporalmente los elementos del subarreglo izquierdo y derecho.
        for (int i = 0; i < tamanoiz; i++) {// Se copia los elementos correspondientes del arreglo original a los subarreglos temporales.
            tempiz[i] = arreglo[iz + i]; //se hara de iz a el indice medio
        }
        for (int j = 0; j < tamanode; j++) {
            tempde[j] = arreglo[mid + 1 + j];// se almacena los elem,entos desde el indice medio a la derecha
        }
        int i = 0, j = 0; // se inicializan para recorrer los subarreglos desde 0 en la combinacion de esos.
        int k = iz; // hace referencia la indice del arreglo origial, ya que el proceso de combiancion incia desde izquierda
        while (i < tamanoiz && j < tamanode) {// esta parte es la mas importanteeeee, combina los sub arreglos.
            //se hara mientras sean menores que los tamanos de los subarreglos
            if (tempiz[i] <= tempde[j]) {// verifica si el elemento en la posición i del subarreglo izquierdo tempiz es menor o igual al elemento en la posición j del subarreglo derecho tempde.
                arreglo[k] = tempiz[i]; //si es asi, ese elemento se coloca en la posición k del arreglo original arreglo, luego, los índices i y k se incrementan, lo que indica que el próximo elemento a considerar será el siguiente elemento en el subarreglo izquierdo tempiz.
                i++;
            } else {// si es falso, el elemento se coloca en la posición k del arreglo original arreglo. Luego, los índices j y k se incrementan, lo que indica que el próximo elemento a considerar será el siguiente elemento en el subarreglo derecho tempde.
                arreglo[k] = tempde[j];
                j++;
            }
            k++; //despues de colocar un elemento en el arreglo original, el índice k siempre se incrementa, ya que estamos avanzando en la posición del arreglo donde se colocarán los próximos elementos fusionados
        }
        while (i < tamanoiz) { //se encarga de manejar el caso en el que aun quedan elementos en el subarreglo izquierdo tempiz que no se han incluido en el arreglo original
            arreglo[k] = tempiz[i]; //Se asigna el elemento actual del subarreglo izquierdo tempiz[i] al arreglo original arreglo en la posicion k.
            i++;//Se incrementa tanto el índice del subarreglo izquierdo (i) como el indice del arreglo original (k) para pasar al siguiente elemento en ambos arreglos.
            k++;
        }
        while (j < tamanode) { //ese bloque hace practocamente lo mismo que el anterior solo que en este caso
            arreglo[k] = tempde[j];//se encarga de manejar el caso en el que aun quedan elementos en el subarreglo derecho tempde que no se han incluido en el arreglo original
            j++;
            k++;
        }
    }
}
 