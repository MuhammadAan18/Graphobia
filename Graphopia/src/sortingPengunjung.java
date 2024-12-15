import java.util.ArrayList;

public class sortingPengunjung {
    public void jenisTiket(ArrayList<Passenger> passenger){
        for(int i=0; i< passenger.size() - 1; i++){
            for(int j=0; j< passenger.size()-i-1; j++){
                Passenger current = passenger.get(j);
                Passenger next = passenger.get(j+1);

                if (!current.isVIP && next.isVIP) {
                    passenger.set(j, next);
                    passenger.set(j+1, current);
                }

            }
        }
    }

    public void displayAntrian(ArrayList<Passenger> passengers){
        int no = 1;
        System.out.println("=================GRAPHOPIA=================\n===============List Penumpang===============");
        for(Passenger p : passengers){
            System.out.println(no +". " + p);
            no++;
        }
    }
}