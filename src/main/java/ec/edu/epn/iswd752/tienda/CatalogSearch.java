package ec.edu.epn.iswd752.tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/** Servicio simple usado para un smoke test no funcional de rendimiento. */
public class CatalogSearch {
    public List<String> search(List<String> catalog, String term) {
        String needle = term.toLowerCase(Locale.ROOT);
        List<String> result = new ArrayList<>();
        for (String item : catalog) {
            if (item.toLowerCase(Locale.ROOT).contains(needle)) {
                result.add(item);
            }
        }
        return result;
    }
}
