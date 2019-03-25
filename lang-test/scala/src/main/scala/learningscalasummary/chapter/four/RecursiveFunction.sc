// scala provide tail-recursion
@annotation.tailrec
// notice to compiler this function must keep tail recursion rule. if not, compile error will occur.
// because of this annotation, recursion call use stack from current function and didn't create new one.
def pow(x: Int, n: Int, curr: Long = 1): Long = {
  if (n < 1) {
    return curr
  }
  pow(x, n - 1, x * curr)
}

pow(3, 4)