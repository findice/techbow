package silentwing算法冲刺.session09_OOD.linux_find.filter;

import java.lang.reflect.Field;
import silentwing算法冲刺.session09_OOD.linux_find.Parameter;
import silentwing算法冲刺.session09_OOD.linux_find.entry.File;

// Step 3: Inheritance
public class FileFilter extends AbstractFilter {
    
    public FileFilter(Parameter p) {
        super(p);
    }
    
    @Override
    /*
    要file里面的所有属性和parameter里面的属性都相等，才能返回true
     */
    public boolean applyFilter(Parameter p, File file){
        /*if (p.type != null && p.size == null) {
            return file.getType().equals(p.type);
        } else if (p.type == null && p.size != null) {
            return file.getSize() == p.size;
        } else if (p.type != null && p.size != null) {
            return file.getType().equals(p.type) && file.getSize() == p.size;
        }
        return false;*/
        // follow up
        Field[] fields = p.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (!field.get(p).equals(field.get(file))) {
                    return false;
                }
            } catch (IllegalAccessException ignored) {
            }
        }
        return true;
    }
    
}
