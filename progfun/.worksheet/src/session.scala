import scala.annotation.tailrec

package week1

object session {

	@tailrec;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(142); 
	def gcd(x: Int, y: Int): Int =
		if (y == 0) x else gcd(y, x % y)
	
	@tailrec;System.out.println("""gcd: (x: Int, y: Int)Int""");$skip(85); 
	def factorial(n: Int): Int =
		if (n == 0) 1 else n * factorial (n - 1);System.out.println("""factorial: (n: Int)Int""")}
		
}
