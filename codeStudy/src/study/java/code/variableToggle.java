package study.java.code;

public class variableToggle {
	public static void main(String[] args) {
		int testVariable = 1;
		if(testVariable == 1) {
			testVariable = 0;
		}else if(testVariable == 0) {
			testVariable = 1;
		}
		System.out.println(testVariable);
	
		int VariableToggle = 1;
		VariableToggle = 1 -VariableToggle;
		System.out.println(VariableToggle);
	}

}