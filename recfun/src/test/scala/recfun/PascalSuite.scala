package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }
  
  test("pascal: col=4,row=4") {
    assert(pascal(4,7) === 35)
  }
  
  test("pascal: invalid column") {
    intercept[IllegalArgumentException] {
      pascal(3, 2)
    }
  }
  
  test("pascal: negative column") {
    intercept[IllegalArgumentException] {
      pascal(-1, 0)
    }
  }
  
  test("pascal: negative row") {
    intercept[IllegalArgumentException] {
      pascal(5, -5)
    }
  }
  
}
