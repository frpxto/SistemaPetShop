package MenuInicial;

import java.util.Scanner;

public class MenuInicial {
    public static void exibir() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                1.Cadastrar novo pet
                2.Alterar os dados do pet cadastrado
                3.Deletar um pet cadastrado
                4.Listar todos os pets cadastrados
                5.Listar pets por algum critério(idade,nome,raça)
                6.Sair""");
        int opcao = scanner.nextInt();

        switch (opcao){
            case 1: //cadastrar
                break;
            case 6 :
                System.out.println("Fechando o programa");
        }





    }
}
