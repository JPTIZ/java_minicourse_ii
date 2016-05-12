import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class Database {
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("products");
            ois = new ObjectInputStream(fis);
            while (true) {
                products.add((Product)ois.readObject());
            }
        } catch (EOFException e) {
            try {
                ois.close();
                fis.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não existente, criando novo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public void saveProduct(Product product) {
        ArrayList<Product> products = getProducts();
        products.add(product);
        try {
            FileOutputStream fos = new FileOutputStream("products");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Product product_: products) {
                oos.writeObject(product_);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao salvar produto");
        }
    }
}
