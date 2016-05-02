import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Database {

    public Product getProduct(int id) {
        Product product = null;
        try {
            FileInputStream fis = new FileInputStream("product");
            ObjectInputStream ois = new ObjectInputStream(fis);
            product = (Product)ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return product;
    }

    public void saveProduct(Product product) {
        try {
            FileOutputStream fos = new FileOutputStream("product");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao salvar produto");
        }
    }
}

