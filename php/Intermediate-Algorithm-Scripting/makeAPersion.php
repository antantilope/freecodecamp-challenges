<?php

/*

Fill in the object constructor with the following methods below:

    getFirstName() getLastName() getFullName() setFirstName(first) setLastName(last) setFullName(firstAndLast)

Run the tests to see the expected output for each method.

The methods that take an argument must accept only one argument and it has to be a string.

These methods must be the only available means of interacting with the object.


*/

class Persion {

  function __construct($firstAndLast) {
    $parts = explode($firstAndLast, " ");
    $this->firstName = $parts[0];
    $this->lastName = $parts[1];
  }

  function getFullName() {
    return $this->firstName . ' ' . $this->lastName;
  }

  function getLastName() {
    return $this->lastName;
  }

  function getFirstName() {
    return $this->firstName;
  }
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
  

  
$bob = new Person('Bob Ross');
$bob.getFullName();