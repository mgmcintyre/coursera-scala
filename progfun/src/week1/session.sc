package week1

object session {

	def gcd(x: Int, y: Int): Int =
		if (y == 0) x else gcd(y, x % y)  //> gcd: (x: Int, y: Int)Int
	
	def factorial(n: Int): Int =
		if (n == 0) 1 else n * factorial (n - 1)
                                                  //> factorial: (n: Int)Int
	
	def factorialt(n: Int): Int = {
		def loop(acc: Int, n: Int): Int = {
			if (n == 0) acc else loop(acc * n, n - 1)
		}
		loop(1, n)
	}                                         //> factorialt: (n: Int)Int
	factorialt(4)                             //> res0: Int = 24
		
}