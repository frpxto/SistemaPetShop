package CadastroPet;

public class Endereco {
    private String numerocasa;
    private String cidade;
    private String rua;

    CadastramentoPet cadastramentoPet = new CadastramentoPet();


    public String getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    @Override
    public String toString() {
        return "Endereco{ " +
                "numerocasa = " + numerocasa +
                ", cidade = ' " + cidade + '\'' +
                ", rua = ' " + rua + '\'' ;

    }

    public Endereco(String numerocasa, String cidade, String rua) {
        this.numerocasa = (numerocasa == null || numerocasa.isEmpty()) ? "Não informado" : numerocasa;
        this.cidade = cidade;
        this.rua = rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
