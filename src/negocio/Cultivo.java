package negocio;

public class Cultivo
{
    //atributos que representan las diferentes caracteristicas de los cultivos de un subscriptor,
    //bajo los cuales se realizan los filtros de la informacion que le llegara.
    private String clima;
    private String ubicacion;
    private String tipoDeProducto;
    private String precioDeProducto;

    //constructor por defecto.
    public Cultivo() {}

    //constructor completo, para instanciar con datos concretos al declarar.
    public Cultivo(String clima, String ubicacion, String tipoDeProducto, String precio) {
        this.clima = clima;
        this.ubicacion = ubicacion;
        this.tipoDeProducto = tipoDeProducto;
        this.precioDeProducto = precio;
    }

    //conjunto de getters y setters para los atributos de la clase.
    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }

    public String getPrecioDeProducto() {
        return precioDeProducto;
    }

    public void setPrecioDeProducto(String precioDeProducto) {
        this.precioDeProducto = precioDeProducto;
    }
}
