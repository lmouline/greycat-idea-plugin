# Language

- `class` is used to declare a new type. The name of the type must be a fully qualified name, i.e. including package names, e.g.: *test.MyClass*
- An **attribute** is declared as: `name : type` with type in {String, Long, Integer, Boolean, Double, *[]}
- A **relation** is declared as: `rel name : type` and optional an index, `name : type indexed by attribute1,attribute2,...`
- A **reference** is declared as `ref name : type`.
- A **key** can be defined as `key attribute1,attribute2,... as MyPrimaryKey` (key is valid from beginning of time) or `key with time attribute1,attribute2,... KeyName` (key is temporal).


```
class Device {
    att name: String
    att identifier: Integer
    rel modules : Module indexed by name,name2
    ref button : Button

    key with time name,identifier as MyPrimaryKey
    key name as MySecondaryKey

}

class Module {
    att name: String
    att name2: String
}

class Button {
    att name: String
}

```
