# Getting Started

## GraphQL With SpringBoot:

_In this project, I have integrated spring boot with graphql and it has to entites:_
**Book and Author**

The project uses in memory **H2** database to store data and **Spring JPA** to simplify sql queries.

---

The [schema.graphql](http) file has the graphQL mutation and queries along with the custom input types.
<br>
The implementation and whole functionallity is in the controllers:,_In which methods have been created with @QueryMapping and @MutationMapping annotation to tell spring boot to automatically scan for Schemas._

---

Some Basic Queries and Mutations:

```graphql
# Passing the id as a variable.
# You can also use the default variables.
# $withFriends is a directive in graphql.
# @skip is aslo a directive
# The individual field of any Type can have arguments.
# Interfaces and Enums can also work in graphql.

query ($Id: Int, $withFriends: Boolean!) {
  getAuthor(authorId: $Id) {
    id
    name
    books {
      id
      title
      description @include(if: $withFriends)
    }
  }
}
```

Define the variables in separate JSON:

```json
{
  "Id": 1,
  "withFriends": false
}
```
