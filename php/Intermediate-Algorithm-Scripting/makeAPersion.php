/*

Fill in the object constructor with the following methods below:

    getFirstName() getLastName() getFullName() setFirstName(first) setLastName(last) setFullName(firstAndLast)

Run the tests to see the expected output for each method.

The methods that take an argument must accept only one argument and it has to be a string.

These methods must be the only available means of interacting with the object.


*/



var Person = function(firstAndLast) {
    // Complete the method below and implement the others similarly
  
    // getters
    this.getFullName = function() {
      return firstAndLast;
    };
    this.getFirstName = function() {
      return firstAndLast.split(' ')[0];
    }
    this.getLastName = function() {
      return firstAndLast.split(' ')[1];
    }
    this.getFullName = function() {
      return firstAndLast;
    }
  
    // setters
    this.setFirstName = function(firstName){
      let nameParts = firstAndLast.split(' ')
      nameParts[0] = firstName;
      firstAndLast = nameParts.join(" ");
    }
    this.setLastName = function(lastName) {
      let nameParts = firstAndLast.split(' ')
      nameParts[1] = lastName;
      firstAndLast = nameParts.join(" ");
    }
    this.setFullName = function(fn) {
      firstAndLast = fn;
    }
  
  
    return firstAndLast;
};
  
var bob = new Person('Bob Ross');
bob.getFullName();