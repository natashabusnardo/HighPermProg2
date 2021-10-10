package Fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorSocket {

    public static void main (String[] args) throws IOException{
        ServerSocket servidor = null;

        Socket conexao = null;

        BufferedReader entrada = null;

        Random rand = new Random();

        try {
            servidor = new ServerSocket(7000);
            conexao = servidor.accept();
            entrada = new BufferedReader (new InputStreamReader (conexao.getInputStream()));

            do {
                String texto = entrada.readLine();
                if(texto == null) {
                    break;
                }

                String[] msg = texto.split(" ");


                if(msg[0].equals("fib")) {
                    new Thread(new Fibonacci(rand.nextInt(20))).start();
                }


                else if(msg[0].equals("getFib")) {
                    new Thread(new Consumer(new Fibonacci(0))).start();
                }

            }while (!"sair".equals(entrada.toString()));

        }catch (IOException e) {
            System.out.println("Algo de errado aconteceu");
        }finally {
            conexao.close();
            servidor.close();
        }
    }
}