import java.lang.reflect.Array;
import java.util.*;

public class DijkstraAlgorithm {
    private static final int NIHIL = Integer.MAX_VALUE;
    private int jumlahTotal;
    private int[][] antarTitik;

    public DijkstraAlgorithm(int jumlahTotal){
        this.jumlahTotal = jumlahTotal;
        antarTitik = new int[jumlahTotal][jumlahTotal];
    }

    public void nilaiBobot(int asal, int destinasi,int bobot){
        antarTitik[asal][destinasi]= bobot;
        antarTitik[destinasi][asal]= bobot;
    }
    public List<Integer> shortestPath(int nilaiLokasi1, int nilaiLokasi2){
        boolean[] kunjungan = new boolean[jumlahTotal];
        int[] destinasi = new int[jumlahTotal];
        int[] lintasan = new int[jumlahTotal];

        Arrays.fill(destinasi, NIHIL);
        destinasi[nilaiLokasi1] = 0;


        for (int i=0; i < jumlahTotal -1; i++){
            int nilaiTengah = cariNilaiTengah (destinasi, kunjungan);
            kunjungan[nilaiTengah] = true;

            for (int j = 0; j < jumlahTotal; j++){
                if (antarTitik[nilaiTengah][j] > 0 && !kunjungan[j] &&
                destinasi[nilaiTengah] !=NIHIL &&
                destinasi[nilaiTengah] + antarTitik[nilaiTengah][j] < destinasi[j]){
                    destinasi[j] = destinasi[nilaiTengah]= antarTitik[nilaiTengah][j];
                    lintasan[j] = nilaiTengah;
                }
            }
        }
        return getPath(lintasan, nilaiLokasi1, nilaiLokasi2);
    }
    private int cariNilaiTengah(int[] destinasi, boolean[] kunjungan){
        int nilaiTengah = -1;
        for (int i = 0; i < jumlahTotal; i++){
            if(!kunjungan[i] && (nilaiTengah == -1 || destinasi[i] < destinasi[nilaiTengah])){
                nilaiTengah = i;
            }
        }
        return nilaiTengah;
    }

    private List<Integer> getPath(int[] lintasan, int nilaiLokasi1,int nilaiLokasi2){
        List<Integer>path = new ArrayList<>();
        int currentVertex = nilaiLokasi2;

        while (currentVertex != nilaiLokasi1){
            path.add(0, currentVertex);
            currentVertex = lintasan[currentVertex];
        }
        path.add(0, nilaiLokasi1);
        return path;
    }
}