'''

Fill in the object constructor with the following methods below:

    getFirstName() getLastName() getFullName() setFirstName(first) setLastName(last) setFullName(firstAndLast)

Run the tests to see the expected output for each method.

The methods that take an argument must accept only one argument and it has to be a string.

These methods must be the only available means of interacting with the object.


'''



class Person(object):

    # Constructor!
    def __init__(self, first_and_last):
        self._first, self._last = first_and_last.split(' ')
    
    # getters
    def getFullName(self):
        return self._first + ' ' + self._last
    
    def getFirstName(self):
        return self._first
    
    def getLastName(self):
        return self._last
    

    # setters
    def setFirstName(self, first):
        self._first = first
    
    def setLastName(self, last):
        self._last = last

    def setFullName(first_and_last):
        self._first, self._last = first_and_last.split(' ')



bob = Person('Bob Ross')
print(bob.getFullName())

bob.setLastName("Derpson")
print(bob.getFullName())