package MenuFormulario;

import AlterarPerguntas.AlterarPerguntas;
import AlterarPet.AlterarPet;
import CriarPergunta.CriarPergunta;
import DeletarPet.ExcluirPet;
import ExcluirPerguntas.ExcluirPerguntas;
import MenuInicial.MenuInicial;

import java.io.IOException;
import java.util.Scanner;

public class FormularioMenu {
    Scanner scanner = new Scanner(System.in);
    MenuInicial menuInicial = new MenuInicial();
    CriarPergunta criarPergunta = new CriarPergunta();
    AlterarPerguntas alterarPerguntas = new AlterarPerguntas();
    ExcluirPerguntas excluirPerguntas = new ExcluirPerguntas();


    public void formulariomenu() throws IOException {
        System.out.println("""
                1- Iniciar o sistema para cadastro de PETS
                2- Iniciar o sistema para alterar formulário""");
        String opcaoescolhida = scanner.nextLine();

        switch (opcaoescolhida){
            case "1":
                menuInicial.Iniciar();
                break;
            case "2":
            System.out.println("""
                    1. Criar nova pergunta
                    2. Alterar pergunta existente
                    3. Excluir pergunta existente
                    4. Voltar para o menu inicial
                    5.Sair""");
            String opcaoMenu = scanner.nextLine();
                switch (opcaoMenu){
                    case "1":
                        criarPergunta.NovasPerguntas();
                        break;
                    case "2":
                        alterarPerguntas.alterar();
                        break;
                    case "3":
                        excluirPerguntas.Deletar();
                        break;
                    case "4":
                        menuInicial.Iniciar();
                        break;
                    case "5":
                        System.out.println("Fechando o programa");
                        System.exit(0);
                }
            break;
        }

    }
}
