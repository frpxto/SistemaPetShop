package ArmazenamentoPET;

public class EnumTipoTest {
    TipoPet tipoPet;

    EnumTipoTest(String tipoPet) {

        try {
            this.tipoPet = TipoPet.valueOf(tipoPet.trim().toUpperCase());
            switch (this.tipoPet) {
                case GATO:
                    System.out.println("Adicionado com exito");
                    break;

                case CACHORRO:
                    System.out.println("Adicionado com exito");
                    break;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Digite apenas GATO OU CACHORRO");

        }


    }
}