#include "Person.hpp"

using namespace std;

Person::Person(const string & theName, int theAge)
  : name{theName}, age{theAge}
{} // empty constructor body

const string & Person::getName() const
{
  return name;
}

const int & Person::getAge() const
{
  return age;
}

const int & Person::setAge() const
{
  age = value;
}
