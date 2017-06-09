# Language

- `class` is used to declare a new type. The name of the type must be a fully qualified name, i.e. including package names, e.g.: *test.MyClass*
- An **attribute** is declared as: `name : type` with type in {String, Long, Integer, Boolean, Double, *[]}
- A **relation** is declared as: `rel name : type` and optional an index, `name : type indexed by attribute1,attribute2,...`
- A **reference** is declared as `ref name : type`.
- A global **index** can be defined as `indexed by attribute1,attribute2,... as IndexName` (index is valid from beginning of time) or `indexed with time by attribute1,attribute2,... IndexName` (index is temporal).


```
class Device {
    att name: String
    att identifier: Integer
    rel modules : Module indexed by name,name2
    ref button : Button

    indexed with time by name,identifier as MyIndex
    indexed by name as MyIndex2

}

class Module {
    att name: String
    att name2: String
}

class Button {
    att name: String
}

```
