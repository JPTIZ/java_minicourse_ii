import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class WindowEditProduct extends JDialog {
    public static final long serialVersionUID = 3L;

    JLabel lblName;
    JLabel lblCost;
    JTextField edtName;
    JTextField edtCost;
    JButton btnSave;

    public WindowEditProduct(JFrame parent) {
        super(parent);

        setModal(true);

        lblName = new JLabel("Nome:");
        lblName.setSize(64, 24);
        lblName.setLocation(4, 4);

        lblCost = new JLabel("Preço:");
        lblCost.setSize(64, 24);
        lblCost.setLocation(4, 32);

        edtName = new JTextField();
        edtName.setSize(64, 24);
        edtName.setLocation(68, 4);

        edtCost = new JTextField();
        edtCost.setSize(64, 24);
        edtCost.setLocation(68, 32);

        btnSave = new JButton("Salvar");
        btnSave.setSize(128, 24);
        btnSave.setLocation(4, 60);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        setTitle("Cadastro de Produto");
        setLayout(null);
        getContentPane().add(lblName);
        getContentPane().add(lblCost);
        getContentPane().add(edtName);
        getContentPane().add(edtCost);
        getContentPane().add(btnSave);
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void saveProduct() {
        Product product = new Product(
                                edtName.getText(),
                                Double.parseDouble(edtCost.getText())
                            );
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
