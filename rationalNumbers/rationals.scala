object rationals extends App {
	class Rational(x: Int, y: Int) {
		def num = x;
		def denum = y;

		// Make negative rational method
		def neg() = new Rational(-this.num, this.denum)
		
		// Subtract associate rationals method
		def -(r: Rational) = {
			new Rational(this.num*r.denum - this.denum*r.num, denum*r.denum)
		}

		// Print rational method
		def printline(out: String) = println(out + this.num + "/" + this.denum)
	}

	val x = new Rational(3, 4)
	val y = new Rational(5, 8)
	val z = new Rational(2, 7)
	val ans = x-y-z

	x.printline("x : ")
	y.printline("y : ")
	z.printline("z : ")
	ans.printline("x-y-z : ")
}