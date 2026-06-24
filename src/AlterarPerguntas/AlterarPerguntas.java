package AlterarPerguntas;

import CriarPergunta.CriarPergunta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlterarPerguntas {
    Scanner scanner = new Scanner(System.in);
    CriarPergunta criarPergunta = new CriarPergunta();


    public void alterar() throws IOException {
        File file = new File("formulario.txt");
        String conteudo ="";

        try {
            Scanner leitor = new Scanner(file);
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                conteudo += linha + "\n";

                String[] partes = linha.split(" - ");
                int numero = Integer.parseInt(partes[0]) ;
                if( numero >7) {
                    System.out.println(linha);
                }
            }


            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro : "+ e.getMessage());
        }

        System.out.println("Qual pergunta deseja alterar ?");
        String opcao = scanner.nextLine();

        String linhaAntiga = "";
        for(String l : conteudo.split("\n")){
            if(l.startsWith(opcao + " - ")){
                linhaAntiga = l;
            }
        }
        System.out.println("Por qual pergunta deseja trocar?");
        String perguntaNova = scanner.nextLine();

        conteudo = conteudo.replace(linhaAntiga, opcao + " - " +perguntaNova );

        FileWriter fw = new FileWriter(file,false);
        fw.write(conteudo);
        fw.close();
        System.out.println("Pergunta alterada com sucesso!");

    }
}
