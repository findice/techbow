package OOD_Advanced.session01_basic_concept.file_filter_system;

public final class AndFilterTreeOperator implements FilterTreeOperator {
	
	@Override
	public boolean eval(boolean left, boolean right) {
		return left && right;
	}
}
