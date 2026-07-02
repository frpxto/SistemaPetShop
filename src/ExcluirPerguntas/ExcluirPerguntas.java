package ExcluirPerguntas;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExcluirPerguntas {
    Scanner scanner = new Scanner(System.in);
    public void Deletar() throws IOException {
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

            System.out.println("Qual pergunta deseja excluir ?");
                String opcao = scanner.nextLine();

            String linhaAntiga = "";
            for(String l : conteudo.split("\n")){
            if(l.startsWith(opcao + " - ")){
                linhaAntiga = l;
            }
        }
        System.out.println("Você deseja excluir a pergunta ? " +linhaAntiga);
        System.out.println("""
                1-Sim
                2-Não""");
        String opcaoescolhida =scanner.nextLine();


        if(opcaoescolhida.equals("1")){
            conteudo = conteudo.replace(linhaAntiga + "\n", "");
        }else{
            System.out.println("Exclusão cancelada!");
            return;
        }

        int opcao1 = Integer.parseInt(opcao);


        for (String l : conteudo.split("\n")) {
            if (!l.isEmpty()) {
                String[] partes = l.split(" - ");
                int num = Integer.parseInt(partes[0]);
                if (num > opcao1) {
                    conteudo = conteudo.replace(l, (num - 1) + " - " + partes[1]);
                }
            }
        }

        FileWriter Fw = new FileWriter("formulario.txt");
        Fw.write(conteudo);
        Fw.close();

        System.out.println("Sua pergunta foi excluída com sucesso!");
    }

    }

