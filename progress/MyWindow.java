import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyWindow extends JFrame {
    public static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu menuRegister;
    private JMenu menuList;
    private JMenuItem itemRegisterProduct;
    private JMenuItem itemListProducts;
    private Database database;

    public MyWindow(Database database) {
        super();

        this.database = database;

        menuBar = new JMenuBar();
        menuRegister = new JMenu("Cadastrar");
        menuList = new JMenu("Listar");
        itemRegisterProduct = new JMenuItem("Produto");
        itemRegisterProduct.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            onSelectRegisterProduct();
                        }
                    }
                );

        menuRegister.add(itemRegisterProduct);

        itemListProducts = new JMenuItem("Produtos");
        itemListProducts.addActionListener(
		    new ActionListener() {
		        @Override
                        public void actionPerformed(ActionEvent e) {
			    onSelectListProducts();
			}
		    }
		);
        menuList.add(itemListProducts);

        menuBar.add(menuRegister);
        menuBar.add(menuList);

        setJMenuBar(menuBar);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void onSelectRegisterProduct() {
        WindowEditProduct editProductWindow = new WindowEditProduct(this, database);
        editProductWindow.setVisible(true);
    }

    private void onSelectListProducts() {
	WindowListProducts listWindow = new WindowListProducts(this, database);
        listWindow.setVisible(true);
    }
}
