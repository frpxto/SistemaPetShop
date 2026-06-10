package ArmazenamentoPET;

public class Pet {
    private String Nome;
    private String Sobrenome;
    private String TipoPet;
    private String SexoPet;
    private String Endereço;
    private String IdadePet;
    private double PesoPet;
    private String RacaPet;
    private String rua;
    private int numero;
    private String cidade;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pet(String nome, String Sobrenome, String TipoPet, String SexoPet, String Endereço, String Bairro, String IdadePet, double PesoPet, String RacaPet){
        this.Nome = nome;
        this.Sobrenome = Sobrenome;
        this.TipoPet = TipoPet;
        this.SexoPet = SexoPet;
        this.IdadePet =  IdadePet;
        this.PesoPet = PesoPet;
        this.RacaPet = RacaPet;


    }

    public Pet() {

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getTipoPet() {
        return TipoPet;
    }

    public void setTipoPet(String tipoPet) {
        this.TipoPet = tipoPet;
    }

    public String getSexoPet() {
        return SexoPet;
    }

    public void setSexoPet(String sexoPet) {
        SexoPet = sexoPet;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String endereço) {
        Endereço = endereço;
    }

    public String getIdadePet() {
        return IdadePet;
    }

    public void setIdadePet(String idadePet) {
        this.IdadePet = idadePet;
    }

    public double getPesoPet() {
        return PesoPet;
    }

    public void setPesoPet(double pesoPet) {
        this.PesoPet = pesoPet;
    }
    public String getRacaPet() {
        return RacaPet;
    }

    public void setRacaPet(String racaPet) {
        RacaPet = racaPet;
    }
    @Override
    public String toString() {
        return  "\n--- Pet Cadastrado ---" +
                "\nNome:" + Nome + " " +Sobrenome +
                "\nEspécie: " +TipoPet +
                "\nIdade: " + IdadePet +  " anos " +
                 "\nRaça: " + RacaPet +
                "\nEndereço: " +Endereço + ", " +
                "\nPeso do Pet: " + PesoPet ;


    }


}


