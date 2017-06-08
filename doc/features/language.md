# Language

- `class` is used to declare a new type. The name of the type must me a fully qualified name, including packages, e.g.: *test.MyClass*
- An **attribute** is declared as: `attNAme : attType` with attType in {String, Long, Integer, Boolean, Short, Double, Float}
- A **relation** is declared as: `relName : relType<[cardMin, cadMax]> <oppositeOf relName>`. The relation type must be a concept declared in the MetaModel. The cardinality is optional. The specification of the opposite relation simply requires the name of the relation in the opposite concept (the type of the relation).
- A **relation** 
- A global **index** 


```
class fsm.State {
}

class fsm.Transition {
}
```
