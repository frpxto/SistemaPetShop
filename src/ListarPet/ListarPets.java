package ListarPet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListarPets {
    Scanner scanner = new Scanner(System.in);

    public void Listar() throws FileNotFoundException {
        File file = new File("PetsCadastrados");
        File[] arquivos = file.listFiles();

        if (arquivos == null) {
            System.out.println("Não existe pet cadastrado ");
            return;
        }

        for (File arquivo : arquivos) {
            try {
                Scanner leitor = new Scanner(arquivo);


                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();
                    System.out.println(linha);

                }

                leitor.close();
            } catch (Exception e) {
                System.out.println("Erro : "+ e.getMessage());
            }
        }



    }

    public void ListarPorCriterio(){
        File file = new File("PetsCadastrados");
        File[] arquivos = file.listFiles();

        if (arquivos == null) {
            System.out.println("Não existe pet cadastrado ");
            return;
        }

        System.out.println("""
                Qual critério gostaria de Buscar o pet?
                1 - Nome
                2 - Sexo
                3 - Idade
                4 - Peso
                5 - Raça                
              """);
        String opcaoescolhida = scanner.nextLine();
        String criterio = "";

        switch (opcaoescolhida){
            case "1":
                System.out.println("Digite o Nome:");
                criterio =scanner.nextLine();
                break;
            case "2":
                System.out.println("Digite o Sexo");
                criterio =scanner.nextLine();
                break;
            case "3":
                System.out.println("Digite a idade:");
                criterio =scanner.nextLine();
                break;
            case "4":
                System.out.println("Digite o Peso");
                criterio =scanner.nextLine();
                break;
            case "5":
                System.out.println("Digite a Raça:");
                criterio = scanner.nextLine();
                break;
            default:
                break;
        }

        boolean encontrou = false;

        for (File arquivo : arquivos) {
            try {
                Scanner leitor = new Scanner(arquivo);
                String conteudo = "";

                boolean temCriterio = false;

                while (leitor.hasNextLine()) {
                    String linha = leitor.nextLine();
                    conteudo += linha + "\n";

                    if (!criterio.isEmpty() && linha.toUpperCase().contains(criterio)) temCriterio = true;
                }
                leitor.close();

                if ( temCriterio) {
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
