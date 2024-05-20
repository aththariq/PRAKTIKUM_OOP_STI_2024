import java.util.*;

public class PenjurusanTPB {

    public static class Mahasiswa {
        private Integer NIM;
        private String Nama;
        private Double IP;
        private Double UKT;
        
        public Mahasiswa(Integer NIM, String nama, Double IP, Double UKT) { 
            this.NIM = NIM;
            this.Nama = nama;
            this.IP = IP;
            this.UKT = UKT;
        }

        public Integer getNIM() { 
            return this.NIM;
        }
        
        public String getNama() {
            return this.Nama;
        }

        public Double getIP() {
            return this.IP;
        }

        public Double getUKT() {
            return this.UKT;
        }
    }

    private static class MahasiswaComparator implements Comparator<Mahasiswa> {
        /**
         * Membandingkan Mahasiswa dengan urutan sebagai berikut:
         *  1. UKT yang lebih besar akan diprioritaskan.
         *  2. IP yang lebih besar akan diprioritaskan.
         *  3. NIM yang lebih kecil akan diprioritaskan. (NIM dipastikan unik)
         */
        public int compare(Mahasiswa mahasiswa1, Mahasiswa mahasiswa2) {
            if (mahasiswa1.getUKT() > mahasiswa2.getUKT()) {
                return -1;
            } else if (mahasiswa1.getUKT() < mahasiswa2.getUKT()) {
                return 1;
            } else {
                if (mahasiswa1.getIP() > mahasiswa2.getIP()) {
                    return -1;
                } else if (mahasiswa1.getIP() < mahasiswa2.getIP()) {
                    return 1;
                } else {
                    if (mahasiswa1.getNIM() < mahasiswa2.getNIM()) {
                        return -1;
                    } else if (mahasiswa1.getNIM() > mahasiswa2.getNIM()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    /**
     * Menerima List<Mahasiswa> yang tidak terurut
     * Mengembalikan PriorityQueue<Mahasiswa> yang sudah terurut berdasarkan prioritas.
     */
    public static PriorityQueue<Mahasiswa> PembangkitanAntrianPrioritas(List<Mahasiswa> list) {
        PriorityQueue<Mahasiswa> pq = new PriorityQueue<>(new MahasiswaComparator());
        for (Mahasiswa mahasiswa : list) {
            pq.add(mahasiswa);
        }
        return pq;
    }
}
