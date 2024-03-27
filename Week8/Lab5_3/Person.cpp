// TODO: Create the source file for class Person here.
//    Implement each function (including the constructor)
//    of Person in this file.
#include "Person.hpp"
using namespace std;

Person::Person(const string & theName, int theAge)
  : name{theName}, age{theAge}
{} // empty constructor body

const string & Person::getName() const
{
  return name;
}

int Person::getAge() 
{
  return age;
}

const void setAge(int value)
{
  age = value;
}

