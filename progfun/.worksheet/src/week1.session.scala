package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 

	def gcd(x: Int, y: Int): Int =
		if (y == 0) x else gcd(y, x % y);System.out.println("""gcd: (x: Int, y: Int)Int""");$skip(75); 
	
	def factorial(n: Int): Int =
		if (n == 0) 1 else n * factorial (n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(138); 
	
	def factorialt(n: Int): Int = {
		def loop(acc: Int, n: Int): Int = {
			if (n == 0) acc else loop(acc * n, n - 1)
		}
		loop(1, n)
	};System.out.println("""factorialt: (n: Int)Int""");$skip(15); val res$0 = 
	factorialt(4);System.out.println("""res0: Int = """ + $show(res$0))}
		
}
