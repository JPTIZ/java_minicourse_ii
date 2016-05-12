import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import java.awt.Dimension;

public class WindowListProducts extends JDialog {
    public static final long serialVersionUID = 7362697304614991674L;

    private Database database;
    private JTable table;

    public WindowListProducts(JFrame parent, Database database) {
        super(parent);

        this.database = database;

        setModal(true);

	ArrayList<Product> products = database.getProducts();
        Object[][] data = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i] = new Object[] { product.getName(), product.getCost() };
	}
        
        table = new JTable(
		    data,
		    new String[] { "Nome", "Preço" }
		);

	setMinimumSize(new Dimension(800, 600));

        pack();
        
        getContentPane().add(new JScrollPane(table));
    }

    
    
}
