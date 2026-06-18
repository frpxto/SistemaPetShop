package BuscarPet;

import java.io.File;
import java.util.Scanner;

public class BuscarPetCadastrados {
    Scanner scanner = new Scanner(System.in);
    public void buscarPet() {
        File pasta = new File("PetsCadastrados");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum pet cadastrado!");
            return;
        }


        System.out.println("Digite o tipo do pet (CACHORRO/GATO):");
        String tipoBuscado = scanner.nextLine().toUpperCase();


        System.out.println("Buscar por critério adicional:");
        System.out.println("1 - Nome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
        System.out.println("4 - Peso");
        System.out.println("5 - Raça");
        System.out.println("6 - Sem critério");
        String opcao = scanner.nextLine();

        String criterio = "";
        switch (opcao) {
            case "1": System.out.println("Digite o nome:"); criterio = scanner.nextLine().toUpperCase(); break;
            case "2": System.out.println("Digite o sexo:"); criterio = scanner.nextLine().toUpperCase(); break;
            case "3": System.out.println("Digite a idade:"); criterio = scanner.nextLine().toUpperCase(); break;
            case "4": System.out.println("Digite o peso:"); criterio = scanner.nextLine().toUpperCase(); break;
            case "5": System.out.println("Digite a raça:"); criterio = scanner.nextLine().toUpperCase(); break;
            default: break;
        }


        boolean encontrou = false;

        for (File arquivo : arquivos) {
            try {
                Scanner leitor = new Scanner(arquivo);
                String conteudo = "";
                boolean temTipo = false;
                boolean temCriterio = false;

                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();
                    conteudo += linha + "\n";

                    if (linha.toUpperCase().contains(tipoBuscado)) temTipo = true;
                    if (!criterio.isEmpty() && linha.toUpperCase().contains(criterio)) temCriterio = true;
                }
                leitor.close();

                if (temTipo && (criterio.isEmpty() || temCriterio)) {
                    System.out.println(conteudo);
                    encontrou = true;
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum pet encontrado!");
        }
    }
}
