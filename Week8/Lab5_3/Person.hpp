// TODO: Create the header file for class Person here.
#ifndef PERSON_HPP
#define PERSON_HPP

// Rest of code for this file will go in here
#include <string>

class Person
{
private:
  // private section: private class members will be added here
  std::string name;
  int age;
public:
  // public section: public class members will be added here
  // Constructor.
  // Parameter theName: the name of the person
  // Parameter theAge: the age of the person
  Person (const std::string & theName, int theAge);

  // Get the name of the person, returned as a constant reference.
  const std::string & getName() const;

  // Get the age of the person.
  int getAge() const;

  // Set the age of the person.
  void setAge(int value);
}; // END THE CLASS WITH A SEMI-COLON

#endif
