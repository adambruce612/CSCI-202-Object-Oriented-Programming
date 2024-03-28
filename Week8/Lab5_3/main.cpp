#include <iostream>
#include "Person.hpp"
using namespace std;

void greet(const Person & p);

int main()
{
   // TODO:
   //   1a. Create variables to store the name and age entered in by the user.
  int age;
  string name;
   //   1b. Prompt the user for their name and age, storing the
   //      results in the variables created in step 1a.
  cout <<"Enter your name: ";
  cin >> name;
  cout << "Enter your age: ";
  cin >> age;
   //   1c. Create a Person object with the name and age that
   //      the user entered in step 1b.
  Person p(name, age);
   //   1d. Call greet, passing it the Person object created in step 1c.
  greet(p);
}

void greet(const Person & p)
{
   // TODO:
   //   Output a message greeting Person p with their name.
   //   Then tell them what their age is.
   //   Call p.getName() and p.getAge() to get p's name and
   //   age respectively.
   // Sample output:
   //   Hello SpongeBob.
   //   You are 18 years old.
  cout << "Hello "<<  p.getName()<< "." <<  endl;
  cout << "You are "<< p.getAge() << " years old."<< endl;
  
}
