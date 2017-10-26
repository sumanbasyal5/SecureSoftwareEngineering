import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class SecureProgram {

	public static final String TEST_FILE = "input/Example1.java";

	public static void main(String[] args) {

		// creates an input stream for the file to be parsed
		FileInputStream in;
		try {
			in = new FileInputStream(TEST_FILE);
			try {
				// parse the file
				CompilationUnit cu = JavaParser.parse(in);
				new MyVariableVisitor().visit(cu, null);
				//new MyMethodVisitor().visit(cu, null);
				
			
			} catch (ParseException e) {
				e.printStackTrace();
			} finally {
				in.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class MyVariableVisitor extends VoidVisitorAdapter {

		@Override
		public void visit(VariableDeclarationExpr n, Object arg) {
			String line = readfile();
			List<VariableDeclarator> myVars = n.getVars();
			for (VariableDeclarator vars : myVars) {
				String mVar = vars.getId().getName();
				if(line.contains("char[]"+mVar) || line.contains("String"+mVar)){
					System.out.println("Variable Name: " + mVar);
					if(line.contains("Arrays.fill("+mVar+",'')")){
						System.out.println("Code is security compliant");
					}else{
						System.out.println("The code is not security compliant for variable : "+mVar);
					}
				}
			}
		}
		
		private String readfile(){
			BufferedReader br = null;
			String line="",templine;
        try {
            br = new BufferedReader(new FileReader("input/Example1.java"));
            
            while ((templine = br.readLine()) != null) {
                line+=templine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return line.replaceAll("\\s+","");
	}
	}

	private static class MyMethodVisitor extends VoidVisitorAdapter {
		@Override
		public void visit(MethodDeclaration n, Object arg) {
			addForStmt("memoryClear",n.getBody());
			System.out.println(n.toString());
		}

		public void addForStmt(String method,BlockStmt body) {
			int beginLine = body.getBeginLine();
			int beginColumn = body.getBeginColumn();
			int endLine = body.getEndLine();
			int endColumn = body.getEndColumn();
			
			List<Expression> init = new ArrayList<Expression>();
			Expression compare = null;
			List<Expression> update = null;
			BlockStmt methodBody = new BlockStmt();
			ForStmt forStmt = new ForStmt(beginLine+1, beginColumn, endLine, endColumn, init, compare, update, methodBody);
			ASTHelper.addStmt(body, forStmt);
		}
		
		
	}
	
	
}
