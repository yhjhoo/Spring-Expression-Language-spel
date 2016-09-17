package springExpress.test;

import java.util.GregorianCalendar;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import springExpress.module.Inventor;
import springExpress.module.Item;

public class Test1 {
	public static void main(String[] args){
		
		{
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");
		String message = (String) exp.getValue();
		
		System.out.println(message);
		}
		
		{
			ExpressionParser parser = new SpelExpressionParser();
			Expression exp = parser.parseExpression("'Hello World'.concat('!')");
			String message = (String) exp.getValue();
			System.out.println(message);
		}
		
		
		{
			ExpressionParser parser = new SpelExpressionParser();

			// invokes 'getBytes()'
			Expression exp = parser.parseExpression("'Hello World'.bytes");
			byte[] bytes = (byte[]) exp.getValue();
		}
		
		
		{
			// Create and set a calendar
			GregorianCalendar c = new GregorianCalendar();
			c.set(1856, 7, 9);

			// The constructor arguments are name, birthday, and nationality.
			Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
			Item item = new Item();
			tesla.setItem(item );
			item.setName("haha");
			item.setTotal(11);

			ExpressionParser parser = new SpelExpressionParser();
			Expression exp = parser.parseExpression("name");

			EvaluationContext context = new StandardEvaluationContext(tesla);
			String name = (String) exp.getValue(context);
			System.out.println(name);
			
			
			{
			Expression exp1 = parser.parseExpression("item.name");

			String name1 = (String) exp1.getValue(context);
			System.out.println(name1);
			}
			
			{
			Expression exp1 = parser.parseExpression("item.total");

			Object name1 = exp1.getValue(context);
			System.out.println(name1);
			}
			
		}
	}
}
