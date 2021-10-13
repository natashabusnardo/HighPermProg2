package Array;

public class PesquisaThread implements Runnable {

    private static int[] vetor;
    private static int valor;
    private int inicio;
    private int fim;
    private static boolean pronto = false;
    private static int index = -1;

    @Override
    public void run() {

    }

    public PesquisaThread() {
    }

    public PesquisaThread(int[] vetor, int valor, int inicio, int fim) {
        PesquisaThread.vetor = vetor;
        PesquisaThread.valor = valor;
        this.inicio = inicio;
        this.fim = fim;
    }

    public PesquisaThread(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        PesquisaThread.index = index;
    }

    public void search() {
        int i = this.inicio;

        while (i <= this.fim && !pronto) {
            if (vetor[i] == valor) {
                valor = i;
                pronto = true;
            }
            i++;
        }
    }
}
