import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ClassInfo {
	String packageName = "";
	String className = "";
	String lt = "";
	ArrayList<String> keywords = new ArrayList<String>();
	ArrayList<String> udis = new ArrayList<String>();
	ArrayList<String> constants = new ArrayList<String>();
	ArrayList<String> specialChars = new ArrayList<String>();
	
	LinkedHashSet<String> keywordsSet = new LinkedHashSet<String>();
	LinkedHashSet<String> udisSet = new LinkedHashSet<String>();
	LinkedHashSet<String> constantsSet = new LinkedHashSet<String>();
	LinkedHashSet<String> specialCharsSet = new LinkedHashSet<String>();
	
	int operands;
	int operators;
	int uOperands;
	int uOperators;
	PackageInfo pi = new PackageInfo();
	public void akip(String key) {
		pi.keywords.add(key);
		pi.keywordsSet.add(key);
	}
	
	public void ascip(String key) {
		pi.specialChars.add(key);
		pi.specialCharsSet.add(key);
	}
	
	public String toString() {
		return className;
	}
	
	public int getOperands() {
		//operands = keywords.size() + constants.size();
		return operands;
	}
	
	public int getOperators() {
		//operators = udis.size() + specialChars.size();
		return operators;
	}
	public int getUniqueOperands() {
		//uOperands = keywordsSet.size() + constantsSet.size();
		return uOperands;
	}
	
	public int getUniqueOperators() {
		//uOperators = udisSet.size() + specialCharsSet.size();
		return uOperators;
	}
	
	public String getString() {
		StringBuilder sb= new StringBuilder();
		if(keywordsSet.contains("class")) {
			sb.append("class");
		} else if(keywordsSet.contains("enum")) {
			sb.append("enum");
		} else if(keywordsSet.contains("interface")) {
			sb.append("interface");
		}
		sb.append(" " + className);
		sb.append("\n");
		sb.append("\tunique keywords: " + keywordsSet.size() + "  //" + keywordsSet.toString().substring(1, keywordsSet.toString().length()-1));
		sb.append("\n");
		sb.append("\tunique UDIs: " + udisSet.size() + "  //" + udisSet.toString().substring(1, udisSet.toString().length()-1));
		sb.append("\n");
		sb.append("\tunique constants: " + constantsSet.size() + "  //" + constantsSet.toString().substring(1, constantsSet.toString().length()-1));
		sb.append("\n");
		sb.append("\tunique special chars: " + specialCharsSet.size() + "  //" + specialCharsSet.toString().substring(1, specialCharsSet.toString().length()-1));
		sb.append("\n");
		sb.append("\ttotal keywords: " + keywords.size() + "  //" + keywords.toString().substring(1, keywords.toString().length()-1));
		sb.append("\n");
		sb.append("\ttotal UDIs: " + udis.size() + "  //" + udis.toString().substring(1, udis.toString().length()-1));
		sb.append("\n");
		sb.append("\ttotal constants: " + constants.size() + "  //" + constants.toString().substring(1, constants.toString().length()-1));
		sb.append("\n");
		sb.append("\ttotal special chars: " + specialChars.size() + "  //" + specialChars.toString().substring(1, specialChars.toString().length()-1));
		sb.append("\n");

		return sb.toString();
	}
	public String getStringSimple() {
		StringBuilder sb= new StringBuilder();
		if(keywordsSet.contains("class")) {
			sb.append("class");
		} else if(keywordsSet.contains("enum")) {
			sb.append("enum");
		} else if(keywordsSet.contains("interface")) {
			sb.append("interface");
		}
		sb.append(" " + className);
		sb.append("\n");
		sb.append("\tunique keywords: " + keywordsSet.size() + "  //" + keywordsSet.toString().substring(1, keywordsSet.toString().length()-1));
		sb.append("\n");
		sb.append("\tunique UDIs: " + udisSet.size() + "  //" + udisSet.toString().substring(1, udisSet.toString().length()-1));
		sb.append("\n");
		sb.append("\tunique constants: " + constantsSet.size() + "  //" + constantsSet.toString().substring(1, constantsSet.toString().length()-1));
		sb.append("\n");
		sb.append("\tunique special chars: " + specialCharsSet.size() + "  //" + specialCharsSet.toString().substring(1, specialCharsSet.toString().length()-1));
		sb.append("\n");
		sb.append("\ttotal keywords: " + keywords.size());
		sb.append("\n");
		sb.append("\ttotal UDIs: " + udis.size());
		sb.append("\n");
		sb.append("\ttotal constants: " + constants.size());
		sb.append("\n");
		sb.append("\ttotal special chars: " + specialChars.size());
		sb.append("\n");

		return sb.toString();
	}
	
	int N;
	int n;
	double V;
	double D;
	double E;
	double B;
	double T;
	
	public void caclHalstead() {
		operands = keywords.size() + constants.size();
		operators = udis.size() + specialChars.size();
		uOperands = keywordsSet.size() + constantsSet.size();
		uOperators = udisSet.size() + specialCharsSet.size();
		N = HalsteadCalculator.calcProgramLength(getOperators(), getOperands());
		n = HalsteadCalculator.calcProgramLength(getUniqueOperators(), getUniqueOperands());
		V = HalsteadCalculator.calcVolume(N, n);
		D = HalsteadCalculator.calcDifficulty(getUniqueOperators(), getOperands(), getUniqueOperands());
		E = HalsteadCalculator.calcEffort(V, D);
		T = HalsteadCalculator.calcTime(E);
		B = HalsteadCalculator.calcNumBugs(V);
	}
	
	public String getStringHalstead() {
		caclHalstead();
		StringBuilder sb = new StringBuilder();
		if(keywordsSet.contains("class")) {
			sb.append("class");
		} else if(keywordsSet.contains("enum")) {
			sb.append("enum");
		} else if(keywordsSet.contains("interface")) {
			sb.append("interface");
		}
		sb.append(" " + className);
		sb.append("\n");
		sb.append("Number of Operators(N1): " + getOperators());
		sb.append("\n");
		sb.append("Number of Operands(N2): " + getOperands());
		sb.append("\n");
		sb.append("Number of Unique Operators(n1): " + getUniqueOperators());
		sb.append("\n");
		sb.append("Number of Unique Operands(n2): " + getUniqueOperands());
		sb.append("\n");
		sb.append("Program Length(N): " + N);
		sb.append("\n");
		sb.append("Program Vocabulary(n): " + n);
		sb.append("\n");
		sb.append("Volume(V): " + V);
		sb.append("\n");
		sb.append("Difficulty(D): " + D);
		sb.append("\n");
		sb.append("Effort(E): " + E);
		sb.append("\n");
		sb.append("Time(T): " + T);
		sb.append("\n");
		sb.append("Number Of Bugs(B): " + B);
		sb.append("\n");
		
		
		return sb.toString();
	}
}
