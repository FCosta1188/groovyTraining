// Curry methods allow the creation of new closures based on existing closures, to avoid repeating code.

// curry: the arguments sequence starts from the left, following the sequence of the original closure.
def log = { String type, Date createdOn, String msg ->
    println "$createdOn [$type] - $msg"
}
log("DEBUG",new Date(),"This is my first debug statement... (log)")

def debugLog = log.curry("DEBUG") // DEBUG will be always the first param (String type) of debugLog(), which in turn will pass it to log(), so we don't have to pass it for each log entry.
debugLog(new Date(), "This is another debug statement... (debugLog)")
debugLog(new Date(), "This is one more... (debugLog)")

def todayDebugLog = log.curry("DEBUG", new Date())
todayDebugLog("This is today's debug msg... (todayDebugLog)")
println "---------------------------"


// right curry (rcurry): the arguments sequence starts from the right, reversing the sequence of the original closure.
def rCurryLog = log.rcurry("I am reverse logging... (rCurryLog)")
rCurryLog("ERROR", new Date())
println "---------------------------"


// index based currying (ncurry): the arguments are identified by their indexes in the original closure.
def nCurryLog = log.ncurry(1, new Date())
nCurryLog("ERROR","This is using ncurry... (nCurryLog)")
println "---------------------------"