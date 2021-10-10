package Array;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int TAM = 5000000;
        final int threadNum = 4;
        int sizeForEach = TAM / threadNum;

        Random random = new Random();

        int[] vetor = new int[TAM];
        int valor = random.nextInt(TAM);

        for (int i = 0; i < TAM; i++) {
            vetor[i] = random.nextInt(TAM);
        }

        System.out.println("Encontrado " + valor);


        long start = System.nanoTime();

        for (int i = 1; i <= threadNum; i++) {
            if (i == 1)
                new Thread(new PesquisaThread(vetor, valor, 0, i * sizeForEach - 1)).start();
            else
                new Thread(new PesquisaThread((i - 1) * sizeForEach, i * sizeForEach - 1)).start();
        }

        long multiTElapsedTime = System.nanoTime() - start;

        int singleTValueIndex = -1;
        boolean pronto = false;
        int i = 0;
        start = System.nanoTime();
        while (!pronto && i < TAM) {
            if (vetor[i] == valor) {
                singleTValueIndex = i;
                pronto = true;
            }
            i++;
        }

        long singleTElapsedTime = System.nanoTime() - start;

        TimeUnit.MILLISECONDS.sleep(100);

        System.out.println("\nMultithread:");
        new PesquisaThread();
        System.out.println("Indice: " + PesquisaThread.getIndex());
        System.out.println("Tempo de processamento: " + (float) multiTElapsedTime / 1000000 + " ms");

        System.out.println("\nSinglethread: ");
        System.out.println("Indice: " + singleTValueIndex);
        System.out.println("Tempo de processamento: " + (float) singleTElapsedTime / 1000000 + " ms");

        new Grafico(TAM, multiTElapsedTime, singleTElapsedTime);

    }
}
