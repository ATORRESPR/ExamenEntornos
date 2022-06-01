/*
 * Examen Entornos de desarrollo - Enunciado
 */

package Cheese;
/**
 * Imports del paquete
 */

import java.util.ArrayList;
import java.util.HashMap;


public class ListaProductos {

    /**
     * Estructura HashMap para almacenar los productos de la lista de productos
     * @see "HashMap java doc"
     */
    private HashMap<String, Producto> listaP = new HashMap();
    
    /**
     * Cuenta calculada con el número de productos contenidos en la lista
     */
    private static int n = 0;


    
    private int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }
    /**
     * Comprueba si la cadena pasada es valida ( no está vacía)
     * @param campo cadena a analizar
     * @return True: Cadena vacía, False: Cadena correcta
     */
    private boolean check_null(String campo){
    
        if (campo.replace(" ","") == "")  return true; else return false;
    }
    /**
     * Añade un objeto a la lista
     * @param prod producto a añadir
     * @return Nos devuelve el objeto producto si sale bien o nulo si sale mal
     */
    public Producto addProducto(Producto prod) {
        if (prod.replace(" ","") == ""){
        if (listaP.containsKey(prod.getcode())) {
            // System.out.println("Producto con código duplicado");
            return null;
        }
        n++;
        this.setN(n);
        listaP.put(prod.getcode(), prod);
        return prod;
        }
        return null;
    }
/**
 * Elimina un objeto de la lista
 * @param codigo producto a borrar
 * @return Si entra dentro del if no nos devuelve nada ya que lo abra borrado
 */
    public Producto eliminarProducto(String codigo) { 
        if (codigo.replace(" ","") == ""){
        Producto prod = buscarProducto(codigo);
        if (prod != null) {
        listaP.remove(codigo);
        n--;
        this.setN(n);
        }
        return prod;
        }
        return null;
    }
/**
 * Nos ayuda a buscar un producto dentro del codigo
 * @param codigo producto a buscar
 * @return Nos devuelve el producto buscado
 */
    public Producto buscarProducto(String codigo) { 
        Producto prod = null;
         if (codigo.replace(" ","") == ""){
        if (!listaP.containsKey(codigo)) {
            return prod;
        }
        else{
            return listaP.get(codigo);
        }
         }  
        return null;
    }
/**
 * Saca los producto
 * @return la lista de productos
 */
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> prodsList = new ArrayList<>();
        prodsList.addAll(listaP.values());
        return prodsList;
    }
    /**
     * Nos ayuda a saber cuantos productos tenemos  
     * @return Nos devuelve un numero contando la cantidad de productos que tenemos
     */
    public int totalProductos(){
            return this.getN();
    }
}
