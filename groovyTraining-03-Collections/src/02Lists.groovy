/* http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html
An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted.
The user can access elements by their integer index (position in the list), and search for elements in the list.
Unlike sets, lists typically allow duplicate elements.
*/

def numArrayList = [1,2,3,6,7,9,4,5,3,6,8,9] // def uses ArrayList by default
List nums = [1,2,3,6,7,9,4,5,3,6,8,9]
println nums
println nums.class.name
println"-----------------------------"


// View and manipulate list items
nums.push(99)
nums.putAt(0,77)
nums[0] = 78
nums + 10 // overloaded plus() method, which does not change the original list (pushes 7 to the list)
nums << 66 // like push() method, inserts an item at the tail, modifying the original list
println nums
nums.pop() // removes the item at the head (78), same as removeAt(0)
nums.removeAt(0) // removes 1

def newNums = nums - 3 // overloaded minus() method, same as plus() (removes 3 from the list without changing the original list)
println newNums

nums = []
println nums
println"-----------------------------"

// flatten(): the list and any nested arrays or collections have their contents (recursively) added to the new List
//            (used to flatten nested array/collections). The original list won't be changed.
nums << [3,4,5]
nums << [1,2]
println nums
println nums.flatten()

// equals()
def myNumbers = [1,2,3]
def myNumbers2 = [1,2,3]
println myNumbers.equals(myNumbers2)

// findAll() with closures
println nums.flatten().findAll { it == 4 } // find all items equal to 4
println nums.flatten().findAll { it < 5 } // find all items lower than 5

// getAt(Range): gets sublist of elements found in the given index Range
println nums.flatten().getAt(0..4)
//println nums.flatten().getAt(0..5) // out of bounds

// reverse
println nums.reverse()

// unique
println nums.unique()
println"-----------------------------"

// Enforcing Java Collections: List (LinkedList), Set (SortedSet)
def evens = [10,2,8,4,24,14,2] as Set // enforced coercion
println evens
println evens.class.name
def sortedEvens = [10,2,8,4,24,14,2] as SortedSet // enforced coercion
println sortedEvens
println sortedEvens.class.name