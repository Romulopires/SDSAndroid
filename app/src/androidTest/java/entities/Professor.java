package entities;

public class Professor {

    private Integer id;
    private String nome;
    private String disciplina_le;
    private Integer carga_hora;
    private Integer restante;
    private Integer tipo;
    private String foto;
    private Integer id_disciplina;

    public Professor() {
        // TODO Auto-generated constructor stub
    }

    public Professor(Integer id, String nome, String disciplina_le, Integer carga_hora, Integer restante, Integer tipo,
                     String foto, Integer id_disciplina) {
        super();
        this.id = id;
        this.nome = nome;
        this.disciplina_le = disciplina_le;
        this.carga_hora = carga_hora;
        this.restante = restante;
        this.tipo = tipo;
        this.foto = foto;
        this.id_disciplina = id_disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina_le() {
        return disciplina_le;
    }

    public void setDisciplina_le(String disciplina_le) {
        this.disciplina_le = disciplina_le;
    }

    public Integer getCarga_hora() {
        return carga_hora;
    }

    public void setCarga_hora(Integer carga_hora) {
        this.carga_hora = carga_hora;
    }

    public Integer getRestante() {
        return restante;
    }

    public void setRestante(Integer restante) {
        this.restante = restante;
    }

    public Integer getTipo() {
        return tipo;
    }

    public String getFormatTipo() {
        if(tipo == 1) {
            return "Professor";
        }else {
            return "Instrutor";
        }
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
    }


}
