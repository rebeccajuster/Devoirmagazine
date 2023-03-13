package Tools;

import Entities.Article;
import Entities.Magazine;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel
{
    private String[] columns;
    private Object[][] rows;

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

   public void  LoadDatasMagazines(ArrayList<Magazine> desMagazines)
   {
       columns = new String[]{"Numero","Nom"};
       rows = new Object[desMagazines.size()][2];
       int i = 0;

       for(Magazine mgz : desMagazines)
       {
           rows[i][0]= mgz.getNumMagazine();
           rows[i][1]= mgz.getNomMagazine();
           i ++;
       }
       fireTableChanged(null);
   }


    public void  LoadDatasArticles(ArrayList<Article> desArticles)
    {
        columns = new String[]{"Nom","Nombre de pages","Nom du pigiste"};
        rows = new Object[desArticles.size()][3];
        int i = 0;

        for(Article art :desArticles)
        {
            rows[i][0]= art.getTitreArticle();
            rows[i][1]= art.getNbPages();
            rows[i][2]= art.getLePigiste().getNomPigiste();
            i ++;
        }
        fireTableChanged(null);
    }

}
