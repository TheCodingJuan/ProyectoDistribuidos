package negocio;

public class Propaganda
{
    private int id;
    private String tema;
    private String categoria;
    private String ad;

    public Propaganda(int id, String tema, String categoria, String ad)
    {
        this.id = id;
        this.tema = tema;
        this.categoria = categoria;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
