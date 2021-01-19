package OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern;

//Project: techbow
//Package: OOD_Advanced.session02_design_pattern.factory_design_pattern
// .abstract_factory_design_pattern
//ClassName: HuaweiFactory
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-18 星期一 20:39
public class HuaweiFactory implements Phone {
    
    @Override
    public void make() {
        System.out.println("make HuaweiPhone");
    }
    public void makeRouter(){
        System.out.println("make HuaweiRouter");
    }
}
