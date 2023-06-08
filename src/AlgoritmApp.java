import java.util.List;
import java.util.Scanner;

public class AlgoritmApp extends DijkstraAlgorithm{
    public AlgoritmApp(int jumlahTotal) {

        super(jumlahTotal);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jumlahTotal = 6;
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(jumlahTotal);

        algorithm.nilaiBobot(0, 1, 4);
        algorithm.nilaiBobot(0, 2, 3);
        algorithm.nilaiBobot(1, 2, 1);
        algorithm.nilaiBobot(1, 3, 2);
        algorithm.nilaiBobot(2, 3, 4);
        algorithm.nilaiBobot(3, 4, 2);
        algorithm.nilaiBobot(4, 5, 6);

        System.out.print("Masukkan Nilai Awal : ");
        int nilaiLokasi1 = scanner.nextInt();
        System.out.print("Masukkan Nilai Tujuan : ");
        int nilaiLokasi2 = scanner.nextInt();
/*        int nilaiLokasi1 = 0;
        int nilaiLokasi2 = 5;*/
        List<Integer> shortestPath = algorithm.shortestPath(nilaiLokasi1, nilaiLokasi2);
        System.out.print("Nilai terpendek dari "+ nilaiLokasi1+ " ke " + nilaiLokasi2 + " = "+ shortestPath);

    scanner.close();
    }
}
