package MenuInicial;

import AlterarPet.AlterarPet;
import ArmazenamentoPET.CadastramentoPet;
import BuscarPet.BuscarPetCadastrados;
import DeletarPet.ExcluirPet;
import ListarPet.ListarPets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MenuInicial {

    BuscarPetCadastrados cadastrados  = new BuscarPetCadastrados();
    AlterarPet alterarPet = new AlterarPet();
    CadastramentoPet cadastro = new CadastramentoPet();
    ExcluirPet excluirPet = new ExcluirPet();
    ListarPets listarPets = new ListarPets();

    public void Iniciar() throws IOException {

        Scanner scanner = new Scanner(System.in);


        System.out.println("""
                1.Cadastrar novo pet
                2.Alterar os dados do pet cadastrado
                3.Deletar um pet cadastrado
                4.Listar todos os pets cadastrados
                5.Listar pets por algum critério(idade,nome,raça)
                6.Sair""");
        String opcao = scanner.nextLine();

        switch (opcao){
            case "1":
                cadastro.cadastrarPet();
                break;
            case "2":
                alterarPet.ALTERAR();
                break;
            case "3":
                excluirPet.DeletarPet();
                break;
            case "4":
                listarPets.Listar();
                break;
            case "5":
                listarPets.ListarPorCriterio();
                break;
            case "6" :
                System.out.println("Fechando o programa");
                System.exit(0);
        }







    }
}
