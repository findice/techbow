package OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern;

//Project: techbow
//Package: OOD_Advanced.session02_design_pattern.factory_design_pattern
// .abstract_factory_design_pattern
//ClassName: AppleFactory
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-18 星期一 20:41
public class AppleFactory implements Phone {
    
    @Override
    public void make() {
        System.out.println("Make Iphone");
    }
    
    public void makeMPB(){
        System.out.println("Make MPB");
    }
    
    
    
}
