//Se l'espressione e' true, l'output e' vuoto (exit code 0)

assert true
//------------

assert 1 == 1
//------------

def x = 1
assert x == 1
//assert x == 2
//------------

assert 1 == (3 + 10) * 100 / 5 * 20
//------------

def y = [1, 2, 3, 4, 5]
def z = [6, 7, 8, 9]
//asserts whether the lists are the same, meaning the same element in the same positions
assert (y << 6) == [6, 7, 8, 9, 10] //y << 6: inserts 6 at the tail of the ArrayList
assert (z << 10) == [6, 7, 8, 9, 10]
//------------
