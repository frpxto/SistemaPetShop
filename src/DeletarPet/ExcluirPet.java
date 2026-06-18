package DeletarPet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirPet {
    Scanner scanner = new Scanner(System.in);


    public void DeletarPet() throws FileNotFoundException {


        File pasta = new File("PetsCadastrados");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum pet cadastrado!");
            return;
        }

        System.out.println("Digite o tipo do pet (CACHORRO/GATO):");
        String tipoBuscado = scanner.nextLine().toUpperCase();
        String criterio = "";

        String opcao = scanner.nextLine().toUpperCase();

        do {
            System.out.println("Buscar por critérios adicional:");
            System.out.println("1 - Nome");
            System.out.println("2 - Sexo");
            System.out.println("3 - Idade");
            System.out.println("4 - Peso");
            System.out.println("5 - Raça");
            System.out.println("6 - Sem critério");
            opcao = scanner.nextLine();

            if (!opcao.matches("[1-6]")) {
                System.out.println("Opção inválida,digite um número entre 1 e 6");
            }

        } while (!opcao.matches("[1-6]"));

        switch (opcao) {
            case "1":
                System.out.println("Buscar por Nome: ");
                criterio = scanner.nextLine();
                break;
            case "2":
                System.out.println("Buscar com Sexo: ");
                criterio = scanner.nextLine();
                break;
            case "3":
                System.out.println("Buscar por idade: ");
                criterio = scanner.nextLine();
                break;
            case "4":
                System.out.println("Buscar por peso: ");
                criterio = scanner.nextLine();
                break;
            case "5":
                System.out.println("Buscar por Raça: ");
                criterio = scanner.nextLine();
                break;
            case "6":
                break;
        }


        List<File> encontrados = new ArrayList<>();

        for (File arquivo : arquivos) {
            boolean temTipo = false;
            boolean temCriterio = false;

            try {
                Scanner leitor = new Scanner(arquivo);
                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();
                    if (linha.toUpperCase().contains(tipoBuscado)) temTipo = true;
                    if (!criterio.isEmpty() && linha.toUpperCase().contains(criterio)) temCriterio = true;
                }
                leitor.close();

                if (temTipo && (criterio.isEmpty() || temCriterio)) {
                    encontrados.add(arquivo);
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum pet encontrado!");
            return;
        }


        File arquivoencontrado;

        if (encontrados.size() == 1) {
            arquivoencontrado = encontrados.get(0);
            System.out.println("Pet encontrado: " + arquivoencontrado.getName());
        } else {
            System.out.println("Pets encontrados:");
            for (int i = 0; i < encontrados.size(); i++) {
                System.out.println((i + 1) + " - " + encontrados.get(i).getName());
            }
            System.out.println("Digite o número do pet que deseja excluir:");

            int escolha = -1;
            while (escolha < 1 || escolha > encontrados.size()) {
                try {
                    escolha = Integer.parseInt(scanner.nextLine());
                    if (escolha < 1 || escolha > encontrados.size()) {
                        System.out.println("Opção inválida, tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números.");
                }
            }
            arquivoencontrado = encontrados.get(escolha - 1);
        }


        String conteudo = "";
        String nomeAntigo = "";
        String idadeAntiga = "";
        String pesoAntigo = "";
        String racaAntiga = "";

        Scanner leitor = new Scanner(arquivoencontrado);
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            conteudo += linha + "\n";

            if (linha.startsWith("Nome")) nomeAntigo = linha;
            if (linha.startsWith("Idade")) idadeAntiga = linha;
            if (linha.startsWith("Peso")) pesoAntigo = linha;
            if (linha.startsWith("Raça")) racaAntiga = linha;
        }
        leitor.close();

        System.out.println("Deseja excluir seu pet? :");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        String opcaoescolhida = scanner.nextLine();
        if(opcaoescolhida.equals("1")){
            if(arquivoencontrado.delete()){
                System.out.println("Seu pet está excluído");
            }else {
                System.out.println("Seu pet não foi excluído");
            }
        }
    }
}