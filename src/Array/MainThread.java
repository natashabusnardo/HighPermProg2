package Array;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        final int TAM = 100;

        Random random = new Random();

        int[] vetor = new int[TAM];
        int value = random.nextInt(TAM);

        for (int i = 0; i < TAM; i++) {
            vetor[i] = random.nextInt(TAM);
        }

        System.out.println("Encontrando o  " + value);
        System.out.print("no ");
        for (int i = 0; i < TAM; i++)
            System.out.print(vetor[i] + " ");
        System.out.println();

        new Thread(new PesquisaThread(vetor, value, 0, TAM - 1)).start();

        TimeUnit.SECONDS.sleep(2);

        new PesquisaThread();
        System.out.println(PesquisaThread.getIndex());
    }
}
