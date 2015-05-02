
import javax.swing.table.AbstractTableModel;


public class InventoryTableModel extends AbstractTableModel {
    
    
    /**
     * Medlemsvariabler
     */
    private final String[] columnNames = {"Item", "Weight", "Slot", "Attack", "Speed", "Defense"};
    private Object[][] data = new Object[100][7];
    /**
     * Hämtar antal kolumner
     * @return int antal kolumner
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    /**
     * Hämtar antal rader
     * @return int antal rader
     */
    @Override
    public int getRowCount() {
        return data.length;
    }
    /**
     * Hämtar kolumnnamnet
     * @param col kolumnen
     * @return String med namnet på kolumnen
     */
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    /**
     * Hämtar värdet i en cell
     * @param row Cellens rad
     * @param col cellens kolumn
     * @return Object med värdet
     */
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    /**
     * Resettar tabellen så att den inte innehåller några värden
     */
    public void reset(){
        data = new Object[100][5];
        for(int i = 0; i < 100; i++){
            for(int n = 0; n < 5 ; n++){
                fireTableCellUpdated(i, n);
            }
        } 
    }
    /**
     * Kollar om cellen går att ändra
     * @param row cellens rad
     * @param col cellens kolumn
     * @return boolean med värde true om det går och false om den inte kan ändras
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sätter värde i specifierad cell
     * @param value värdet som ska sättas
     * @param row cellens rad
     * @param col cellens kolumn
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        try{
        // System.out.println(value);
        data[row][col] = value;
        fireTableCellUpdated(row, col);
        }catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
}
