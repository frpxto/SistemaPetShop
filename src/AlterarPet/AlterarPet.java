package AlterarPet;

import ArmazenamentoPET.CadastramentoPet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarPet {
    Scanner scanner = new Scanner(System.in);
    CadastramentoPet cadastramentoPet = new CadastramentoPet();

    public void ALTERAR() throws IOException {

        File pasta = new File("PetsCadastrados");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum pet cadastrado!");
            return;
        }

        System.out.println("Digite o tipo do pet (CACHORRO/GATO):");
        String tipoBuscado = scanner.nextLine().toUpperCase();

        String opcao;
        do {
            System.out.println("Buscar por critério adicional:");
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

        String criterio = "";
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
            System.out.println("Digite o número do pet que deseja alterar:");

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

        System.out.println(conteudo);


        System.out.println(" O que deseja alterar?");
        System.out.println("""
                            1 - Nome
                            2 - Idade
                            3 - Peso
                            4 - Raça""");
        String alterar = scanner.nextLine();

        switch (alterar) {
            case "1":
                System.out.println("Novo nome: ");
                String nomenovo = scanner.nextLine();
                conteudo = conteudo.replace(nomeAntigo, "Nome  " + nomenovo);
                break;
            case "2":
                System.out.println("Nova idade: ");
                String idadenova = scanner.nextLine();
                conteudo = conteudo.replace(idadeAntiga, "Idade : " + idadenova);
                break;
            case "3":
                System.out.println("Novo Peso: ");
                String pesonovo = scanner.nextLine();
                conteudo = conteudo.replace(pesoAntigo, "Peso : " + pesonovo);
                break;
            case "4":
                System.out.println("Nova Raça: ");
                String racanova = scanner.nextLine();
                conteudo = conteudo.replace(racaAntiga, "Raça: " + racanova);
                break;
            default:
                System.out.println("Opção inválida! Digite um número entre 1 e 4");
                return;
        }

        FileWriter fw = new FileWriter(arquivoencontrado, false);
        fw.write(conteudo);
        fw.close();
        System.out.println("Alterado com sucesso");
    }
}