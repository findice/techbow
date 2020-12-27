package OOD_Advanced.session02_design_pattern.factory_design_pattern;

import OOD_Advanced.session02_design_pattern.factory_design_pattern.shape.ShapeType;

//Project: techbow
//Package: OODAdvanced.session02DesignPattern.factoryDesignPattern
//ClassName: FactoryPattern
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-03 星期四 0:07
public class FactoryPattern {
	
	public static void main(String[] args) {
		DrawingClient client = new DrawingClient();
		client.draw(ShapeType.TRIANGLE);
		client.draw(ShapeType.CIRCLE);
		client.draw(ShapeType.SQUARE);
	}
}

