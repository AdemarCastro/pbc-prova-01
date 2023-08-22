package app.model;

public class Municipio {

    public Municipio(String nome, String codigo, String gentilico,
                     String prefeito, String area, String populacao,
                     String densidade, String escolarizacao, String idhm,
                     String mortalidade, String receitas, String despesas,
                     String pib) {
        this.nome = nome;
        this.codigo = codigo;
        this.gentilico = gentilico;
        this.prefeito = prefeito;
        this.area = area;
        this.populacao = populacao;
        this.densidade = densidade;
        this.escolarizacao = escolarizacao;
        this.idhm = idhm;
        this.mortalidade = mortalidade;
        this.receitas = receitas;
        this.despesas = despesas;
        this.pib = pib;
    }

    private final String nome;
    private final String codigo;
    private final String gentilico;
    private final String prefeito;
    private final String area;
    private final String populacao;
    private final String densidade;
    private final String escolarizacao;
    private final String idhm;
    private final String mortalidade;
    private final String receitas;
    private final String despesas;
    private final String pib;


    public static Municipio parse(String linha, String separador) {
        String[] partes = linha.split(separador);
        if (partes.length != 13) {
            throw new IllegalArgumentException("Linha de municipio mal-formada: " + linha);
        }
        try {
            return new Municipio(
                    partes[0].trim(),
                    partes[1].trim(),
                    partes[2].trim(),
                    partes[3].trim(),
                    partes[4].trim(),
                    partes[5].trim(),
                    partes[6].trim(),
                    partes[7].trim(),
                    partes[8].trim(),
                    partes[9].trim(),
                    partes[10].trim(),
                    partes[11].trim(),
                    partes[12].trim()
            );
        }catch (NumberFormatException x) {
            throw new IllegalArgumentException("Linha de Municipio mal-formada: " + linha);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getGentilico() {
        return gentilico;
    }

    public String getPrefeito() {
        return prefeito;
    }

    public String getArea() {
        return area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public String getDensidade() {
        return densidade;
    }

    public String getEscolarizacao() {
        return escolarizacao;
    }

    public String getIdhm() {
        return idhm;
    }

    public String getMortalidade() {
        return mortalidade;
    }

    public String getReceitas() {
        return receitas;
    }

    public String getDespesas() {
        return despesas;
    }

    public String getPib() {
        return pib;
    }
}
