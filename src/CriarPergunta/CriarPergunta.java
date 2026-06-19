package CriarPergunta;

import java.io.*;
import java.util.Scanner;

public class CriarPergunta {
    Scanner scanner = new Scanner(System.in);
    File file = new File("formulario.txt");


    public void NovasPerguntas() throws IOException {
        File file = new File("formulario.txt");
           String ultimalinha ="";
            try {
                Scanner leitor = new Scanner(file);
                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();
                    System.out.println(linha);
                    ultimalinha = linha;
                }

                leitor.close();
            } catch (Exception e) {
                System.out.println("Erro : "+ e.getMessage());
            }

            String[] partes = ultimalinha.split(" - ");

            int proximonumero = Integer.parseInt(partes[0]) + 1;
            System.out.println("DEBUG proximonumero: " + proximonumero);
            System.out.println("Qual pergunta deseja inserir?");
            String novapergunta = scanner.nextLine();

        FileWriter fw =new FileWriter(file,true);
        fw.write("\r\n"+proximonumero + " - " +novapergunta);
        fw.close();
        System.out.println("Pergunta cadastrada com sucesso!");
        }
    }
