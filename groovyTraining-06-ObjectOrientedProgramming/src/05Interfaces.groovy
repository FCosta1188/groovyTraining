@groovy.transform.ToString
class Person {

    String first,last

}

class PersonService implements IPersonService {

    @Override
    Person find() {
        Person p = new Person(first:"Dan",last:"Vega")
        return p
    }

    @Override
    List<Person> findAll() {
        Person p1 = new Person(first:"Dan",last:"Vega")
        Person p2 = new Person(first:"Joe",last:"Vega")
        [p1,p2]
    }
}

interface IPersonService {

    Person find()

    List<Person> findAll()

}

PersonService personService = new PersonService()
println personService.find()