package CadastroPet;

import MenuInicial.LeituraArquivo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static CadastroPet.TipoPet.CACHORRO;
import static CadastroPet.TipoPet.GATO;
import static java.lang.System.*;

public class CadastramentoPet {
    private static final String NAOINFORMADO = "Não Informado";
    private static final double NAOINFORMADOnumb = 1;
    private List<Pet> pets = new ArrayList<>();
    private Scanner scanner = new Scanner(in);



    public void cadastrarPet(){
        try {
            String formulario = LeituraArquivo.lerArquivo("formulario.txt");
            String [] perguntas = formulario.split("\n");
            Pet pet = new Pet();


            System.out.println(perguntas[0]);
            String nome = scanner.nextLine();
            if(nome.isEmpty()){
                pet.setNome(NAOINFORMADO);
            }else{
                pet.setNome(nome);
            }
            String sobrenome = scanner.nextLine();


            if(sobrenome.isEmpty()){
                pet.setSobrenome(NAOINFORMADO);
            }else{
                pet.setSobrenome(sobrenome);
            }

            if(!nome.matches("[a-z A-Z À-ú]+") || !sobrenome.matches("[a-z A-Z À-ú]+")){
                out.println("Nome não pode ter números ou caracteres especiais!");
                return;
            }


            System.out.println(perguntas[1]);
            String opcaotipo = scanner.nextLine();
            if(opcaotipo.equals("CACHORRO")){
                pet.setTipoPet("CACHORRO");

            }else if (opcaotipo.equals("GATO")){
                pet.setTipoPet("GATO");

            }else{
                out.println("Erro digite GATO ou CACHORRO");
                return;
            }


            System.out.println(perguntas[2]);
            String opcaosexo = scanner.nextLine();
            if(opcaosexo.equals("MACHO")){
                pet.setRacaPet("MACHO");

            }else if (opcaosexo.equals("FEMEA")){
                pet.setRacaPet("FEMEA");

            }


            //PERGUNTA[3]
            out.println("Informe seu endereço:");
            out.println("Rua: ");
            String rua= scanner.nextLine();
            out.println("Número da casa: ");
            String numerocasa = scanner.nextLine();

            if(numerocasa.isEmpty()){
                pet.setRua(NAOINFORMADO);
            }else{
                pet.setRua(numerocasa);
            }

            out.println("Cidade : ");
            String cidade = scanner.nextLine();
            Endereco endereco = new Endereco(numerocasa,cidade,rua);
            out.println(endereco);


            System.out.println(perguntas[4]);
            try {
                String idadenull = scanner.nextLine();
                idadenull = idadenull.replace(',','.');

                if (idadenull.isEmpty()) {
                    pet.setIdadePet(NAOINFORMADO);
                } else {

                    double idade = Double.parseDouble(idadenull);
                    if (idade < 0) {
                        System.out.println("Idade deve ser maior que zero!");
                        return;
                    }
                    if (idade >= 20) {
                        out.println("Idade inválida! Digite apenas idade menor que 20 anos");
                        return;
                    }
                    if (idade < 1) {
                        double IdadeEmMeses = idade * 12;
                        System.out.println("Idade em meses :" + IdadeEmMeses);

                    }
                    pet.setIdadePet(idadenull);
                }

                }catch(NumberFormatException e){
                    System.out.println("Idade inválida! Digite apenas números entre 1 e 20 anos");
                    return;
                }


            System.out.println(perguntas[5]);
            try {
                String pesonull = scanner.nextLine();
                pesonull = pesonull.replace(',','.');

                if(pesonull.trim().isEmpty()){

                    pet.setPesoPet(NAOINFORMADOnumb);
                }else {
                    Double peso = Double.parseDouble(pesonull);


                    if (peso < 0.5 || peso >= 60) {
                        System.out.println("Peso tem que ser menor que 60kg e maior que 0.5kg");
                        return;
                    }
                    pet.setPesoPet(peso);
                }

            }catch (NumberFormatException e){
                System.out.println("Peso Inválida,digite novamente");
                return;
            }


            out.println(perguntas[6]);
            String raca = scanner.nextLine();
            if(raca.isEmpty()){
                pet.setRacaPet(NAOINFORMADO);
            }else {
                if (!raca.matches("[a-zA-ZÀ-ú]+")) {
                    System.out.println("Nome não pode ter números ou caracteres especiais!");
                    return;
                }
                pet.setRacaPet(raca);
            }


            pets.add(pet);
            out.println("Seu pet foi cadastrado com sucesso!");




        } catch(Exception e){
            out.println("Erro: " + e.getMessage());

        }


    }

    }


