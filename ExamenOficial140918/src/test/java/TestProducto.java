
import com.mycompany.controllerimpl.Producto_stockCtrlImpl;
import com.mycompany.dao.Producto_stockDAO;
import com.mycompany.modell.Producto_stock;
import java.util.ArrayList;

public class TestProducto {

    static ArrayList<Producto_stock> list = new ArrayList<>();

    public static void main(String[] args) {
        Producto_stockDAO proddao;
        proddao = new Producto_stockCtrlImpl();
        Producto_stock prod = new Producto_stock();
        prod.setId_producto("1");
        prod.setId_categoria("5");
        prod.setDescripcion("yogurt de fresa pequeño de 250 ml");
        prod.setName_producto("Yogurt");
        if (proddao.updateProducto(prod)) {
            System.out.println("Insertado correctamente");
        } else {
            System.out.println("Error al ingresar el dato");
        }
    }

}
